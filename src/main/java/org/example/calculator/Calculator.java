package org.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculator class
 *
 * @author ELano
 * @see #inputParam(boolean secondParam)
 * @see #inputOperation()
 * @see #start()
 * @see #end()
 * @see #run()
 */
public class Calculator {
    private static Scanner scanner;

    private static float inputParam(boolean secondParam) {

        float value = 0;
        boolean inputErr = true;

        while (inputErr) {
            try {
                System.out.println(!secondParam ? "Enter first element: " : "Enter second element: ");
                value = scanner.nextFloat();
                inputErr = false;
            } catch (InputMismatchException err) {
                System.err.println("Exception thrown: " + err);
                scanner.next();
            }
        }

        return value;
    }

    private static String inputOperation() {
        String operation = "";
        boolean inputErr = true;

        while (inputErr) {
            try {
                System.out.println("Operation: ");
                operation = scanner.next();

                if (operation.length() > 1 || !operation.matches("[-+/*]")) {
                    throw new OperationException();
                }
                inputErr = false;
            } catch (OperationException err) {
                err.printStackTrace();
            }
        }

        return operation;
    }

    private static <err> void printResult(float param1, float param2, String operation) {
        float result;

        try {
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
                    if (param2 == 0) {
                        throw new ArithmeticException();
                    }

                    result = param1 / param2;
                    break;
                }
                default: {
                    String newOperation = inputOperation();

                    printResult(param1, param2, newOperation);
                    return;
                }
            }

            System.out.printf("Result: %.4f\n", result);
        } catch (ArithmeticException err) {
            System.err.println("Exception thrown: " + err);

            float newParam2 = inputParam(true);
            printResult(param1, newParam2, operation);
        }
    }

    static private void calculate() {
        float param1 = inputParam(false);
        float param2 = inputParam(true);

        String operation = inputOperation();

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
