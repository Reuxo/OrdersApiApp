package com.example.ordersapiapp.model.dao.item;


import com.example.ordersapiapp.model.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

//dao - интерфейс для сущности Item

public interface IDaoItem {
    List<Item> findAll();       // получить все объекты

    Item findById(Integer id);  // получить объект по id

    Item save(Item item);       //сохранить

    Item update(Item item);     //обновить

    void delete(Integer id);    // удалить объект
}
