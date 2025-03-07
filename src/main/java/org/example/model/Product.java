package org.example.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private int quantity;
    private LocalDate importDate;


    public Product(int id, String name, double unitPrice, int quantity, LocalDate importDate) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.importDate = importDate;
    }
}
