package com.example.myapp.controller;

import com.example.myapp.dto.ClientShortDto;
import com.example.myapp.dto.TaskDto;
import com.example.myapp.mapper.ClientMapper;
import com.example.myapp.mapper.TaskMapper;
import com.example.myapp.model.*;
import com.example.myapp.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final Task_serv taskService;
    private final Client_serv clientService;
    private final Groupp_serv groupService;
    private final Responsibility_serv responsibilityService;
    private final ClientInGroup_serv clientInGroupServ;
    private final ClientMapper clientMapper;
    private final TaskMapper taskMapper;

    public TaskController(Task_serv taskService, Client_serv clientService,
                          Groupp_serv groupService, Responsibility_serv responsibilityService, ClientInGroup_serv clientInGroupServ, ClientMapper clientMapper, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.clientService = clientService;
        this.groupService = groupService;
        this.responsibilityService = responsibilityService;
        this.clientInGroupServ =clientInGroupServ;
        this.clientMapper =clientMapper;
        this.taskMapper =taskMapper;
    }

    @GetMapping
    public String showTasks(@RequestParam Long groupId,
                            @RequestParam(required = false) LocalDate date,
                            Authentication authentication,
                            Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Client currentUser = clientService.getClientByPhoneNumber(userDetails.getUsername());
        Groupp group = groupService.getGroupById(groupId);

        LocalDate startDate = date != null ? date : LocalDate.now();
        startDate = startDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endDate = startDate.plusDays(6);

        List<Task> tasks = taskService.getGroupTasksForPeriod(groupId, startDate, endDate);

        List<TaskDto> taskDtos = tasks.stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());


        List<Client> groupMembers = new ArrayList<>(groupService.getGroupClients(groupId));

        List<ClientShortDto> groupMemberDTOs = groupMembers.stream()
                .map(clientMapper::toClientShortDto)
                .collect(Collectors.toList());


        ClientShortDto currentUserDto = clientMapper.toClientShortDto(currentUser);

        model.addAttribute("currentUser", currentUserDto);
        model.addAttribute("group", group);
        model.addAttribute("tasks", taskDtos);//дто для задания
        model.addAttribute("groupMembers", groupMemberDTOs);
        model.addAttribute("responsibilities", responsibilityService.getAllResponsibilities());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("weekDays", getWeekDays(startDate));

        return "tasks";
    }

    private List<LocalDate> getWeekDays(LocalDate startDate) {
        List<LocalDate> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(startDate.plusDays(i));
        }
        return days;
    }

    // Удаление задания
    @PostMapping("/delete")
    public String deleteTask(@RequestParam Long taskId,
                             @RequestParam Long groupId,
                             @RequestParam LocalDate date,
                             RedirectAttributes redirectAttributes) {
        try {
            taskService.deleteTask(taskId);
            redirectAttributes.addFlashAttribute("successMessage", "Задание успешно удалено");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при удалении задания");
        }
        return "redirect:/tasks?groupId=" + groupId + "&date=" + date;
    }

    // Показ формы добавления задания
    @GetMapping("/add")
    public String showAddTaskForm(@RequestParam Long groupId,
                                  @RequestParam LocalDate date,
                                  Model model) {
        List<Client> groupMembers = new ArrayList<>(groupService.getGroupClients(groupId));

        List<ClientShortDto> groupMemberDTOs = groupMembers.stream()
                .map(clientMapper::toClientShortDto)
                .collect(Collectors.toList());
        model.addAttribute("groupId", groupId);
        model.addAttribute("date", date);
        model.addAttribute("responsibilities", responsibilityService.getAllResponsibilities());
        model.addAttribute("groupMembers", groupMemberDTOs); // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return "add-task";
    }

    // Обработка добавления задания
    @PostMapping("/add")
    public String addTask(@RequestParam Long groupId,
                          @RequestParam LocalDate date,
                          @RequestParam Long responsibilityId,
                          @RequestParam Long executorId,
                          Authentication authentication,
                          RedirectAttributes redirectAttributes) {

        try {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Client author = clientService.getClientByPhoneNumber(userDetails.getUsername());
            Client executor = clientService.getClientById(executorId);
            Responsibility responsibility = responsibilityService.getResponsibilityById(responsibilityId);

            ClientInGroup clientInGroup = clientInGroupServ.getClientInGroupByClientAndGroup(executorId, groupId);

            Task task = new Task(clientInGroup, date, responsibility, author, executor);
            taskService.saveTask(task);

            redirectAttributes.addFlashAttribute("successMessage", "Задание успешно добавлено");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при добавлении задания");
        }

        return "redirect:/tasks?groupId=" + groupId + "&date=" + date;
    }
}