package edu.hw3;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Task3 {

    public static <T> HashMap<T, Integer> freqDict(Collection<T> list) {
        HashMap<T, Integer> freq = new HashMap<>();

        for (T o : list) {
            if (freq.containsKey(o)) {
                freq.put(o, freq.get(o) + 1);
            } else {
                freq.put(o, 1);
            }
        }

        return freq;
    }
}
