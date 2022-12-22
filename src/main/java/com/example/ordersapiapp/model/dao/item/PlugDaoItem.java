package com.example.ordersapiapp.model.dao.item;

import com.example.ordersapiapp.model.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlugDaoItem implements IDaoItem{

    private static List<Item> items = Arrays.asList(
            new Item(1, "Телевизор", 111L),
            new Item(2, "Холодильник", 222L),
            new Item(3, "X-Box", 333L)
    );


    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public Item findById(Integer id) {
        return null;
    }

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
