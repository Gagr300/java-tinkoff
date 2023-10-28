package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public record Stock(String name, double price) implements Comparable<Stock> {

    public boolean equals(Stock s) {
        if (s == this) {
            return true;
        } else {
            return Objects.equals(name, s.name) && price == s.price;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(@NotNull Stock s) {
        return Double.compare(price, s.price);
    }
}
