package com.example.ordersapiapp.controller;

import com.example.ordersapiapp.model.dao.client.IDaoClient;
import com.example.ordersapiapp.model.entity.Client;
import com.example.ordersapiapp.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private IDaoClient iDaoClient;

    @GetMapping("all")
    public List<Client> all() {
        return iDaoClient.findAll();
    }

    @GetMapping("get")
    public Optional<Client> get(@RequestParam Integer id) {
        return iDaoClient.findById(id);
    }

    @PostMapping("save")
    public Client save(@RequestParam String nameClient) {
        Client client = new Client(nameClient);
        return iDaoClient.save(client);
    }

    @PostMapping("update")
    public Client update(@RequestParam Integer id,
                         @RequestParam String nameClient) {
        Client client = iDaoClient.findById(id).get();

            client.setNameClient(nameClient);

        return iDaoClient.save(client);
    }

    @PostMapping("delete")
    public Client delete(@RequestParam Integer id) {
        return iDaoClient.delete(id);
    }

}
