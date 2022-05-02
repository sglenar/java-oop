package com.epam.rd.at.data_handling;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.Duration.between;
import static java.time.LocalTime.*;

public class DateTimeDataHandling {

    // task 1
    public static String getMonthName(int month) {
        if (month >= 1 && month <= 12) {
        return  firstUpperCase(Month.of(month).toString());
        }
        else return null;
    }

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return ""; //или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    // task 2
    public static LocalDate[] findFridaysThirteen(int year) {
        ArrayList<LocalDate> blackFridays = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            LocalDate date = LocalDate.of(year, i,13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                blackFridays.add(date);
            }
        }
        return  blackFridays.toArray(new LocalDate[0]);
    }

    // task 3
    public static String findLastDayOfMonthFormatted(LocalDate date) {
        Month month = date.getMonth();
        Year year = Year.of(date.getYear());
        LocalDate result = date.with(TemporalAdjusters.lastDayOfMonth());
        @SuppressWarnings("SuspiciousDateFormat") DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMM dd, YYYY").withLocale(new Locale("en"));
        return formatter.format(result);
    }


    // task 4
    public static String changeTimesTo12h(String string) {
        Pattern time = Pattern.compile("([01]\\d|2[0-3]):([0-5]\\d)");
        return time.matcher(string).replaceAll(DateTimeDataHandling::convertTime);
    }

    public static String convertTime(MatchResult hhMM) {
        final DateTimeFormatter HH_MM = DateTimeFormatter.ofPattern("HH:mm"); // 00..23
        final DateTimeFormatter H_MM_A = DateTimeFormatter.ofPattern("h:mm a"); // 1..12
        return LocalTime.parse(hhMM.group(), HH_MM).format(H_MM_A);
    }

    // task 5
    public static LocalDateTime findMostDistantDate(LocalDateTime anchorDate, LocalDateTime... datesToCompare) {
        LocalDateTime result = null;
        long duration =0;
        for (LocalDateTime date:datesToCompare) {
                if(Math.abs(ChronoUnit.DAYS.between(anchorDate,date)) > duration){
                    duration = Math.abs(ChronoUnit.DAYS.between(anchorDate,date));
                    result = date;
            }
        }
        return result;
    }

    // task 6
    public static long daysToNextSeptemberFirst(LocalDate date) {
        if (date.getMonth() == Month.SEPTEMBER && date.getDayOfMonth() == 1) {
            return 365;
        }
        LocalDate september;
        september = date.with(TemporalAdjusters.firstDayOfMonth());
        while (september.getMonth() != Month.SEPTEMBER ) {
            september = september.with(TemporalAdjusters.firstDayOfNextMonth());
        }
        return (ChronoUnit.DAYS.between(date,september));

    }

    // task 7
    public static long getHoursToMidnight(LocalTime time) {
        LocalDateTime startPoint = LocalDateTime.of(LocalDate.now(), time);
        LocalDateTime endPoint = LocalDateTime.of(LocalDate.now().plusDays(1), MIDNIGHT);
        return Duration.between(startPoint,endPoint).toHours();
    }

    // task 8
    public static LocalDate withDayOfWeek(LocalDate baseDate, DayOfWeek dayOfWeek) {
        Calendar currentCalendar = Calendar.getInstance(new Locale("en","US"));
        LocalDate startOfWeek = baseDate;
        while (startOfWeek.getDayOfWeek() != DayOfWeek.SUNDAY) {
            startOfWeek = startOfWeek.minusDays(1);
        }
        LocalDate result =startOfWeek;
        while (result.getDayOfWeek() != dayOfWeek) {
            result = result.plusDays(1);
        }
        return result;
    }

    // task 9
    public static String getWeekRange(LocalDate date) {
        LocalDate startOfWeek = date;
        StringBuilder result = new StringBuilder();
        while (startOfWeek.getDayOfWeek() != DayOfWeek.SUNDAY) {
            startOfWeek = startOfWeek.minusDays(1);
        }
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        /*    if ((startOfWeek.getYear() != endOfWeek.getYear())){
                result.append(startOfWeek.getDayOfMonth() + " " + startOfWeek.getMonth() + " " + startOfWeek.getYear() +
                        " - " + endOfWeek.getDayOfMonth() + " " + endOfWeek.getMonth() + " " + startOfWeek.getYear());
                return  result.toString();
            } else if ((startOfWeek.getMonth() != endOfWeek.getMonth())) {
                result.append(startOfWeek.getDayOfMonth() + " " + startOfWeek.getMonth() +
                        " - " + endOfWeek.getDayOfMonth() + " " + endOfWeek.getMonth() + " " + startOfWeek.getYear());
                return  result.toString();
            } else {
                result.append(startOfWeek.getDayOfMonth() +
                        " - " + endOfWeek.getDayOfMonth() + " " + startOfWeek.getMonth() + " " + startOfWeek.getYear());
                return  result.toString();
            }*/
        DateTimeFormatter onlyDate      = DateTimeFormatter.ofPattern("d", Locale.ENGLISH);
        DateTimeFormatter dateAndMonth  = DateTimeFormatter.ofPattern("d MMM", Locale.ENGLISH);
        DateTimeFormatter dateMonthYear = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        if (YearMonth.from(startOfWeek).equals(YearMonth.from(endOfWeek))){
            result.append(onlyDate.format(startOfWeek)).append(" - ")
                    .append(dateMonthYear.format(endOfWeek));
        }
        else if (Year.from(startOfWeek).equals(Year.from(endOfWeek))){
            result.append(dateAndMonth.format(startOfWeek)).append(" - ")
                    .append(dateMonthYear.format(endOfWeek));
        }
        else {
            result.append(dateMonthYear.format(startOfWeek)).append(" - ")
                    .append(dateMonthYear.format(endOfWeek));
        }
        return result.toString();
    }
}
