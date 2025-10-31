package cs2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class TextAnalysis {
    public static void main(String[] args) {
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
}
