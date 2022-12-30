package com.example.ordersapiapp.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "orders_t")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrdersItems> ordersItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrdersItems> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(Set<OrdersItems> ordersItems) {
        this.ordersItems = ordersItems;
    }

    public Order() {
    }

    public Order(String description, Client client) {
        this.description = description;
        this.client = client;
    }


    public Order(Integer id, String description, Client client) {
        this.id = id;
        this.description = description;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", client=" + client +
                '}';
    }
}
