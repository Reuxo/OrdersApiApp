package com.example.ordersapiapp.model.dao.OrdersItems;

import com.example.ordersapiapp.model.dao.order.IDaoOrder;
import com.example.ordersapiapp.model.entity.Order;
import com.example.ordersapiapp.model.entity.OrdersItems;
import com.example.ordersapiapp.model.repository.OrdersItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DbDaoOrdersItems implements IDaoOrdersItems {

    @Autowired
    public OrdersItemsRepository ordersItemsRepository;

    @Override
    public List<OrdersItems> findAll() {
        return (List<OrdersItems>) ordersItemsRepository.findAll();
    }

    @Override
    public Optional<OrdersItems> findById(Integer id) {
        return ordersItemsRepository.findById(id);
    }

    @Override
    public OrdersItems save(OrdersItems ordersItems) {
        return ordersItemsRepository.save(ordersItems);
    }

    @Override
    public OrdersItems update(OrdersItems ordersItems) {
        if(ordersItemsRepository.findById(ordersItems.getId()).isPresent()){
            return ordersItemsRepository.save(ordersItems);
        }
        return null;
    }

    @Override
    public OrdersItems delete(Integer id) {
        ordersItemsRepository.deleteById(id);
        return null;
    }
}
