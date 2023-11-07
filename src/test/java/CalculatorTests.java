import org.example.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {

    @Test
    public void checkSetters() {
        Calculator calculator = new Calculator();

        calculator.setFirstParam(1);
        calculator.setSecondParam(2);
        calculator.setOperation("*");

        float result = calculator.calculate();

        Assert.assertEquals(2f, result, 0.0f);
    }

    @Test
    public void checkWithoutSetSecondParam() {
        Calculator calculator = new Calculator();

        calculator.setFirstParam(1);
        calculator.setOperation("*");

        float result = calculator.calculate();

        Assert.assertTrue(Float.isNaN(result));
    }

    @Test
    public void checkWithoutOperation() {
        Calculator calculator = new Calculator();

        calculator.setFirstParam(1);
        calculator.setSecondParam(2);

        float result = calculator.calculate();

        System.out.println(result);

        Assert.assertTrue(Float.isNaN(result));
    }

    @Test
    public void checkSetInConstructor() {
        Calculator calculator = new Calculator(10, 20, "-");

        float result = calculator.calculate();

        Assert.assertEquals(-10f, result, 0.0f);
    }

    @Test
    public void checkCalculateMethod() {
        Calculator calculator = new Calculator();

        float result = calculator.calculate(10, 20, "-");

        Assert.assertEquals(-10f, result, 0.0f);
    }

    @Test
    public void checkGetters() {
        Calculator calculator = new Calculator();

        calculator.setFirstParam(1);
        calculator.setSecondParam(2);
        calculator.setOperation("+");

        Assert.assertEquals(1f, calculator.getFirstParam(), 0.0f);
        Assert.assertEquals(2f, calculator.getSecondParam(), 0.0f);
        Assert.assertEquals("+", calculator.getOperation());

        calculator.setFirstParam(10);
        Assert.assertEquals(10f, calculator.getFirstParam(), 0.0f);

        calculator.setSecondParam(20);
        Assert.assertEquals(20f, calculator.getSecondParam(), 0.0f);

        calculator.setOperation("/");
        Assert.assertEquals("/", calculator.getOperation());
    }
}
