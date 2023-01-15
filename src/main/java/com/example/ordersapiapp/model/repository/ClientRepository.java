package com.example.ordersapiapp.model.repository;

import com.example.ordersapiapp.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
