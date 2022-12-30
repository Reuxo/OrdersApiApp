package com.example.ordersapiapp.model.dao.client;

import com.example.ordersapiapp.model.entity.Client;
import com.example.ordersapiapp.model.entity.Item;
import com.example.ordersapiapp.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoClient implements IDaoClient{

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        if(clientRepository.findById(client.getId()).isPresent())
        {
            return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public Client delete(Integer id) {
        clientRepository.deleteById(id);
        return null;
    }
}
