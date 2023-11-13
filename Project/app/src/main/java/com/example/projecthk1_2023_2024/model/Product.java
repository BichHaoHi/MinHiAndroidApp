package com.example.projecthk1_2023_2024.model;

public class Product {
    String Name;
    String Link_Photo;
    int Quantity;
    int Quantity_stock;

    public Product() {
    }

    public Product(String name, String link_Photo, int quantity, int quantity_Stock) {
        Name = name;
        Link_Photo = link_Photo;
        Quantity = quantity;
        Quantity_stock = quantity_Stock;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLink_Photo() {
        return Link_Photo;
    }

    public void setLink_Photo(String link_Photo) {
        Link_Photo = link_Photo;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity_Stock() {
        return Quantity_stock;
    }

    public void setQuantity_Stock(int quantity_Stock) {
        Quantity_stock = quantity_Stock;
    }
}
