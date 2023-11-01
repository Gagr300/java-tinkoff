package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class Task4 {

    private static Map<Integer, String> converted = Map.ofEntries(
        entry(1, "I"), entry(4, "IV"), entry(5, "V"),
        entry(9, "IX"), entry(10, "X"), entry(40, "XL"),
        entry(50, "L"), entry(90, "XC"), entry(100, "C"),
        entry(400, "CD"), entry(500, "D"), entry(900, "CM"),
        entry(1000, "M")
    );

    public static String convertToRoman(int num) {
        StringBuilder rimnum = new StringBuilder();
        if (num > 10000) {
            return "";
        }
        List<Integer> keys = new ArrayList<>(converted.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);
        for (int k : keys) {
            while (num >= k) {
                num -= k;
                rimnum.append(converted.get(k));

            }
        }
        return rimnum.toString();
    }
}
