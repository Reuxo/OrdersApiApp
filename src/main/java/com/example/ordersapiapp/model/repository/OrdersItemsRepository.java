package com.example.ordersapiapp.model.repository;

import com.example.ordersapiapp.model.entity.OrdersItems;
import org.springframework.data.repository.CrudRepository;

public interface OrdersItemsRepository extends CrudRepository<OrdersItems, Integer> {
}
