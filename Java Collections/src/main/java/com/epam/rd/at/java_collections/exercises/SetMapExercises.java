package com.epam.rd.at.java_collections.exercises;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class SetMapExercises {

    // task 1
    public static <T> void removeDuplicates(Collection<T> collection) {
        SortedSet<T> set;
        set = new TreeSet<>(collection);
        collection.clear();
        collection.addAll(set);

    }

    // task 2
    public static List<LocalDate> getRandomUniqueDates(int year, int limit) {
        SortedSet<LocalDate> set = new TreeSet<>();
        LocalDate start = LocalDate.of(year, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(year, Month.DECEMBER, 31);
        for (int i = 0; i < limit; i++) {
            set.add(createRandomDate(year, year));
        }
        return new ArrayList<>(set);
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    // task 3
    public static Map<String, String> asMap(String... strings) {
        Map<String, String> result = new HashMap<>();
        if (strings.length % 2 != 0) {
            throw new IllegalArgumentException(strings.length + "Incorrect exception message");
        }
        for (int i = 0; i <= strings.length - 2; ) {
            result.put(strings[i], strings[i + 1]);
            i += 2;
        }
        return result;
    }

    // task 4
    public static Map<Month, Integer> generateMonthAndLengths() {
        Map<Month, Integer> result = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            String monthName = String.valueOf(Month.of(i));
            result.put(Month.of(i), monthName.length());
        }
        return result;
    }

    // task 5
    public static <K> Map<K, Integer> countDuplicates(List<K> list) {
        Map<K, Integer> result = new HashMap<>();
        for (K k : list) {
            int counter = 0;
            for (K k1 : list) {
                if (k.equals(k1)) {
                    counter += 1;
                }
                if (counter > 1) {
                    result.put(k, counter);
                }
            }
        }
        return result;
    }

    // task 6
    public static List<String> getValuesAndSort(List<Map<String, String>> list) {
        List<String> result = new ArrayList<>();
        for (Map<String, String> stringStringMap : list) {
            result.addAll(stringStringMap.values());
        }
        LengthComparatorWithNumbers comparator = new LengthComparatorWithNumbers();
        result.sort(comparator);
        return result;
    }
}
