package org.example;

import sweets.*;

import java.util.Arrays;

/**
 * Main class
 *
 * @author ELano
 * @see #findMaxMin()
 * @see #sweetsPresent()
 */

public class Main {
    public static void main(String[] args) {
        findMaxMin();
        sweetsPresent();
    }

    /**
     * Find max negative and min positive elements in random array and replace them
     */
    public static void findMaxMin() {
        System.out.print("Find max and min\n");

        int AMOUNT = 20;
        int MAX = 10;
        int MIN = -10;

        int[] arr = new int[AMOUNT];

        for (int i = 0; i < AMOUNT; i++) {
            arr[i] = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
        }

        System.out.println(Arrays.toString(arr));

        int negIndex = -1;
        int posIndex = -1;

        int i = 0;
        while (i < AMOUNT) {
            if (arr[i] > 0 && (posIndex == -1 || arr[i] < arr[posIndex])) {
                posIndex = i;
            } else if (arr[i] < 0 && (negIndex == -1 || arr[i] > arr[negIndex])) {
                negIndex = i;
            }

            i++;
        }

        if (negIndex != -1 && posIndex != -1) {
            int replace = arr[negIndex];
            arr[negIndex] = arr[posIndex];
            arr[posIndex] = replace;

            System.out.println(Arrays.toString(arr));
        } else {
            System.err.println("Incorrect random");
        }
    }

    public static float getRandomValue(int max, int min) {
        return (float) (Math.floor((Math.random() * (max - min + 1) + min) * 100) / 100);
    }

    /**
    * Create sweets array, calculate total weight and price
    * */
    public static void sweetsPresent() {
        System.out.print("\nSweets present\n");

        int MIN_WEIGHT = 1;
        int MAX_WEIGHT = 10;

        int MIN_PRICE = 10;
        int MAX_PRICE = 1000;

        Candy candy1 = new Candy(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), "France");
        Candy candy2 = new Candy(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), "Italy");
        Cake cake = new Cake(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), 1500.12F);
        Gumdrops gumdrops = new Gumdrops(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), 101);
        Jellybean jellybean = new Jellybean(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), "circle");
        Marmalade marmalade1 = new Marmalade(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), "red");
        Marmalade marmalade2 = new Marmalade(getRandomValue(MAX_WEIGHT, MIN_WEIGHT), getRandomValue(MAX_PRICE, MIN_PRICE), "green");

        Sweets[] sweets = new Sweets[]{candy1, candy2, cake, gumdrops, jellybean, marmalade1, marmalade2};

        float totalWeight = 0;
        float totalPrice = 0;

        for (Sweets sweetness : sweets) {
            totalWeight += sweetness.getWeight();
            totalPrice += sweetness.getPrice();
        }

        System.out.printf("Total weight: %.2f, Total price: %.2f\n", totalWeight, totalPrice);

        for (Sweets sweetness : sweets) {
            System.out.printf(sweetness.toString() + "\n");
        }
    }
}