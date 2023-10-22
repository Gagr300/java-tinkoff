package edu.hw2_Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHangman {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Dictionary dictionary = new Dictionary();
        Session session = new Session(dictionary.getRandomWord());
        GuessResult guessResult = null;
        while (guessResult == null ||
            guessResult instanceof GuessResult.SuccessfulGuess ssuccessfulGuess ||
            guessResult instanceof GuessResult.FailedGuess failedGuess) {
            String input = br.readLine();
            guessResult = session.guess(input.charAt(0));
            guessResult.Message();
        }
    }
}
