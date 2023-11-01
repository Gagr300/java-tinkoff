package edu.hw2_Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePlayer extends Player {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    GuessResult guess(Session session) throws IOException {
        String input;
        try {
            input = br.readLine();

        } catch (IOException e) {
            throw new IOException(e);
        }
        if (input.length() != 1) {
            return session.endGame();
        }
        char guessChar = input.charAt(0);
        return session.guess(guessChar);

    }
}
