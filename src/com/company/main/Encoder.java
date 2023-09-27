package com.company.main;

import com.company.Huffman;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Encoder {

    private static final BufferedReader keyboardEntryReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            String option = "";
            do {
                System.out.println("Hello!");
                System.out.println(".........................................");
                System.out.println("Welcome to the Huffman algorithm code!");
                System.out.println("Please, choose one of the options above");
                System.out.println("-----------------------------------------");
                System.out.println("|         a) Encode a file             |");
                System.out.println("|         b) Decode a file             |");
                System.out.println("|         x) Maybe it's time to go     |");
                System.out.println("|______________________________________|");
                System.out.println("I'll choose:");
                option = keyboardEntryReader.readLine();

                if (option.toLowerCase().equals("a")) {
                    System.out.println("\n\n File path to be encoded");
                    String filePath = keyboardEntryReader.readLine();
                    System.out.println("\n\n Please name your new encoded file");
                    String encodedFileName = keyboardEntryReader.readLine();

                    Huffman.encode(filePath, encodedFileName);
                    System.out.println("\nDone!");
                    System.out.println("\nTake a look at your encoded file");
                    System.out.println("\n\n.........................................");

                } else if (option.toLowerCase().equals("b")) {
                    System.out.println("\n\n File path to be decoded");
                    String filePath = keyboardEntryReader.readLine();
                    System.out.println("\n\n Please name your new decoded file");
                    String decodedFileName = keyboardEntryReader.readLine();

                    //Huffman.decode(filePath, compressedFileName);

                    System.out.println("\n Translated" + decodedFileName);
                    System.out.println("\n________________________________");
                    System.out.println("\nDone!");
                    System.out.println("\nTake a look at your encoded file!.");
                    System.out.println("\n\n.........................................");
                } else if (option.toLowerCase().equals("c")) {
                    System.out.println("\n\n Test read file text");
                    System.out.println("\n\n File path to be decoded:");
                    String filePath = keyboardEntryReader.readLine();

                    String occurrences = Huffman.translateFilePathToFileText(filePath);

                    System.out.println("\n Translated" + occurrences);
                    System.out.println("\n________________________________");
                    System.out.println("\nDone!");
                    System.out.println("\nTake a look at your encoded file!.");
                    System.out.println("\n\n.........................................");
                } // test

            } while (!option.toLowerCase().equals("x"));

        } catch (Exception err) {
            System.err.println("Error:" + err);
        }

        System.out.println("\n\n________________________________");
        System.out.println("\n\nSee you space cowboy! \uD83E\uDD20");
    }
}
