package org.example.userInput;

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
        System.out.println(inputMsg);
        return scanner.nextFloat();
    }

    public static String inputParam(String inputType, String inputMsg) {
        System.out.println(inputMsg);
        return scanner.next();
    }
}
