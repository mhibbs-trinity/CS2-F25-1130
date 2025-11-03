package cs2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TextAnalysis {
    public static void countWords() {
        HashSet<String> words = new HashSet<>();
        try {
            Scanner scan = new Scanner(new File("tempest.txt"));
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("\\s+");
                for(String p : parts) {
                    words.add(p.toLowerCase().replaceAll("[^A-Za-z]",""));
                }
            }
            System.out.println(words);
            System.out.println(words.size());
        } catch(FileNotFoundException e) {
            System.out.println("File not found!!!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void countWordFrequency() {
        HashMap<String, Integer> counts = new HashMap<>();
        try {
            Scanner scan = new Scanner(new File("tempest.txt"));
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("\\s+");
                for(String p : parts) {
                    String word = p.toLowerCase().replaceAll("[^A-Za-z]","");

                    if (counts.containsKey(word)) {
                        counts.put(word, counts.get(word) + 1);
                    } else {
                        counts.put(word, 1);
                    }
                }
            }
            counts.remove("");
            System.out.println(counts);
            System.out.println(counts.size());

            String maxWord = "a";
            for(String key : counts.keySet()) {
                if(counts.get(key) > counts.get(maxWord)) {
                    maxWord = key;
                }
            }
            System.out.println(maxWord +" --> " + counts.get(maxWord));

        } catch(FileNotFoundException e) {
            System.out.println("File not found!!!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void main(String[] args) {
        countWordFrequency();
    }

}
