package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private HashMap<Character, Character> replacement;

    public Task1() {
        replacement = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            replacement.put((char) ('a' + i), (char) ('z' - i));
            replacement.put((char) ('A' + i), (char) ('Z' - i));
        }
    }

    public String atbash(String message) {
        StringBuilder encodedmessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (replacement.containsKey(c)) {
                encodedmessage.append(replacement.get(c).charValue());
            } else {
                encodedmessage.append(c);
            }
        }
        return encodedmessage.toString();
    }

}
