package com.example.projecthk1_2023_2024.model;

public class Product {
    String Name;
    String Link_Photo;
    int Quantity;
    int Quantity_Valid;
    int Quantity_stock;

    public Product() {
    }

    public Product(String name, String link_Photo, int quantity, int quantity_Valid, int quantity_stock) {
        Name = name;
        Link_Photo = link_Photo;
        Quantity = quantity;
        Quantity_Valid = quantity_Valid;
        Quantity_stock = quantity_stock;
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

    public int getQuantity_Valid() {
        return Quantity_Valid;
    }

    public void setQuantity_Valid(int quantity_Valid) {
        Quantity_Valid = quantity_Valid;
    }

    public int getQuantity_stock() {
        return Quantity_stock;
    }

    public void setQuantity_stock(int quantity_stock) {
        Quantity_stock = quantity_stock;
    }
}
