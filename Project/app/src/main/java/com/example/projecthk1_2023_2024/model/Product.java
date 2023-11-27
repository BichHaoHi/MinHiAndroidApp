package com.example.projecthk1_2023_2024.model;

public class Product {
    String Name;
    String Link_Photo;
    int Quantity;
    int Quantity_Valid;
    int Quantity_Stock;

    public Product() {
    }

    public Product(String Name, String Link_Photo, int Quantity, int Quantity_Valid, int Quantity_Stock) {
        this.Name = Name;
        this.Link_Photo = Link_Photo;
        this.Quantity = Quantity;
        this.Quantity_Valid = Quantity_Valid;
        this.Quantity_Stock = Quantity_Stock;
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

    public int getQuantity_Stock() {
        return Quantity_Stock;
    }

    public void setQuantity_Stock(int quantity_stock) {
        Quantity_Stock = quantity_stock;
    }
}
