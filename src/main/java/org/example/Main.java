package org.example;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src/main/resources/words.txt");

        fileReader.printStatistic();

        System.out.println();
        fileReader.printMaxEntriesWord();
    }
}