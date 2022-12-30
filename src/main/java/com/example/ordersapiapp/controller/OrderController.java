package com.example.ordersapiapp.controller;

import com.example.ordersapiapp.model.dao.client.IDaoClient;
import com.example.ordersapiapp.model.dao.order.IDaoOrder;
import com.example.ordersapiapp.model.entity.Client;
import com.example.ordersapiapp.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private IDaoOrder iDaoOrder;
    @Autowired
    private IDaoClient iDaoClient;

    @GetMapping("all")
    public List<Order> all() {
        return iDaoOrder.findAll();
    }

    @GetMapping("get")
    public Optional<Order> get(@RequestParam Integer id) {
        return iDaoOrder.findById(id);
    }

    @PostMapping("save")
    public Order save(@RequestParam String description,
                     @RequestParam Integer clientId) {
        Client client = iDaoClient.findById(clientId).get();
        Order order = new Order(description, client);
        return iDaoOrder.save(order);
    }

    @PostMapping("update")
    public Order update(@RequestParam Integer id,
                       @RequestParam String description,
                       @RequestParam Integer clientId) {
        Client client = iDaoClient.findById(clientId).get();
        Order order = new Order(description, client);
        return iDaoOrder.save(order);
    }

    @PostMapping("delete")
    public Order delete(@RequestParam Integer id) {
        return iDaoOrder.delete(id);
    }


}
