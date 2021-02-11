package com.company;

import java.io.*;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {
        HashSet<String> dictionary = new HashSet<String>();
        File file = new File("D:\\Non-Stop.1996.JAPANESE.1080p.BluRay.H264.AAC-VXT.srt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null)
        {
            String[] words = line.split(" ");
            for (String word : words) {
                if (isWord(word)) {
                    word = replacedWord(word);
                    dictionary.add(word.toLowerCase());
                }
            }
        }
        for (String engWord : dictionary) {
            System.out.println(engWord);
        }
    }

    public static boolean isWord(String word){
        //System.out.println("Working on a word : " + word);
        word = replacedWord(word);
        char charsArray[] = word.toLowerCase().toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int counter = 0;
        for (int i = 0; i < charsArray.length; i++) {
            char currentChar = charsArray[i];
            for (int j = 0; j < alphabet.length; j++)
                if (currentChar == alphabet[j]) {
                    counter++;
                }
        }
        //System.out.println("Word as array length : " + charsArray.length);
        //System.out.println("Counter: " + counter);
        if (counter != 0 && counter == charsArray.length)
            return true;
        return false;
    }

    public static String replacedWord(String word){
        String replacableChars[] = {"?", ",", "!", "."};
        for (int i = 0; i < replacableChars.length; i++) {
            word = word.replace(replacableChars[i], "");
        }
        return word;
    }
}