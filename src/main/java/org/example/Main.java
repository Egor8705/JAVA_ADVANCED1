package org.example;

import java.util.Scanner;

/**
 * Main class
 * @author ELano
 * @see #calculate()
 */

public class Main {
    public static void main(String[] args) {
        calculate();
    }

    /**
     * Calculate function, input 2 numbers and operation
     * */
    public static void calculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First param: ");
        float param1 = scanner.nextFloat();

        System.out.println("Second param: ");
        float param2 = scanner.nextFloat();

        System.out.println("Operation: ");
        String operation = scanner.next();

        float result;
        switch (operation) {
            case "+": {
                result = param1 + param2;
                break;
            }
            case "-": {
                result = param1 - param2;
                break;
            }
            case "*": {
                result = param1 * param2;
                break;
            }
            case "/": {
                result = param1 / param2;
                break;
            }
            default: {
                System.err.println("Incorrect operation");
                return;
            }
        }

        System.out.printf("Result: %.4f", result);
    }

}