package org.example;

import org.example.calculator.Calculator;
import org.example.userInput.UserInput;

/**
 * Main class
 *
 * @author ELano
 */

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        UserInput.init();

        float param1 = UserInput.inputParam(0, "Enter first element: ");
        calculator.setFirstParam(param1);

        float param20 = UserInput.inputParam(0, "Enter second element: ");
        calculator.setSecondParam(param20);

        String operation = UserInput.inputParam("", "Operation: ");
        calculator.setOperation(operation);

        float result1 = calculator.calculate();
        System.out.printf("Result: %.4f\n", result1);

        float param21 = UserInput.inputParam(0, "\nEnter second element: ");
        calculator.setSecondParam(param21);

        float result2 = calculator.calculate();
        System.out.printf("Result: %.4f\n", result2);

        String operation1 = UserInput.inputParam("", "\nEnter new operation: ");
        Calculator calculator1 = new Calculator(param1, param21, operation1);

        float result3 = calculator1.calculate();
        System.out.printf(
                "Result: %.4f, First param: %.4f,Second param: %.4f,Operation: %s\n",
                result3, calculator1.getFirstParam(), calculator1.getSecondParam(), calculator1.getOperation()
        );

        UserInput.close();
    }
}