package sweets;

public class Marmalade extends Sweets {
    private final String color;
    public static String name = "Marmalade";

    public Marmalade(float weight, float price, String color) {
        super(Marmalade.name, weight, price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    protected String getProps() {
        return super.getProps() + ", color: " + this.getColor();
    }
}
