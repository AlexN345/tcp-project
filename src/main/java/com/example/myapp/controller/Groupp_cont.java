package com.example.myapp.controller;

import com.example.myapp.dto.GroupDto;
import com.example.myapp.model.Client;
import com.example.myapp.model.Groupp;
import com.example.myapp.service.ClientInGroup_serv;
import com.example.myapp.service.Client_serv;
import com.example.myapp.service.Groupp_serv;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/groups")
public class Groupp_cont {

    private final Groupp_serv groupService;
    private final Client_serv clientService;

    private final ClientInGroup_serv clientInGroupService;
    public Groupp_cont(Groupp_serv groupService, Client_serv clientService, ClientInGroup_serv clientInGroupService) {
        this.groupService = groupService;
        this.clientService = clientService;
        this.clientInGroupService = clientInGroupService;
    }

    @GetMapping
    public String showGroupsPage(Model model, Authentication authentication) {
        // Удаляем сообщение об ошибке при перезагрузке
        model.addAttribute("errorMessage", null);
        model.addAttribute("showJoinModal", false); // Добавляем флаг по умолчанию
        // Получаем текущего аутентифицированного пользователя
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String phoneNumber = userDetails.getUsername();
        System.out.println("!!!!!!!!!!!!!!");
        System.out.println(phoneNumber);

        // Получаем клиента и его группы
        Client client = clientService.getClientByPhoneNumber(phoneNumber);
        Set<Groupp> groups = clientService.getClientGroups(client.getClientId());

        // Преобразуем группы в DTO для отображения
        List<GroupDto> groupDtos = groups.stream()
                .map(group -> new GroupDto(
                        group.getGroupId(),
                        group.getName(),
                        groupService.getGroupClients(group.getGroupId()).size()))
                .collect(Collectors.toList());

        model.addAttribute("groups", groupDtos);
        model.addAttribute("currentUser", client.getName());
        return "groups";
    }




    @GetMapping("/test")
    public String test( Authentication authentication) {
        System.out.println("11111");
        return null;
    }

    @PostMapping("/create")
    public String createGroup(@RequestParam String groupName, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String phoneNumber = userDetails.getUsername();
        Client client = clientService.getClientByPhoneNumberWithGroups(phoneNumber);

        // Проверяем, есть ли уже группа с таким именем у пользователя
        boolean groupExists = client.getClientGroups().stream()
                .anyMatch(g -> g.getName().equalsIgnoreCase(groupName));

        if (!groupExists) {//нужно добавить обработку исключений
            Groupp newGroup = groupService.createGroup(groupName);
            clientInGroupService.createClientInGroup(client, newGroup);
        }

        return "redirect:/groups";
    }

    @PostMapping("/leave")
    public String leaveGroup(@RequestParam Long groupId, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String phoneNumber = userDetails.getUsername();
        Client client = clientService.getClientByPhoneNumber(phoneNumber);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(client);
        Groupp group = groupService.getGroupById(groupId);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(group);
        clientInGroupService.deleteClientInGroup(client, group);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // Если в группе не осталось участников - удаляем группу
        if (groupService.getGroupClients(groupId).isEmpty()) {
            groupService.deleteGroup(groupId);
        }

        return "redirect:/groups";
    }

    @PostMapping("/join")
    public String joinGroup(@RequestParam Long groupId, Authentication authentication, RedirectAttributes redirectAttributes) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String phoneNumber = userDetails.getUsername();
        Client client = clientService.getClientByPhoneNumber(phoneNumber);
        try {
            Groupp group = groupService.getGroupById(groupId);

            // Проверяем, не состоит ли уже пользователь в этой группе
            if (clientInGroupService.getClientInGroupByClientAndGroup(client.getClientId(), groupId) == null) {
                clientInGroupService.createClientInGroup(client, group);
            }
            else {
                redirectAttributes.addFlashAttribute("errorMessage", "Вы уже состоите в этой группе");
                redirectAttributes.addFlashAttribute("showJoinModal", true);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Группы с таким ID не существует");
            redirectAttributes.addFlashAttribute("showJoinModal", true);
        }
        return "redirect:/groups";

    }
    /*@PostMapping
    public Groupp createGroup(@RequestBody Groupp groupp) {
        return groupp_serv.saveGroup(groupp);
    }

    @PutMapping("/{id}")
    public Groupp updateGroup(@PathVariable Long id, @RequestBody Groupp groupp) {
        groupp.setGroupId(id);
        return groupp_serv.updateGroup(groupp);
    }

    @GetMapping("/{id}")
    public Groupp test (@PathVariable Long id) {
        return groupService.getGroupById(id);
    }*/
}
