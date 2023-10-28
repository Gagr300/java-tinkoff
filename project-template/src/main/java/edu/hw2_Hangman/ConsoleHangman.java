package edu.hw2_Hangman;

import java.io.IOException;

public class ConsoleHangman extends HangmanGame {

    public ConsoleHangman(ConsolePlayer player, String guessWord) {
        super(player, guessWord);
    }

    public void run() throws IOException {
        Session session = new Session(guessWord);
        GuessResult guessResult = null;
        while (guessResult == null ||
            guessResult instanceof GuessResult.SuccessfulGuess ||
            guessResult instanceof GuessResult.FailedGuess) {
            guessResult = player.guess(session);
            System.out.println(guessResult.Message() + '\n' + "-".repeat(20));
        }
    }
}
