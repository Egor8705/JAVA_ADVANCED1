package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * File reader class
 *
 * @author ELano
 * @see #printStatistic()
 * @see #printMaxEntriesWord()
 */
public class FileReader {
    private final TreeMap<String, Integer> map = new TreeMap<>(String::compareTo);

    private String maxEntriesWord = "";

    private Boolean read = false;

    FileReader(String filePath) {
        readFile(filePath);
    }

    private void readFile(String filePath) {
        try (FileInputStream stream = new FileInputStream(filePath)) {

            int i;
            int space = 32;

            StringBuilder currentWord = new StringBuilder();

            while ((i = stream.read()) != -1) {
                char s = (char) i;
                if (s != space) {
                    currentWord.append(s);
                } else {
                    String str = currentWord.toString();

                    if (map.containsKey(str)) {
                        int count = map.get(str);
                        ++count;
                        map.put(str, count);

                        if (Objects.equals(maxEntriesWord, "")) {
                            maxEntriesWord = str;
                        } else if (map.get(maxEntriesWord) < count) {
                            maxEntriesWord = str;
                        }
                    } else {
                        map.put(str, 1);
                    }
                    currentWord = new StringBuilder();
                }
            }

            read = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void printStatistic() {
        if (read) {
            System.out.println("File statistic:");
            for (Map.Entry<String, Integer> item : map.entrySet()) {
                System.out.printf("Word: %s, Entries: %d \n", item.getKey(), item.getValue());
            }
        } else {
            System.out.println("File read error");
        }
    }

    void printMaxEntriesWord() {
        if (read) {
            System.out.printf("Word: %s, Entries: %d \n", maxEntriesWord, map.get(maxEntriesWord));
        } else {
            System.out.println("File read error");
        }
    }
}
