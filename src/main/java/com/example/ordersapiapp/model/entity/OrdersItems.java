package com.example.ordersapiapp.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OredersItems_t")
public class OrdersItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private Long quantity; //Кол-во единиц товаров

    @ManyToOne
    @JoinColumn(name = "item_id" , nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



    public OrdersItems() {
    }

    public OrdersItems(Integer id, Long quantity, Item item, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrdersItems{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", item=" + item +
                ", order=" + order +
                '}';
    }
}
