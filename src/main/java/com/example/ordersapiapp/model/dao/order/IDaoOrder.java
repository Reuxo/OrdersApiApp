package com.example.ordersapiapp.model.dao.order;

import com.example.ordersapiapp.model.dao.IDaoBase;
import com.example.ordersapiapp.model.entity.Item;
import com.example.ordersapiapp.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IDaoOrder extends IDaoBase<Order> {
    Optional<Order> findById(Integer id);
}
