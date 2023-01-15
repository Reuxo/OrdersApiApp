package com.example.ordersapiapp.model.dao.order;

import com.example.ordersapiapp.model.entity.Order;
import com.example.ordersapiapp.model.repository.ClientRepository;
import com.example.ordersapiapp.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoOrder implements IDaoOrder{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        if(orderRepository.findById(order.getId()).isPresent()){
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order delete(Integer id) {
        orderRepository.deleteById(id);
        return null;
    }
}
