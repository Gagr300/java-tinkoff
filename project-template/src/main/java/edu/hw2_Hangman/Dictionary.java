package edu.hw2_Hangman;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Dictionary {
    private List<String> dictionary = List.of("one", "two", "three", "hello", "mistake", "hangman");
    private final Random rnd = new Random();

    public String getRandomWord() {
        return dictionary.get(rnd.nextInt(dictionary.size()));
    }

    public List<String> getDictionary() {
        return dictionary;
    }

}
