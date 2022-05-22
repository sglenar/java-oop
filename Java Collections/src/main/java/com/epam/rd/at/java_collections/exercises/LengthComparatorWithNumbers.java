package com.epam.rd.at.java_collections.exercises;

public class LengthComparatorWithNumbers implements java.util.Comparator<String> {

    public int compare(String s1, String s2) {
        if (isNumber(s1) && isNumber(s2)) {
            return (Integer.parseInt(s1) - Integer.parseInt(s2));
        }
        return s1.length() - s2.length();
    }

    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}