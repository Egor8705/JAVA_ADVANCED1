package sweets;

public class Jellybean extends Sweets {
    private final String form;
    public static String name = "Jellybean";

    public Jellybean(float weight, float price, String form) {
        super(Jellybean.name, weight, price);
        this.form = form;
    }

    public String getForm() {
        return this.form;
    }

    @Override
    protected String getProps() {
        return super.getProps() + ", form: " + this.getForm();
    }
}