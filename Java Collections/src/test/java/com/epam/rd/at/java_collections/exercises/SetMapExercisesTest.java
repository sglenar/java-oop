package com.epam.rd.at.java_collections.exercises;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetMapExercisesTest {

    @Test
    void removeDuplicates() {
        List<Integer> originalList = Arrays.asList(1, 1, 5, 5, 3, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> list = new ArrayList<>(originalList);
        SetMapExercises.removeDuplicates(list);
        assertEquals(expected, list, "Result is incorrect for removeDuplicates with list " + originalList);
    }

    @Test
    void getRandomUniqueDates() {
        List<LocalDate> randomUniqueDates1 = SetMapExercises.getRandomUniqueDates(2020, 10);
        List<LocalDate> randomUniqueDates2 = SetMapExercises.getRandomUniqueDates(2020, 10);
        assertNotEquals(randomUniqueDates1, randomUniqueDates2);

        List<LocalDate> sortedUniqueList = new ArrayList<>(new TreeSet<>(randomUniqueDates1));
        assertEquals(sortedUniqueList, randomUniqueDates1);
        randomUniqueDates1.forEach(d -> assertEquals(2020, d.getYear()));
    }

    @Test
    void asMapPositive() {
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("hello", "1");
        expectedMap.put("world", "2");
        expectedMap.put("3", "4");
        Map<String, String> map = SetMapExercises.asMap("hello", "1", "world", "2", "3", "4");
        assertEquals(expectedMap, map);
    }

    @Test
    void asMapNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SetMapExercises.asMap("hello"));
        assertTrue(exception.getMessage().contains("1"), "Incorrect exception message");
    }

    @Test
    void generateMonthAndLengths() {
        Map<Month, Integer> expectedMap = new HashMap<>();
        expectedMap.put(Month.JANUARY, 7);
        expectedMap.put(Month.FEBRUARY, 8);
        expectedMap.put(Month.MARCH, 5);
        expectedMap.put(Month.APRIL, 5);
        expectedMap.put(Month.MAY, 3);
        expectedMap.put(Month.JUNE, 4);
        expectedMap.put(Month.JULY, 4);
        expectedMap.put(Month.AUGUST, 6);
        expectedMap.put(Month.SEPTEMBER, 9);
        expectedMap.put(Month.OCTOBER, 7);
        expectedMap.put(Month.NOVEMBER, 8);
        expectedMap.put(Month.DECEMBER, 8);
        Map<Month, Integer> map = SetMapExercises.generateMonthAndLengths();
        assertEquals(expectedMap, map);
    }

    @Test
    void countDuplicates() {
        List<Integer> list = Arrays.asList(1, 21, 2, 3, 3, 3, 3, 22, 2, 2, 1, 1, 2, 3, 22, 5, 6, 4, 3);
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(1, 3);
        expectedMap.put(2, 4);
        expectedMap.put(3, 6);
        expectedMap.put(22, 2);
        Map<Integer, Integer> map = SetMapExercises.countDuplicates(list);
        assertEquals(expectedMap, map, "Wrong result of countDuplicates for " + list);
    }

    @Test
    void getValuesAndSort() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "3");
        map1.put("aaa", "4");
        map1.put("a1", "hello");
        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "world");
        map2.put("aaa", "33");
        map2.put("a1", "32");
        List<Map<String, String>> list = Arrays.asList(map1, map2);
        List<String> resultMap = SetMapExercises.getValuesAndSort(list);
        List<String> expected = Arrays.asList("3", "4", "32", "33", "hello", "world");
        assertEquals(expected, resultMap, "Wrong result of getValuesAndSort for " + list);
    }
}