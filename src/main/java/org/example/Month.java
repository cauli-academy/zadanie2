package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Month {

    JANUARY("Styczeń", 31),
    FEBRUARY("Luty", 28),
    MARCH("Marzec", 31),
    APRIL("Kwiecień", 30),
    MAY("Maj", 31),
    JUNE("Czerwiec", 30),
    JULY("Lipiec", 31),
    AUGUST("Sierpień", 31),
    SEPTEMBER("Wrzesień", 30),
    OCTOBER("Październik", 31),
    NOVEMBER("Listopad", 30),
    DECEMBER("Grudzień", 31);

    private final String name;
    private final int numberOfDays;
}