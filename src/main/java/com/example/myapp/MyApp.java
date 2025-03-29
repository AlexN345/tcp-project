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

    @Autowired
    public MyApp(Client_serv clientService, Groupp_serv grouppService) {
        this.clientService = clientService;
        this.grouppService = grouppService;
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
            clientService.createClient(client);

            // Выводим сохраненные данные
            Client savedClient = clientService.getClientByNumber(client.getClientNumber());
            System.out.println("Saved Client: " + savedClient);

            // Создаем группу
            Groupp groupp = new Groupp();
            groupp.setName("Alex");
            grouppService.createGroup(groupp);

            // Выводим сохраненные данные
            Groupp savedGroupp = grouppService.getGroupById(groupp.getGroupId());
            System.out.println("Saved Group: " + savedGroupp);


        };
    }
}