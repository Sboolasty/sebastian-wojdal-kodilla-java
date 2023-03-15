package com.example.kodillagoodpatterns.challenges.Food2Door;

public class Order {
    private Supplier supplier;
    private int quantity;
    private String product;

    public Order(Supplier supplier, int quantity, String product) {
        this.supplier = supplier;
        this.quantity = quantity;
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}