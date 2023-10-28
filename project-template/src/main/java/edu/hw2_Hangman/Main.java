package edu.hw2_Hangman;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException {
        ConsolePlayer player = new ConsolePlayer();
        Dictionary dictionary = new Dictionary();
        String guessWord = dictionary.getRandomWord();
        ConsoleHangman hangmanGame = new ConsoleHangman(player, guessWord);
        hangmanGame.run();
    }
}
