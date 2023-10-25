package sweets;

public class Cake extends Sweets {
    private final float kcal;
    public static String name = "Cake";

    public Cake(float weight, float price, float kcal) {
        super(Cake.name, weight, price);
        this.kcal = kcal;
    }

    public float getKCal() {
        return this.kcal;
    }

    @Override
    protected String getProps() {
        return super.getProps() + ", kcal: " + this.getKCal();
    }
}
