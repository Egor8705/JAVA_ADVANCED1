package sweets;

public class Sweets {
    private final float weight;
    private final float price;
    private final String name;

    Sweets(String name, float weight, float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getPrice() {
        return this.price;
    }

    protected String getProps(){
        return "name: " + this.getName() + ", weight: " + this.getWeight() + ", price: " + this.getPrice();
    }

    public String toString() {
        return "Sweetness [" + this.getProps() + "]";
    }
}
