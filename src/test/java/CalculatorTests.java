import org.example.calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CalculatorTests {

    static private String result = "Result: ";
    static private InputStream stdin;
    static private PrintStream stdout;

    static private ByteArrayInputStream getInputTestStream(String inputString) {
        return new ByteArrayInputStream(inputString.getBytes());
    }

    private static String getOutputValue(String inputString) {
        System.setIn(getInputTestStream(inputString));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        Calculator.run();

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        return outputText.substring(outputText.indexOf(result) + result.length()).trim();
    }

    @Before
    public void init() {
        stdin = System.in;
        stdout = System.out;
    }

    @Test
    public void checkCorrectInputParamsAndOperators() {
        String output1 = getOutputValue("3\n4\n+");
        String output2 = getOutputValue("3\n4\n*");
        String output3 = getOutputValue("12\n4\n/");
        String output4 = getOutputValue("3\n4\n-");

        Assert.assertEquals(output1, "7,0000");
        Assert.assertEquals(output2, "12,0000");
        Assert.assertEquals(output3, "3,0000");
        Assert.assertEquals(output4, "-1,0000");
    }

    @Test
    public void checkDivisionByZeroAndRetryInputSecondParam() {
        String output1 = getOutputValue("4\n0\n/\n2");
        String output2 = getOutputValue("4\n0\n/\n0\n4");

        Assert.assertEquals(output1, "2,0000");
        Assert.assertEquals(output2, "1,0000");
    }

    @Test
    public void checkIncorrectOperatorAndRetryInputOperator() {
        String output1 = getOutputValue("3\n4\nsome_incorrect_operator\n+");
        String output2 = getOutputValue("3\n4\n*-r\n*");
        String output3 = getOutputValue("3\n4\n0\n/");

        Assert.assertEquals(output1, "7,0000");
        Assert.assertEquals(output2, "12,0000");
        Assert.assertEquals(output3, "0,7500");
    }
}
