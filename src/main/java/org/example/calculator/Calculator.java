package org.example.calculator;

/**
 * Calculator class
 *
 * @author ELano
 */
public class Calculator {

    private float firstParam;

    private float secondParam;

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

    public float calculate() {
        float result;

        switch (operation) {
            case "+": {
                result = this.firstParam + this.secondParam;
                break;
            }
            case "-": {
                result = this.firstParam - this.secondParam;
                break;
            }
            case "*": {
                result = this.firstParam * this.secondParam;
                break;
            }
            case "/": {
                if (this.secondParam == 0) {
                    return Float.NaN;
                }

                result = this.firstParam / this.secondParam;
                break;
            }
            default: {
                System.err.println("Incorrect operation");
                System.out.println("Please, set correct operation (+, -, *, /)");

                return Float.NaN;
            }
        }

        return result;
    }

    public float calculate(float firstParam, float secondParam, String operation) {
        float result;

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
                    return Float.NaN;
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

        return result;
    }
}
