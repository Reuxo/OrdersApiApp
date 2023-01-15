package com.example.ordersapiapp.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

//сущность продукт
@Entity
@Table(name = "item_t")
public class Item {

    //поля
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 200)
    private String itemName;
    @Column(nullable = false)
    private Long itemArticle;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrdersItems> ordersItems;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemArticle() {
        return itemArticle;
    }

    public void setItemArticle(Long itemArticle) {
        this.itemArticle = itemArticle;
    }

    public Set<OrdersItems> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(Set<OrdersItems> ordersItems) {
        this.ordersItems = ordersItems;
    }

    public Item() {
        id = -1;
        itemName = "undefined";
        itemArticle = -1L;
    }

    public Item(String itemName, Long itemArticle) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    public Item(Integer id, String itemName, Long itemArticle) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemArticle=" + itemArticle +
                '}';
    }
}
