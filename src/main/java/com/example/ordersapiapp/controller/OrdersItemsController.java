package com.example.ordersapiapp.controller;

import com.example.ordersapiapp.model.dao.OrdersItems.IDaoOrdersItems;
import com.example.ordersapiapp.model.dao.client.IDaoClient;
import com.example.ordersapiapp.model.dao.item.IDaoItem;
import com.example.ordersapiapp.model.dao.order.IDaoOrder;
import com.example.ordersapiapp.model.entity.Item;
import com.example.ordersapiapp.model.entity.Order;
import com.example.ordersapiapp.model.entity.OrdersItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "orders_items")
public class OrdersItemsController {

    @Autowired
    private IDaoOrder iDaoOrder;
    @Autowired
    private IDaoItem iDaoItem;
    @Autowired
    private IDaoOrdersItems iDaoOrdersItems;

    @GetMapping("all")
    public List<OrdersItems> all() {
        return iDaoOrdersItems.findAll();
    }

    @GetMapping("get")
    public Optional<OrdersItems> get(@RequestParam Integer id) {
        return iDaoOrdersItems.findById(id);
    }

    @PostMapping("save")
    public OrdersItems save(@RequestParam Long quantity,
                            @RequestParam Integer itemId,
                            @RequestParam Integer orderId) {
        if (iDaoItem.findById(itemId).isEmpty() && iDaoOrder.findById(orderId).isEmpty()) {
            return null;
        }
        return iDaoOrdersItems.save(new OrdersItems(
                quantity,
                iDaoItem.findById(itemId).get(),
                iDaoOrder.findById(orderId).get()));
    }

    @PostMapping("update")
    public OrdersItems update(@RequestParam Integer id,
                              @RequestParam Long quantity,
                              @RequestParam Integer itemId,
                              @RequestParam Integer orderId) {

        if (iDaoItem.findById(itemId).isEmpty() && iDaoOrder.findById(orderId).isEmpty()) {
            return null;
        }
        Item item = iDaoItem.findById(itemId).get();
        item.setId(itemId);
        Order order = iDaoOrder.findById(orderId).get();
        order.setId(orderId);
        OrdersItems ordersItems = new OrdersItems(iDaoOrdersItems.findById(id).get().getId(),
                quantity,
                item,
                order);
        return iDaoOrdersItems.save(ordersItems);
    }

    @PostMapping("delete")
    public OrdersItems delete(@RequestParam Integer id) {
        return iDaoOrdersItems.delete(id);
    }

}
