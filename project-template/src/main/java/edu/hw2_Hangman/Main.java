package edu.hw2_Hangman;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException {
        ConsoleHangman consoleHangman = new ConsoleHangman();
        consoleHangman.run();
    }
}
