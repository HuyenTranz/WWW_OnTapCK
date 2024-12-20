package com.example.ontapck.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "ProID")
    private int ProID;

    @Column(name = "ProName")
    private String ProName;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Price")
    private double Price;

    public Orders(int ID, int proID, String proName, int quantity, double price) {
        this.ID = ID;
        ProID = proID;
        ProName = proName;
        Quantity = quantity;
        this.Price = price;
    }

    public Orders() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int proID) {
        ProID = proID;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", ProID=" + ProID +
                ", ProName='" + ProName + '\'' +
                ", Quantity=" + Quantity +
                ", price=" + Price +
                '}';
    }
}
