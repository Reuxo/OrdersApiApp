package com.example.ordersapiapp.model.dao.item;

import com.example.ordersapiapp.model.entity.Item;
import com.example.ordersapiapp.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Имплементация DAO для сущности Item, использует CrudRepository
@Service
public class DbDaoItem implements IDaoItem {

    @Autowired
    private  ItemRepository itemRepository;
    @Override
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item e) {
        return itemRepository.save(e);
    }

    @Override
    public Item update(Item item) {

        if(itemRepository.findById(item.getId()).isPresent()) {
          return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public Item delete(Integer id) {
        itemRepository.deleteById(id);
        return null;
    }
}
