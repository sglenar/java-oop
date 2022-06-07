package com.epam.rd.at.java_stream_api.exercises;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.concurrent.TimeUnit.DAYS;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamExercises {

    // task 1
    public static List<Integer> generateNumbers(int x) {
        return IntStream.rangeClosed(1, x).boxed().collect(Collectors.toList());
    }

    // task 2
    public static LocalDate findMostDistantDate(LocalDate anchorDate, LocalDate... datesToCompare) {
        return Arrays.stream(datesToCompare)
                .max(Comparator.comparingLong(date -> Math.abs(ChronoUnit.DAYS.between(date,anchorDate)))).orElse(null);
    }

    // task 3
    public static <T> List<T> getOddElements(List<T> list) {
        return IntStream.range(0,list.size()).filter(index -> index % 2 != 0).mapToObj(index -> list.get(index)).collect(Collectors.toList());
    }

    // task 4
    public static long countStringsWithUniqueCharacters(List<String> list) {
        return list.stream().filter(string -> {
            if (string.equals("") ) {
                return false;
            }
            char[] characters = string.toCharArray();
            for (int i = 0; i < string.length(); i++) {
                for ( int j = i+1; j < string.length(); j++ ) {
                    if (characters[i] == characters[j]) {
                        return false;
                    }
                }
            }
            return true;
        }).count();
    }

    // task 5
    public static List<String> sortByLengthDesc(List<String> list) {
        LengthComparator comparator = new LengthComparator();
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    // task 6
    public static boolean checkNoNegativeValues(List<Integer> list) {
        return list.stream().allMatch(elem -> elem >= 0);
    }

    // task 7
    public static List<LocalDate> getRandomUniqueDates(int year, int limit) {
        return Stream.generate(() -> createRandomDate(year, year))
                .limit(limit-1)
                .sorted()
                .collect(Collectors.toList());
    }
    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    // task 8
    public static <T> int indexOfByPredicate(List<T> list, Predicate<T> predicate) {
       return IntStream.range(0,list.size())
                .filter(index -> predicate.test(list.get(index)))
                .findFirst().orElse(-1);
    }

    // task 9
    public static Map<Month, Integer> generateMonthAndLengths() {
        //return IntStream.range(0,12).boxed().collect(groupingBy(x -> Month.of((Integer) x), Month.of(x).toString().length())).entrySet().
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 10
    public static char findMostFrequentChar(String string) {
        return string.chars()
                .mapToObj(symbol -> (char) symbol)
                .collect(groupingBy(character -> character, counting()))
                .entrySet().stream()
                .filter(mapElement -> mapElement.getKey() !=' ')
                .max(comparingByValue())
                .get()
                .getKey();
    }

    // task 11
    public static List<String> getValuesAndSort(List<Map<String, String>> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
