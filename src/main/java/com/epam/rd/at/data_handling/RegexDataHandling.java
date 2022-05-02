package com.epam.rd.at.data_handling;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDataHandling {

    // task 1
    public static boolean isNameAndLastNameStartFromTheSameLetter(String fullName) {
        Pattern pattern = Pattern.compile("[A-Z].* [A-Z].*");
        Matcher matcher = pattern.matcher(fullName);
        if (!matcher.matches()) {
            return false;
        } else {
            String[] splitFullName;
            splitFullName = fullName.split("\\s+");
            String name = splitFullName[0];
            String surname = splitFullName[1];
            char[] nameArray = name.toCharArray();
            char[] surnameArray = surname.toCharArray();
            return nameArray[0] == surnameArray[0];
        }

    }


    // task 2
    public static String reverseWords(String string) {
        StringBuilder result = new StringBuilder();
        /* ИЗНАЧАЛЬНО СДЕЛАЛ ТАКУЮ (ПРОСТУЮ) РЕАЛИЗАЦИЮ
        reversedResult = string.split("\\s+");
        for (String element: reversedResult) {
            String reversedWord = new StringBuffer(element).reverse().toString();
            element = reversedWord;
            result.append(element + " ");
        } return result.toString().substring(0,result.length() - 1);*/
        Matcher matcher = Pattern.compile("\\w+\\b").matcher(string);
        while (matcher.find()) {
            StringBuffer replacement = new StringBuffer(matcher.group(0)).reverse();
            matcher.appendReplacement(result, String.valueOf(replacement));
        }
        matcher.appendTail(result);
        return String.valueOf(result);
    }

    // task 3
    public static String lowerCaseToUpperUnderscoreCase(String lowerCase) {
        StringBuilder result = new StringBuilder();
        Matcher matcher = Pattern.compile("[A-Z]?[a-z]+").matcher(lowerCase);
        while (matcher.find()) {
            matcher.appendReplacement(result, String.valueOf(matcher.group(0)).toUpperCase(Locale.ROOT) + "_");
        }
        matcher.appendTail(result);
        return String.valueOf(result).substring(0, result.length()-1);
    }

    // task 4
    public static String upperUnderscoreCaseToLowerCase(String string) {
        /*StringBuffer result = new StringBuffer();
        Matcher matcher = Pattern.compile("[A-Z]+").matcher(string);
        while (matcher.find()) {
            StringBuffer replacement = new StringBuffer(firstUpperCase(String.valueOf(matcher.group(0))));
            matcher.appendReplacement(result, String.valueOf(replacement));
        }
        matcher.appendTail(result);
        return String.valueOf(result).substring(0, result.length()-1);*/
        String[] splittedString;
        splittedString = string.split("_");
        StringBuilder result = new StringBuilder();
        for (int i=0; i < splittedString.length; i++) {
            if (i == 0) {
                result.append(splittedString[i].toLowerCase());
            } else  result.append(firstUpperCase(splittedString[i]));
        }

        return  String.valueOf(result);
    }

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    // task 5
    public static String[] findNames(String string) {
        {
            Matcher matcher = Pattern.compile("[A-z]+[a-z]+\\s(A[a-z]+a)").matcher(string);
            ArrayList<String> result1 = new ArrayList<>();
            while (matcher.find()) {
                result1.add(matcher.group(1));
            }
            return result1.toArray(new String[0]);
        }
    }

    // task 6
    public static String[] findPairMatchingRegex(String regex, String... array) {
        String[] result = new String[2];
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Matcher matcher = Pattern.compile(regex).matcher(array[i]);
            if(matcher.matches()) {
                indexes.add(i);
            }
        }
        int differenceBetweenIndexes = indexes.size();
        int firstIndex = 0;
        int secondIndex = 0;
        for(int i = 0; i < indexes.size()-1; i++) {
            if ((indexes.get(i + 1) - indexes.get(i)) < differenceBetweenIndexes) {
                differenceBetweenIndexes = indexes.get(i + 1) - indexes.get(i);
                firstIndex = indexes.get(i);
                secondIndex = indexes.get(i + 1);
            }
        }
        if (secondIndex == 0) {
            return null;
        } else {
            result[0] = array[firstIndex];
            result[1] = array[secondIndex];
        }
        return  result;
    }
}
