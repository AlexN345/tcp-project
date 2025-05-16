

package com.example.myapp.service;

import com.example.myapp.exception.UserAlreadyExistsException;
import com.example.myapp.model.Client;
import com.example.myapp.model.ClientInGroup;
import com.example.myapp.model.Groupp;
import com.example.myapp.repository.Client_rep;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

@Service
public class Client_serv implements UserDetailsService {

    //@Autowired
    private Client_rep client_rep;

    @Autowired
    public Client_serv(Client_rep client_rep) {
        this.client_rep = client_rep;
    }


    public List<Client> getAllClients() {
        return client_rep.findAll();
    }


    public Client getClientById (Long clientId) {
        return client_rep.findById(clientId).orElse(null);
    }
    public Client getClientByPhoneNumber(String phoneNumber) {
        return client_rep.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Client not found with phone: " + phoneNumber));
    }

    public Client saveClient(Client client) {
        return client_rep.save(client);
    }

    public Client createClient(String phoneNumber, String password, String name) {
        Client client = new Client(phoneNumber, password, name);
        return client_rep.save(client);
    }


    public Client updateClient(Client client) {
        return client_rep.save(client);
    }

    public Client updateClientPassword(Client client, String password) {
        client.setPassword(password);
        return client_rep.save(client);
    }
    public Client updateClientPassword(Long clientId, String password) {
        Client client =client_rep.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setPassword(password);
        return client_rep.save(client);
    }

    public Client updateClientName(Client client, String name) {
        client.setName(name);
        return client_rep.save(client);
    }
    public Client updateClientName(Long clientId, String name) {
        Client client =client_rep.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(name);
        return client_rep.save(client);
    }

    public Client updateClientPhone(Client client, String phone) {
        client.setPhoneNumber(phone);
        return client_rep.save(client);
    }
    public Client updateClientPhone(Long clientId, String phone) {
        Client client =client_rep.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setPhoneNumber(phone);
        return client_rep.save(client);
    }

    public void deleteClient(Long clientId) {
        client_rep.deleteById(clientId);
    }

    @Transactional
    public Client getClientWithGroups(Long clientId) {
        Client client = client_rep.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        // Инициализируем коллекцию
        Hibernate.initialize(client.getClientGroups());
        return client;
    }
    @Transactional
    public Client getClientByPhoneNumberWithGroups(String phoneNumber) {
        Client client = client_rep.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        // Инициализируем коллекцию
        Hibernate.initialize(client.getClientGroups());
        return client;
    }
    @Transactional
    public Client getClientByIdWithGroups(Long Id) {
        Client client = client_rep.findById(Id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        // Инициализируем коллекцию
        Hibernate.initialize(client.getClientGroups());
        return client;
    }

    @Transactional
    public Set<Groupp> getClientGroups(Long clientId) {
        Client client = client_rep.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        // Инициализируем коллекцию
        Hibernate.initialize(client.getClientGroups());
        return client.getClientGroups();
    }

    @Transactional
    public Client registerClient(Client client) {
        // Проверяем существование пользователя
        if (client_rep.existsByPhoneNumber(client.getPhoneNumber())) {
            throw new UserAlreadyExistsException(
                    "Пользователь с телефоном " + client.getPhoneNumber() + " уже существует"
            );
        }

        return client_rep.save(client);
    }
    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        System.out.println("Client_serv  loadUserByUsername!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Client сlient = getClientByPhoneNumber(phoneNumber);
        System.out.println("1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (Objects.isNull(сlient)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", сlient));
        }                                //возможно стоит добавить роли
        System.out.println("2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return new org.springframework.security.core.userdetails.User(сlient.getPhoneNumber(), сlient.getPassword(), true, true, true, true, new HashSet<>());
    }


}




