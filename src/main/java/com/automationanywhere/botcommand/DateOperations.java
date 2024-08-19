package com.automationanywhere.botcommand;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DateOperations {
    public DateOperations() { // contructor method
    }
    public boolean isWeekDay(LocalDate dateToCheck) {
        //day of week for dateToCheck
        //defining dayOfWeek object => get the week day from dateToCheck
        DayOfWeek dayOfWeek = dateToCheck.getDayOfWeek();

        //if it's between monday and friday then isWeekDay = true
//        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
//            retvalue = false;
//        } else {
//            retvalue = true;
//        }
        return !(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);
    }
    public LocalDate calculateEaster(int year) {
        if (year < 1600 || year > 2100) {
            throw new IllegalArgumentException("Invalid year. Please enter a year between 1600 and 2100.");
        }

        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int L = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * L) / 451;
        int n = h + L - 7 * m + 114;
        int month = n / 31;
        int day = (n % 31) + 1;

        return LocalDate.of(year, month, day);
    }
    public LocalDate calculateEasterMonday(int year) {
        LocalDate easterSunday = calculateEaster(year);
        return easterSunday.plusDays(1);
    }
    public boolean isHoliday(LocalDate dateToCheck, List<LocalDate> holidaysList){
        /*
        check if date is a holiday
         Make a copy of the original holidaysList to avoid modifying it
        NOTE: the List.copyOf() method returns an unmodifiable list, ArrayList is a mutable list implementation.
        By wrapping the result of List.copyOf(holidaysList) with ArrayList
         => convert the unmodifiable list to a mutable one, allowing to add elements to it.
        */

        List<LocalDate> holidays = new ArrayList<>(List.copyOf(holidaysList));
        //add Easter Monday to holidays
        LocalDate easterMonday = calculateEasterMonday(dateToCheck.getYear());
        holidays.add(easterMonday);
        //return true if dateToCheck is in holidays
        return holidays.contains(dateToCheck);
    }
    public boolean isWorkingDay(LocalDate dateToCheck, List<LocalDate> holidaysList) {
        //if date is between MON and FRI && is not a holiday => date is a working day
//        if (isWeekDay(dateToCheck) && !isHoliday(dateToCheck, holidaysList)) {
//            retvalue = true;
//        }
        return isWeekDay(dateToCheck) && !isHoliday(dateToCheck, holidaysList);
    }
    public String convertToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //return a string object
        return date.format(formatter);
    }
    public LocalDate convertToDate(String inputDate) throws IllegalArgumentException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please provide a date in the format yyyy-MM-dd.", e);
        }
    }
    public List<String> convertToStringList(List<LocalDate> localDateList){
        List<String> stringList = new ArrayList<>();
        // Iterate through each date in localDateList
//        for(int i=0; i < localDateList.size(); i++){
//            LocalDate date = localDateList.get(i);
//            String stringDate = convertToString(date);
//            stringList.add(stringDate);
//        }
        for (LocalDate date : localDateList) {
            String stringDate = convertToString(date);
            stringList.add(stringDate);
        }
        return stringList;
    }
    public List<LocalDate> convertToDateList(List<String> stringList){
        List<LocalDate> dateList = new ArrayList<>();
        // Iterate through each string in stringList
        for (String dateString : stringList) {
            LocalDate date = convertToDate(dateString);
            dateList.add(date);
        }
        return dateList;
    }

}