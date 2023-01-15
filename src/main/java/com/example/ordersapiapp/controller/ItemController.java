package com.example.ordersapiapp.controller;


import com.example.ordersapiapp.model.dao.item.IDaoItem;
import com.example.ordersapiapp.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private IDaoItem iDaoItem;

    @GetMapping("all")
    public List<Item> all() {
        return iDaoItem.findAll();
    }

    @GetMapping("get")
    public Optional<Item> get(@RequestParam Integer id) {
        return iDaoItem.findById(id);
    }

    @PostMapping("save")
    public Item save(@RequestParam String itemName,
                     @RequestParam Long itemArticle) {
        Item item = new Item(itemName, itemArticle);
        return iDaoItem.save(item);
    }

    @PostMapping("update")
    public Item update(@RequestParam Integer id,
                       @RequestParam String itemName,
                       @RequestParam Long itemArticle) {

        Item item = iDaoItem.findById(id).get();
        item.setItemName(itemName);
        item.setItemArticle(itemArticle);
        return iDaoItem.update(item);
    }

    @PostMapping("delete")
    public Item delete(@RequestParam Integer id) {
        return iDaoItem.delete(id);
    }

    @GetMapping("/ping")
    public String ping() {
        return "Item Pong";
    }
}
