package org.example;

public class Sweets {
    private final float weight;
    private final float price;
    private final int id;
    public String name;

    private static final int MAX_ID = 10000;


    public Sweets(String name, float weight, float price, int id) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.id = id;
    }

    public Sweets(String name, float weight, float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.id = generateId();
    }

    public static int generateId() {
        return (int) Math.floor(Math.random() * Sweets.MAX_ID);
    }

    public float getWeight() {
        return this.weight;
    }

    public float getPrice() {
        return this.price;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Sweetness [ " + "name: " + this.name + ", weight: " + this.getWeight() + ", price: " + this.getPrice() + ", ID: " + this.getId() + " ]";
    }
}
