package com.epam.rd.at.java_collections.exercises;

public class LengthComparator implements java.util.Comparator<String> {

    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
}
