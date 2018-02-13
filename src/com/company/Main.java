package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> inputStrings = new ArrayList<>();
        String string;
        while (!(string = br.readLine()).trim().equals("")) {
            inputStrings.add(string);
        }
        br.close();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(inputStrings.get(0).split(" ")));
        ArrayList<String> outputStrings = new ArrayList<>();
        for (int i = 1; i < inputStrings.size(); i++) {
            if (getMatchString(words, inputStrings.get(i))) {
                outputStrings.add(inputStrings.get(i));
            }
        }
        if (outputStrings.size() == 0) {
            System.out.println("No matching");
        } else {
            for (String outputString : outputStrings) {
                System.out.println(outputString);
            }
        }
    }

    private static boolean getMatchString(ArrayList<String> words, String inputString) {
        Pattern p;
        for (String word : words) {
            try {
                p = Pattern.compile("\\b" + word + "\\b");
                if (p.matcher(inputString).find()) {
                    return true;
                }
            } catch (PatternSyntaxException patternException) {
                if (inputString.indexOf(word) != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}