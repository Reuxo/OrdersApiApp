package com.example.ordersapiapp.controller;


import com.example.ordersapiapp.model.dao.item.IDaoItem;
import com.example.ordersapiapp.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/item")
public class ItemController {

@Autowired
private IDaoItem iDaoItem;

    @GetMapping("all")
    public List<Item> all() {
        return  iDaoItem.findAll();
    }

    @GetMapping("/ping")
    public String ping() {
        return "Item Pong";
    }
}
