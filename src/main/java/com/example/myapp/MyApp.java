package com.example.myapp;

import com.example.myapp.model.*;
import com.example.myapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

//вопросы
//1) на каком этапе должен быть реялизован метод добавления человека в группу

@SpringBootApplication
public class MyApp {
    private final Client_serv clientService;
    private final Groupp_serv grouppService;
    private final ClientInGroup_serv clientInGroupService;
    private final Responsibility_serv responsibilityService;
    private final Task_serv taskService;

    @Autowired
    public MyApp(Client_serv clientService, Groupp_serv grouppService, ClientInGroup_serv clientInGroupService, Responsibility_serv responsibilityService, Task_serv taskService) {
        this.clientService = clientService;
        this.grouppService = grouppService;
        this.clientInGroupService = clientInGroupService;
        this.responsibilityService = responsibilityService;
        this.taskService=taskService;

    }

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            //0) создать пользователя @@@@@@@@@@
            //1) проверка пароля @@@@@@@@@@
            //1) если этого пользователя нет - > исключение (под этим номером не зарегестрирован пользователь. создайте его) ВЫШЕ
            //2) забыли пароль-> поменять пароль  @@@@@@@@@@
            //3) хочет создать нового пользователя по занятому телефону -> создавать, только если ещё нет, если есть - исключение ВЫШЕ
            //4) удалить пользователя (наверное только для админа) @@@@@@@@@@
            //5) создать группу @@@@@@@@@@
            //6) вывести мои группы @@@@@@@@@@
            //7) добавить человека в группу @@@@@@@@@@
            //8) если хочет добавить повторно -> человек уже добавлен ВЫШЕ
            //9) удалить человека из группы @@@@@@@@@@
            //10) удалить группу @@@@@@@@@@
            //11) если человек хочет добавть группу с названием, которое у него уже есть -> исключение у вас уже есть такая группа ВЫШЕ
            //12) посмотреть людей, которые в данной группе @@@@@@@@@@
            //13) найти созданного пользователя @@@@@@@@@@
            //14) посмотреть все классы проверить все поля и методы



                    // Создаем клиента
            /*Client client = clientService.createClient("89178127381", "1234", "Nastyaa");

            // Создаем группу
            Groupp groupp =grouppService.createGroup("Alex");

            // Создаем связь клиента и группы
            ClientInGroup clientInGroup =clientInGroupService.createClientInGroup(client, groupp);


            // Выводим сохраненные данные
            System.out.println("Saved Client in Group: " + clientInGroupService.getClientInGroupByKey(clientInGroup.getKey()));

            // Выводим сохраненные данные
            System.out.println("Saved Client: " + clientService.getClientById(client.getClientId()));

            // Выводим сохраненные данные
            System.out.println("Saved Group: " + grouppService.getGroupById(groupp.getGroupId()));*/




            //удалить связь клиента и группы (у нас работает каскадное удаление)
            /*Client client = clientService.getClientById(1L);
            Groupp groupp = grouppService.getGroupById(1L);
            clientInGroupService.deleteClientInGroup(client, groupp);
            //удалить клиента
            clientService.deleteClient(1L);
            //удалить группу
            grouppService.deleteGroup(1L);*/



            //найти созданного пользователя по его номеру телефона
            /*Client client=clientService.getClientByPhoneNumber("89178127389");
            System.out.println("Client 8917..." + client);*/

            //поменять пароль/имя/yjvth
            /*Client client = clientService.getClientById(1L);
            clientService.updateClientPassword(client, "12345");
            clientService.updateClientPassword(1L, "12345");
            clientService.updateClientName(client, "Nastya");
            clientService.updateClientName(1L, "Nastya");
            clientService.updateClientPhone(client, "Nastya");
            clientService.updateClientPhone(1L, "Nastya");*/


            //вывести мои группы
            /*System.out.println(clientService.getClientGroups(1L));*/

            //добавить челоека в группу
            /*Client client = clientService.getClientById(1L);
            Groupp groupp = grouppService.getGroupById(1L);
            ClientInGroup clientInGroup = clientInGroupService.createClientInGroup(client, groupp);
            System.out.println(clientInGroup.getKey());*/


            //вывести людей данной группы
            /*System.out.println(grouppService.getGroupClients(1L));*/

            //проверить пароль
            /*Client client = clientService.getClientById(1L);
            System.out.println(client.checkPassword("12345"));*/



            ////////////////////////////////////////////////////////////////////////////////////////////////////////////


            // Создаем обязанность
            /*Responsibility responsibility = responsibilityService.createResponsibility("cook", "food.png");
            // Выводим сохраненные данные
            System.out.println("Saved Responsibility: " + responsibilityService.getResponsibilityById(responsibility.getResponsibilityId()));*/

            //удалить обязанность
            /*responsibilityService.deleteResponsibility(1l);*/



            //создать задание
            /*Client client = clientService.getClientById(1L);
            ClientInGroup clientInGroup = clientInGroupService.getClientInGroupByClientAndGroup(1L, 1L);
            Responsibility responsibility = responsibilityService.getResponsibilityById(1L);
            LocalDate today = LocalDate.now();
            Task task = new Task(clientInGroup, today , responsibility, client);
            task = taskService.saveTask(task);
            System.out.println("Saved Task: " + taskService.getTaskByKey(task.getTaskId()));*/


            //все задения группы
            /*System.out.println(taskService.getTasksByGroup(1L));
            LocalDate today = LocalDate.now();
            System.out.println(taskService.getGroupTasksForDate(1L, today));*/


            //все задения клиента в группе
            /*System.out.println(clientInGroupService.getClientInGroupTasks(1L, 1L));*/

        };
    }
}