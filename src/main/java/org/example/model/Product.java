package org.example.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String importDate;

    public Product(int id, String name, double price, int quantity, String importDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", importDate='" + importDate + '\'' +
                '}';
    }
}
