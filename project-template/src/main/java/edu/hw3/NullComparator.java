package edu.hw3;

import java.util.Comparator;

public class NullComparator<T> implements Comparator<T> {
    @Override
    public int compare(T s1, T s2) {
        int nullCases = checkNullCases(s1, s2);
        if (nullCases != -2) {
            return nullCases;
        }
        if (!s1.getClass().isAssignableFrom(Comparable.class)) {
            return 0;
        }
        return ((Comparable<T>) s1).compareTo(s2);
    }

    private int checkNullCases(T s1, T s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s2 == null) {
            return -1;
        }
        if (s1 == null) {
            return 1;
        }
        return -2;
    }
}
