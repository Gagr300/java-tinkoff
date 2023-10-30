package edu.hw2_Hangman;

public class Session {
    private String word;
    private StringBuilder userWord;
    private final int n;
    private final int maxAttempts = 5;
    private int attempts;

    Session(String word) {
        this.word = word;
        n = word.length();
        userWord = new StringBuilder("*".repeat(n));
    }
    GuessResult guess(char guess) {
        boolean guessed = false;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == guess) {
                userWord.setCharAt(i, guess);
                guessed = true;
            }
        }

        if (userWord.indexOf("*") == -1) {
            return new GuessResult.Win(word);
        }
        if (attempts == maxAttempts) {
            return new GuessResult.Defeat.FailedGuess(word);
        }
        if (guessed) {
            return new GuessResult.SuccessfulGuess(userWord.toString());
        }
        attempts++;
        return new GuessResult.FailedGuess(
            userWord.toString() + "\tMistake " + attempts + " out of " + maxAttempts);

    }

    GuessResult endGame(){
        return new GuessResult.Error(word);
    }
}
