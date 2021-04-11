package model;

public abstract class Goods {
    private String name;
    private double price;

    protected abstract double getDiscount(double discount);




}
