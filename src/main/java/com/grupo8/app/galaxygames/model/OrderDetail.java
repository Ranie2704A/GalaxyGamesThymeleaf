package com.grupo8.app.galaxygames.model;

public class OrderDetail {

    private Integer id;
    private String name;
    private double cuantity;
    private double price;
    private double total;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, String name, double cuantity, double price, double total) {
        this.id = id;
        this.name = name;
        this.cuantity = cuantity;
        this.price = price;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCuantity() {
        return cuantity;
    }

    public void setCuantity(double cuantity) {
        this.cuantity = cuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail [id=" + id + ", name=" + name + ", cuantity=" + cuantity + ", price=" + price + ", total="
                + total + "]";
    }

    
}
