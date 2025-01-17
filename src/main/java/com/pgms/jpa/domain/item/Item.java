package com.pgms.jpa.domain.item;

import com.pgms.jpa.global.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "item_name", nullable = false, length = 20)
    private String itemName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "quantity", nullable = false)
    private int quantity; // 총 재고

    protected Item() {

    }

    public Item(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addStock(int orderItemQuantity) {
        this.quantity += orderItemQuantity;
    }


    public void removeQuantity(int stock) {
        if (stock > this.quantity) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.quantity -= stock;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
