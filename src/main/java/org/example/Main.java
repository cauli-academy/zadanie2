package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    //różne sposoby implementacji listy
    private static final List<Month> monthList1 = List.of(Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
    private static final List<Month> monthList2 = Arrays.stream(Month.values()).toList();

    public static void main(String[] args) {
        //---wersja bez powtórzeń
//        System.out.println("Witaj w grze.\nPodaj liczbę dni:");
//        Scanner scanner = new Scanner(System.in);
//        String userValue = scanner.nextLine();

        //różne metody
//        equalsForeachLoopLogic(userValue);
//        lessThanForeachLoopLogic(userValue);
//        lessThanStreamLogic(userValue);
//        lessThanForLoopLogic(userValue);

        //---wersja z powtórką działania po poprawnej wartości
        System.out.println("Witaj w grze.");
        int userValueAsInt;
        do {
            System.out.println("Podaj liczbę dni:");
            Scanner scanner = new Scanner(System.in);
            String userValue = scanner.nextLine();
            userValueAsInt = getUserValueAsInt(userValue);

            lessThanForeachLoopLogic(userValue);
//        lessThanStreamLogic(userValue);
//        lessThanForLoopLogic(userValue);

        } while (userValueAsInt > 0 && userValueAsInt <= monthList1.stream().mapToInt(Month::getNumberOfDays).max().getAsInt());
    }

    //inny wariant gry
    private static void equalsForeachLoopLogic(String userValue) {
        boolean atLeastOnePrinted = false;
        for (Month month : monthList1) {
            String numberOfDaysAsString = String.valueOf(month.getNumberOfDays());
            if (userValue.equals(numberOfDaysAsString)) {
                System.out.println(month.getName());
                atLeastOnePrinted = true;
            }
        }

        if (!atLeastOnePrinted) {
            System.out.println("Niepoprawna wartość");
        }
    }

    private static void lessThanForeachLoopLogic(String userValue) {
        int userValueAsInt = getUserValueAsInt(userValue);
        for (Month month : monthList1) {
            if (userValueAsInt <= month.getNumberOfDays() && userValueAsInt > 0) {
                System.out.println(month.getName());
            }
        }

        boolean anyMatch = monthList1.stream().anyMatch(month -> userValueAsInt <= month.getNumberOfDays() && userValueAsInt > 0);
        if (!anyMatch) {
            System.out.println("Niepoprawna wartość");
        }
    }

    private static void lessThanStreamLogic(String userValue) {
        int userValueAsInt = getUserValueAsInt(userValue);
        List<Month> filteredMonths = monthList2.stream().filter(month -> userValueAsInt <= month.getNumberOfDays() && userValueAsInt > 0).toList();
        if (!filteredMonths.isEmpty()) {
            filteredMonths.forEach(month -> System.out.println(month.getName()));
        } else {
            System.out.println("Niepoprawna wartość");
        }
    }

    private static void lessThanForLoopLogic(String userValue) {
        int userValueAsInt = getUserValueAsInt(userValue);

        for (int index = 0; index < monthList2.size(); index++) {
            Month currentMonth = monthList2.get(index);
            if (userValueAsInt <= currentMonth.getNumberOfDays() && userValueAsInt > 0) {
                System.out.println(currentMonth.getName());
            }
        }

        // analogiczna logika do drukowania informacji o niepoprawnej wartości wprowadzonej przez użytkownika - j.w.
        // rozwiązanie najmniej efektywne - zalecane foreach
    }


    //
    private static int getUserValueAsInt(String userValue) {
        int userValueAsInt = 0;
        try {
            userValueAsInt = Integer.parseInt(userValue);
        } catch (Exception _) {
        }
        return userValueAsInt;
    }
}