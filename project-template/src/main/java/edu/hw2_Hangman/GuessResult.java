package edu.hw2_Hangman;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    String Message();

    record Defeat(String word) implements GuessResult {
        public String Message() {
            return "Defeat! " + word;
        }
    }

    record Win(String word) implements GuessResult {
        public String Message() {
            return "Win! " + word;
        }
    }

    record SuccessfulGuess(String word) implements GuessResult {
        public String Message() {
            return "SuccessfulGuess! " + word;
        }
    }

    record FailedGuess(String word) implements GuessResult {
        public String Message() {
            return "FailedGuess! " + word;
        }
    }

    record Error(String word) implements GuessResult {
        public String Message() { return "Error! " + word + "The game is over"; }
    }
}
