package edu.hw2_Hangman;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    void Message();

    record Defeat(String word) implements GuessResult {
        public void Message() {
            System.out.println("Defeat! " + word);
            System.out.println("-".repeat(20));
        }
    }

    record Win(String word) implements GuessResult {
        public void Message() {
            System.out.println("Win! " + word);
            System.out.println("-".repeat(20));
        }
    }

    record SuccessfulGuess(String word) implements GuessResult {
        public void Message() {
            System.out.println("SuccessfulGuess! " + word);
            System.out.println("-".repeat(20));
        }
    }

    record FailedGuess(String word) implements GuessResult {
        public void Message() {
            System.out.println("FailedGuess! " + word);
            System.out.println("-".repeat(20));
        }
    }

}
