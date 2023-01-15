package com.example.ordersapiapp.model.dao;

import com.example.ordersapiapp.model.entity.Item;

import java.util.List;
import java.util.Optional;

public interface IDaoBase <E>{

    List<E> findAll();       // получить все объекты

    Optional<E> findById(Integer id);  // получить объект по id

    E save(E e);       //сохранить

    E update(E e);     //обновить

    E delete(Integer id);    // удалить объект

}
