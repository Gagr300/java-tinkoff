package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private HashMap<Character, Character> replacement;

    public Task1() {
        replacement = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch ++){
            replacement.put(ch, (char) ('z' - ch + 'a'));
        }
        for (char ch = 'A'; ch <= 'Z'; ch ++){
            replacement.put(ch, (char) ('Z' - ch + 'A'));
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
