package sweets;

public class Candy extends Sweets {
    private final String country;
    public static String name = "Candy";

    public Candy(float weight, float price, String country) {
        super(Candy.name, weight, price);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    protected String getProps() {
        return super.getProps() + ", country: " + this.getCountry();
    }
}
