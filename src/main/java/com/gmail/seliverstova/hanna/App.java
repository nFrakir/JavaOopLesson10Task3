package com.gmail.seliverstova.hanna;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AsciiGenerator ag = new AsciiGenerator("resources/UpperCaseLetters", "resources/LowerCaseLetters");
        Scanner sc = new Scanner(System.in);
        System.out.println("Demo, only before F letter can be translated");
        System.out.println("Input text and press Enter");
        String input = sc.nextLine();
        try {
            ag.loadAlphabet();
            String result = ag.translateText(input);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
