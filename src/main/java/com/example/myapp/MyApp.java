package com.example.myapp;

import com.example.myapp.model.*;
import com.example.myapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class MyApp {
    private final Client_serv clientService;
    private final Groupp_serv grouppService;
    private final ClientInGroup_serv clientInGroupService;

    @Autowired
    public MyApp(Client_serv clientService, Groupp_serv grouppService, ClientInGroup_serv clientInGroupService) {
        this.clientService = clientService;
        this.grouppService = grouppService;
        this.clientInGroupService = clientInGroupService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            // Создаем клиента
            Client client = new Client();
            client.setClientNumber("89178127388");
            client.setPassword("12345");


            // Создаем группу
            Groupp groupp = new Groupp();
            groupp.setName("Alex");



            // Создаем связь клиента и группы
            ClientInGroup clientInGroup = new ClientInGroup();
            clientInGroup.setClient(client);
            clientInGroup.setGroup(groupp);
            clientInGroupService.createClientInGroup(clientInGroup);

            ClientGroupId key = clientInGroup.getKey();


            // Выводим сохраненные данные
            /*Client savedClient = clientService.getClientByNumber(client.getClientNumber());
            System.out.println("Saved Client: " + savedClient);*/

            // Выводим сохраненные данные
            Groupp savedGroupp = grouppService.getGroupById(groupp.getGroupId());
            System.out.println("Saved Group: " + savedGroupp);


            // Выводим сохраненные данные
            ClientInGroup savedClientInGroup = clientInGroupService.getClientInGroupByKey(key);
            System.out.println("Saved Client in Group: " + savedClientInGroup);


            /*//удалить связь клиента и группы
            ClientGroupId key = new ClientGroupId("89178127388", 3L);
            clientInGroupService.deleteClientInGroup(key);
            //удалить клиента
            clientService.deleteClient("89178127388");
            //удалить группу
            grouppService.deleteGroup(3L);*/




        };
    }
}