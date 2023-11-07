package org.example.userInput;

import org.example.calculator.OperationException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner;

    static public void init() {
        scanner = new Scanner(System.in);
    }

    static public void close() {
        scanner.close();
    }

    public static float inputParam(float inputType, String inputMsg) {
        float value = 0;
        boolean inputErr = true;

        while (inputErr) {
            try {
                System.out.println(inputMsg);
                value = scanner.nextFloat();
                inputErr = false;
            } catch (InputMismatchException err) {
                System.err.println("Exception thrown: " + err);
                scanner.next();
            }
        }

        return value;
    }

    public static String inputParam(String inputType, String inputMsg) {
        String operation = "";
        boolean inputErr = true;

        while (inputErr) {
            try {
                System.out.println(inputMsg);
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
}
