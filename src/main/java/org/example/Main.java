package org.example;

import org.example.calculator.Calculator;
import org.example.userInput.UserInput;

/**
 * Main class
 * @author ELano
 */

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        UserInput.init();

        float param1 = UserInput.inputParam(0, "Enter first element: ");
        calculator.setFirstParam(param1);

        calculator.setSecondParam(0);

        String operation = "/";
        calculator.setOperation(operation);

        float result = calculator.calculate();

        System.out.printf("Result: %.4f\n", result);
    }
}