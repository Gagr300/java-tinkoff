package edu.hw3.Task5;

import java.util.Comparator;
import java.util.Objects;

public record PhoneContact(String name, String surname) {
    PhoneContact(String name) {
        this(name, "");
    }

    public static final Comparator<PhoneContact> comparatorASC = new Comparator<PhoneContact>() {
        public int compare(PhoneContact e1, PhoneContact e2) {
            String comp1 = Objects.equals(e1.surname(), "") ? e1.name() : e1.surname();
            String comp2 = Objects.equals(e2.surname(), "") ? e2.name() : e2.surname();
            return comp1.compareTo(comp2);
        }
    };

    public static final Comparator<PhoneContact> comparatorDES = new Comparator<PhoneContact>() {
        public int compare(PhoneContact e1, PhoneContact e2) {
            String comp1 = Objects.equals(e1.surname(), "") ? e1.name() : e1.surname();
            String comp2 = Objects.equals(e2.surname(), "") ? e2.name() : e2.surname();
            return comp2.compareTo(comp1);
        }
    };
}
