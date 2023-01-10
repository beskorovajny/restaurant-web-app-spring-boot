package com.app.web.restaurant.model;

import javax.persistence.*;

@Entity
public class ReceiptHasDish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;
    private Double price;
    private Integer count;

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
