package com.epam.rd.at.data_handling;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDataHandling {

    // task 1
    public static String toBinaryCode(int number) {
        String result;
            int reminder;
            if (number == 0) {
                result = String.valueOf(0);
            } else {
                StringBuilder buffer = new StringBuilder();
                while(number !=0 ) {
                    reminder = number%2;
                    buffer.append(reminder);
                    number = number/2;
                }
                result = String.valueOf(buffer.reverse());
            }

            return result;
    }

    // task 2
    public static String hexColorToString(String hex) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("#([A-F]|\\d){6}");
        Matcher matcher = pattern.matcher(hex);
        if (matcher.matches()) {
            int red = Integer.valueOf(hex.substring(1, 3), 16);
            result.append("rgb(").append(red).append(", ");
            int green = Integer.valueOf(hex.substring(3, 5), 16);
            result.append(green).append(", ");
            int blue = Integer.valueOf(hex.substring(5), 16);
            result.append(blue).append(")");
            return String.valueOf(result);
        } else return null;

    }

    // task 3
    public static String changeCase(String string) {
        String result;
        char[] charsArrayOfString = string.toCharArray();
        for (int i = 0; i < charsArrayOfString.length; i++) {
            char symbolOnI = charsArrayOfString[i];
            if (Character.isUpperCase(symbolOnI)) {
                charsArrayOfString[i] = Character.toLowerCase(symbolOnI);
            } else if (Character.isLowerCase(symbolOnI)) {
                charsArrayOfString[i] = Character.toUpperCase(symbolOnI);
            }
        }
        result = new String(charsArrayOfString);
        return result;
    }

    // task 4
    public static String roundByScale(double number, int scale) {
        String result = String.format("%."+scale+"f",number);
        result = result.replace(',', '.');
        return result;
    }

    // task 5
    public static String joinBySemicolon(String... strings) {
        StringBuilder buffer = new StringBuilder();
        String result;
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length-1) {
                buffer.append(strings[i]).append(';');
            } else buffer.append(strings[i]);
        }
        result = String.valueOf(buffer);
        return result;
    }

    // task 6
    public static void printXElementsPerLine(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1) {
                System.out.print(array[i]);
            }  else if (i%x == x-1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
}

