package org.example;

import java.util.Scanner;

/**
 * Main class
 * @author ELano
 * @see #calculate()
 * @see #findMax()
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of task: (1 - calculator, 2 - string array)");
        int task = scanner.nextInt();

        switch (task){
            case 1: {
                calculate();
                break;
            }
            case 2: {
                findMax();
                break;
            }

            default:break;
        }
    }

    /**
     * Calculate function, input 2 numbers and operation
     * */
    public static void calculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first element: ");
        float param1 = scanner.nextFloat();

        System.out.println("Enter first element: ");
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

    /**
     * Find element with max length
     * */
    public static void findMax() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount of elements: ");
        int amount = scanner.nextInt();

        System.out.println("Enter elements: ");

        String[] arr = new String[amount];

        for (int i = 0; i < amount; i++){
            String str = scanner.next();
            arr[i] = str;
        }

        String maxLenElem = "";
        for (String str: arr){
            if(str.length() > maxLenElem.length()){
                maxLenElem = str;
            }
        }
        System.out.println(maxLenElem);
    }
}