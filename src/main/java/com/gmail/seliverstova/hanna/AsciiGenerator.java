package com.gmail.seliverstova.hanna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AsciiGenerator {
    private Map<Character, String[]> alphabet = new HashMap<>();
    private File upperDir;
    private File lowerDir;

    public AsciiGenerator(String upperCaseSource, String lowerCaseSource) {
        super();
        this.upperDir = new File(upperCaseSource);
        this.lowerDir = new File(lowerCaseSource);
    }

    public void setAlphabet(Map<Character, String[]> alphabet) {
        this.alphabet = alphabet;
    }

    public void loadAlphabet() throws IOException {
        for (char c = 'a'; c <= 'd'; c+=1) {
            loadChars(c);
        }
    }

    public String translateText(String text) {
        StringBuilder sb = new StringBuilder();
        char[] textArray = text.toCharArray();
        for (int i = 0; i < 7; i += 1) {
            for (char c : textArray) {
                sb.append(alphabet.get(c)[i]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private void loadChars(Character c) throws IOException {
        try {
            String[] arrayUpper = readText(new File(upperDir, Character.toUpperCase(c) + ".txt"));
            alphabet.put(Character.toUpperCase(c), arrayUpper);
            String[] arrayLower = readText(new File(lowerDir, c + ".txt"));
            alphabet.put(c, arrayLower);
        } catch (IOException e) {
            throw e;
        }
    }

    private String[] readText(File file) throws IOException {
        String[] array = new String[7];
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (int i = 0; ((line = br.readLine()) != null); i += 1) {
                array[i] = line;
            }
        } catch (IOException e) {
            throw e;
        }

        return array;
    }
}