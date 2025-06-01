



package com.example.myapp.controller;

import com.example.myapp.model.Client;
import com.example.myapp.model.ClientGroupId;
import com.example.myapp.model.ClientInGroup;
import com.example.myapp.model.Groupp;
import com.example.myapp.service.ClientInGroup_serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client_in_group")
public class ClientInGroup_cont {

    private final ClientInGroup_serv client_in_group_serv;

    @Autowired
    public ClientInGroup_cont(ClientInGroup_serv client_in_group_serv) {
        this.client_in_group_serv = client_in_group_serv;
    }

    @GetMapping
    public List<ClientInGroup> getAllClientInGroups() {
        return client_in_group_serv.getAllClientInGroups();
    }

    @GetMapping("/{id}")
    public ClientInGroup getClientInGroupById(@PathVariable ClientGroupId Key) {
        return client_in_group_serv.getClientInGroupByKey(Key);
    }

    @PostMapping
    public ClientInGroup createClientInGroup(@RequestBody ClientInGroup client_in_group) {
        return client_in_group_serv.saveClientInGroup(client_in_group);
    }


    /*@DeleteMapping("/{groupId}/{clientId}")//пока не знаю, как сделать
    public void deleteClientInGroup(
            @PathVariable String phone_number,
            @PathVariable Long groupId) {
        Client client = clientService.getClientByNumber("89178127389");
        Groupp groupp = grouppService.getGroupById(27L);
        client_in_group_serv.deleteClientInGroup(key);
    }*/

    /*@GetMapping("/{groupId}/{clientId}")// пока нам это не нужно, так как класс состоит только из Key, если будем добавлять - раскомментируем
    public client_in_group getClientInGroupById(
            @PathVariable Long clientId,
            @PathVariable Long groupId) {
        ClientGroupId Key = new ClientGroupId(clientId, groupId);
        return client_in_group_serv.getClientInGroupByKey(Key);
    }

    @PutMapping("/{groupId}/{clientId}")
    public client_in_group updateClientInGroup(
            @PathVariable Long clientId,
            @PathVariable Long groupId,
            @RequestBody client_in_group client_in_group) {
        ClientGroupId key = new ClientGroupId(clientId, groupId);
        client_in_group.setKey(key);
        return client_in_group_serv.updateClientInGroup(client_in_group);
    }
    */
}