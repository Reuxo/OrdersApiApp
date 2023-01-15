package com.example.ordersapiapp.model.repository;

import com.example.ordersapiapp.model.entity.Item;
import org.springframework.data.repository.CrudRepository;

// Jpa Repository для работы с Item
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
