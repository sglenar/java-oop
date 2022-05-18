package com.epam.rd.at.java_collections.exercises;

import java.time.LocalDate;
import java.util.*;

public class ListExercises {

    // task 1
    public static List<Integer> generateNumbers(int x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < x+1; i++) {
            result.add(i);
        }
        return result;
    }

    // task 2
    public static LocalDate findMinDate(Collection<LocalDate> collection) {
        return Collections.min(collection);
    }

    // task 3
    public static <T> List<T> getOddElements(List<T> list) {
        List<T> result = new ArrayList<>();
        for (int i = 1; i < list.size();) {
            result.add(list.get(i));
            i += 2;
        }
        return result;
    }

    // task 4
    public static List<String> getOnlyNumbers(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (isInteger(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
    // task 5
    public static boolean checkNoNegativeValues(List<Integer> list) {
        for (Integer integer : list) {
            if (integer < 0) {
                return false;
            }
        }
        return true;
    }

    // task 6
    public static void sortByLengthDesc(List<String> list) {
        LengthComparator comparator = new LengthComparator();
        list.sort(comparator);
    }
    

    // task 7
    public static boolean isSortedAlphabeticallyIgnoringCase(List<String> list) {
        boolean result = true;
        List<String> isLoweredList = new ArrayList<>();
        for (String s : list) {
            isLoweredList.add(s.toLowerCase());
        }
        for (int i = 1; i < list.size(); i++) {
            if (isLoweredList.get(i-1).compareTo(isLoweredList.get(i)) > 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    // task 8
    public static boolean checkBrackets(String sequence) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
