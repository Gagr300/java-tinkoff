package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.Objects;

public record Stock(String name, double price) {

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

    public static final Comparator<Stock> PRICE_COMPARATOR = Comparator
        .comparingDouble(Stock::price).reversed();
}
