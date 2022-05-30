package com.epam.rd.at.java_stream_api.exercises;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.DAYS;

public class StreamExercises {

    // task 1
    public static List<Integer> generateNumbers(int x) {
        List<Integer> result = IntStream.rangeClosed(1, x).boxed().collect(Collectors.toList());
        return result;
    }

    // task 2
    public static LocalDate findMostDistantDate(LocalDate anchorDate, LocalDate... datesToCompare) {
        List<LocalDate> resultsList = new ArrayList<>();
        return Arrays.stream(datesToCompare).max(LocalDate::compareTo).get();
    }

    public static long testy (LocalDate dateAnch, LocalDate date) {
        return Math.abs(ChronoUnit.DAYS.between(dateAnch, date));
    }

    // task 3
    public static <T> List<T> getOddElements(List<T> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 4
    public static long countStringsWithUniqueCharacters(List<String> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 5
    public static List<String> sortByLengthDesc(List<String> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 6
    public static boolean checkNoNegativeValues(List<Integer> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 7
    public static List<LocalDate> getRandomUniqueDates(int year, int limit) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 8
    public static <T> int indexOfByPredicate(List<T> list, Predicate<T> predicate) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 9
    public static Map<Month, Integer> generateMonthAndLengths() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 10
    public static char findMostFrequentChar(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // task 11
    public static List<String> getValuesAndSort(List<Map<String, String>> list) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
