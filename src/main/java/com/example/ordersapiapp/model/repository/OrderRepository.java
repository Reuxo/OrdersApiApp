package com.example.ordersapiapp.model.repository;

import com.example.ordersapiapp.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
