package sweets;

public class Gumdrops extends Sweets{
    private final int quality;
    public static String name = "Gumdrops";

    public Gumdrops(float weight, float price, int quality) {
        super(Gumdrops.name,weight, price);
        this.quality = quality;
    }

    public int getQuality() {
        return this.quality;
    }

    @Override
    protected String getProps() {
        return super.getProps() + ", quality: " + this.getQuality();
    }
}