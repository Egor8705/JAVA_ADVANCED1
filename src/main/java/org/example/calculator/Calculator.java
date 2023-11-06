package org.example.calculator;

import java.util.Scanner;

/**
 * Calculator class
 *
 * @author ELano
 * @see #inputParam()
 * @see #inputParam(boolean secondParam)
 * @see #inputParam(String operation)
 * @see #start()
 * @see #end()
 * @see #run()
 */
public class Calculator {
    private static Scanner scanner;

    private static float inputParam() {
        System.out.println("Enter first element: ");
        return scanner.nextFloat();
    }

    private static float inputParam(boolean secondParam) {
        System.out.println("Enter second element: ");
        return scanner.nextFloat();
    }

    private static String inputParam(String operation) {
        System.out.println("Operation: ");
        return scanner.next();
    }

    private static void printResult(float param1, float param2, String operation) {
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
                System.out.println("Please, input operation again (+, -, *, /)");

                String newOperation = inputParam("");

                printResult(param1, param2, newOperation);
                return;
            }
        }

        System.out.printf("Result: %.4f\n", result);
    }

    static private void calculate() {
        float param1 = inputParam();
        float param2 = inputParam(true);

        String operation = inputParam("");

        printResult(param1, param2, operation);
    }

    static private void start() {
        scanner = new Scanner(System.in);
    }

    static private void end() {
        scanner.close();
    }

    public static void run() {
        start();
        calculate();
        end();
    }
}
