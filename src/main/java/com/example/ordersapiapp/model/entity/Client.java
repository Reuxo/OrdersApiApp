package com.example.ordersapiapp.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client_t")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String nameClient;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Client() {
    }

    public Client(String nameClient) {
        this.nameClient = nameClient;
    }

    public Client(Integer id, String nameClient) {
        this.id = id;
        this.nameClient = nameClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nameClient='" + nameClient + '\'' +
                '}';
    }
}
