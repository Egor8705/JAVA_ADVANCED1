package org.example.calculator;

/**
 * Calculator class
 * @author ELano
 */
public class Calculator {

    private float firstParam = Float.NaN;

    private float secondParam = Float.NaN;

    private String operation;

    public Calculator() {
    }

    public Calculator(float firstParam, float secondParam, String operation) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
        this.operation = operation;
    }

    public void setFirstParam(float param) {
        this.firstParam = param;
    }

    public float getFirstParam() {
        return this.firstParam;
    }

    public void setSecondParam(float param) {
        this.secondParam = param;
    }

    public float getSecondParam() {
        return this.secondParam;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public float calculate(float firstParam, float secondParam, String operation) {
        if (Float.isNaN(firstParam)) {
            System.out.println("Please, set correct first arg");

            return Float.NaN;
        } else if (Float.isNaN(this.secondParam)) {
            System.out.println("Please, set correct second arg");

            return Float.NaN;
        }

        float result;

        try {
            switch (operation) {
                case "+": {
                    result = firstParam + secondParam;
                    break;
                }
                case "-": {
                    result = firstParam - secondParam;
                    break;
                }
                case "*": {
                    result = firstParam * secondParam;
                    break;
                }
                case "/": {
                    if (secondParam == 0) {
                        throw new ArithmeticException();
                    }

                    result = firstParam / secondParam;
                    break;
                }
                default: {
                    System.err.println("Incorrect operation");
                    System.out.println("Please, set correct operation (+, -, *, /)");

                    return Float.NaN;
                }
            }
        } catch (ArithmeticException err) {
            System.err.println("Exception thrown: " + err);
            err.printStackTrace();

            return Float.NaN;
        }

        return result;
    }

    public float calculate() {
        if (Float.isNaN(this.firstParam)) {
            System.out.println("Please, set first param");

            return Float.NaN;
        } else if (Float.isNaN(this.secondParam)) {
            System.out.println("Please, set second param");

            return Float.NaN;
        }

        return this.calculate(this.firstParam, this.secondParam, this.operation);
    }
}
