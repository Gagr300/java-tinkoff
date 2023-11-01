package edu.hw3.Task5;

import java.util.Comparator;
import java.util.Objects;

public record PhoneContact(String name, String surname) {
    PhoneContact(String name) {
        this(name, "");
    }

    public static final Comparator<PhoneContact> ASC = Comparator
        .comparing(PhoneContact::surname)
        .thenComparing(PhoneContact::name);

    public static final Comparator<PhoneContact> DES = ASC.reversed();
}
