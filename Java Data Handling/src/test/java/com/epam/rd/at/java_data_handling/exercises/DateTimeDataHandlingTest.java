package com.epam.rd.at.java_data_handling.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DateTimeDataHandlingTest {

    @Test
    void getMonthName() {
        assertEquals("January", DateTimeDataHandling.getMonthName(1));
        assertEquals("September", DateTimeDataHandling.getMonthName(9));
        assertNull(DateTimeDataHandling.getMonthName(0));
        assertNull(DateTimeDataHandling.getMonthName(13));
    }

    @Test
    void findFridaysThirteen() {
        LocalDate[] fridaysThirteen = DateTimeDataHandling.findFridaysThirteen(2020);
        LocalDate[] expected = {
                LocalDate.of(2020, Month.MARCH, 13),
                LocalDate.of(2020, Month.NOVEMBER, 13)
        };
        assertArrayEquals(expected, fridaysThirteen);
    }

    @Test
    void findLastDayOfMonthFormatted() {
        String result1 = DateTimeDataHandling.findLastDayOfMonthFormatted(LocalDate.of(2021, Month.JANUARY, 15));
        assertEquals("Sunday Jan 31, 2021", result1);

        String result2 = DateTimeDataHandling.findLastDayOfMonthFormatted(LocalDate.of(2020, Month.FEBRUARY, 17));
        assertEquals("Saturday Feb 29, 2020", result2);

        String result3 = DateTimeDataHandling.findLastDayOfMonthFormatted(LocalDate.of(2020, Month.APRIL, 30));
        assertEquals("Thursday Apr 30, 2020", result3);
    }

    @Test
    void changeTimesTo12h() {
        String string = "Breakfast 07:25, Lunch 13:00, Dinner 20:10, 24:10, 123:2a 31:20 10:60 10:80 1:20";
        String result = DateTimeDataHandling.changeTimesTo12h(string);
        String expected = "Breakfast 7:25 AM, Lunch 1:00 PM, Dinner 8:10 PM, 24:10, 123:2a 31:20 10:60 10:80 1:20";
        assertEquals(expected, result);
    }

    @Test
    void findMostDistantDateFuture() {
        LocalDateTime expected = LocalDateTime.parse("2021-01-14T22:42:23");
        LocalDateTime anchor = LocalDateTime.parse("2021-01-10T12:44:48");
        LocalDateTime actual = DateTimeDataHandling.findMostDistantDate(anchor,
                LocalDateTime.parse("2021-01-06T20:49:02"),
                expected,
                LocalDateTime.parse("2021-01-07T16:59:56"),
                LocalDateTime.parse("2021-01-13T21:02:01"),
                LocalDateTime.parse("2021-01-13T09:34:28"));
        assertEquals(expected, actual);
    }

    @Test
    void findMostDistantDatePast() {
        LocalDateTime expected = LocalDateTime.parse("2021-01-06T12:42:23");
        LocalDateTime anchor = LocalDateTime.parse("2021-01-10T12:44:48");
        LocalDateTime actual = DateTimeDataHandling.findMostDistantDate(anchor,
                LocalDateTime.parse("2021-01-06T20:49:02"),
                expected,
                LocalDateTime.parse("2021-01-07T16:59:56"),
                LocalDateTime.parse("2021-01-13T21:02:01"),
                LocalDateTime.parse("2021-01-13T09:34:28"));
        assertEquals(expected, actual);
    }

    @Test
    void daysToNextSeptemberFirst() {
        Map<LocalDate, Integer> map = new HashMap<>();
        map.put(LocalDate.of(2021, Month.JANUARY, 3), 241);
        map.put(LocalDate.of(2021, Month.NOVEMBER, 4), 301);
        map.put(LocalDate.of(2021, Month.SEPTEMBER, 1), 365);
        map.put(LocalDate.of(2020, Month.FEBRUARY, 28), 186);

        for (Map.Entry<LocalDate, Integer> entry : map.entrySet()) {
            LocalDate date = entry.getKey();
            long actual = DateTimeDataHandling.daysToNextSeptemberFirst(date);
            int expected = entry.getValue();
            assertEquals(expected, actual, "Wrong result for date " + date);
        }
    }

    @Test
    void getHoursToMidnight() {
        Map<LocalTime, Integer> map = new HashMap<>();
        map.put(LocalTime.of(19, 0), 5);
        map.put(LocalTime.of(14, 30), 9);
        map.put(LocalTime.of(0, 1), 23);

        for (Map.Entry<LocalTime, Integer> entry : map.entrySet()) {
            LocalTime time = entry.getKey();
            long actual = DateTimeDataHandling.getHoursToMidnight(time);
            int expected = entry.getValue();
            assertEquals(expected, actual, "Wrong result for today time " + time);
        }
    }

    @Test
    void withDayOfWeek() {
        LocalDate date1 = LocalDate.parse("2021-02-10");
        assertEquals(LocalDate.parse("2021-02-07"), DateTimeDataHandling.withDayOfWeek(date1, DayOfWeek.SUNDAY),
                "Wrong result for " + date1 + " and Sunday");
        assertEquals(LocalDate.parse("2021-02-08"), DateTimeDataHandling.withDayOfWeek(date1, DayOfWeek.MONDAY),
                "Wrong result for " + date1 + " and Monday");
        assertEquals(LocalDate.parse("2021-02-13"), DateTimeDataHandling.withDayOfWeek(date1, DayOfWeek.SATURDAY),
                "Wrong result for " + date1 + " and Saturday");

        LocalDate date2 = LocalDate.parse("2021-02-14");
        assertEquals(LocalDate.parse("2021-02-14"), DateTimeDataHandling.withDayOfWeek(date2, DayOfWeek.SUNDAY),
                "Wrong result for " + date2 + " and Sunday");
        assertEquals(LocalDate.parse("2021-02-16"), DateTimeDataHandling.withDayOfWeek(date2, DayOfWeek.TUESDAY),
                "Wrong result for " + date2 + " and Tuesday");
    }

    @Test
    void getWeekRange() {
        Map<LocalDate, String> map = new HashMap<>();
        map.put(LocalDate.of(2021, Month.JANUARY, 3), "3 - 9 Jan 2021");
        map.put(LocalDate.of(2021, Month.NOVEMBER, 6), "31 Oct - 6 Nov 2021");
        map.put(LocalDate.of(2021, Month.JANUARY, 1), "27 Dec 2020 - 2 Jan 2021");

        for (Map.Entry<LocalDate, String> entry : map.entrySet()) {
            LocalDate date = entry.getKey();
            String actual = DateTimeDataHandling.getWeekRange(date);
            String expected = entry.getValue();
            assertEquals(expected, actual, "Wrong result for date " + date);
        }
    }
}