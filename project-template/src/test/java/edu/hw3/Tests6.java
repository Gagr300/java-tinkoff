package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests6 {
    @Test
    @DisplayName("T-0")
    void testAdd() {
        Market market = new Market();
        Stock stock1 = new Stock("stock1", 10);
        Stock stock2 = new Stock("stock2", 9);
        Stock stock3 = new Stock("stock3", 10.0001);
        market.add(stock1);
        market.add(stock2);
        market.add(stock3);

        Stock mostValuableStock = market.mostValuableStock();

        assertEquals(stock3, mostValuableStock);
    }

    @Test
    @DisplayName("T-1")
    void tesRemove() {
        Market market = new Market();
        Stock stock1 = new Stock("stock1", 10);
        Stock stock2 = new Stock("stock2", 9);
        Stock stock3 = new Stock("stock3", 10.0001);
        market.add(stock1);
        market.add(stock2);
        market.add(stock3);
        market.remove(stock3);

        Stock mostValuableStock = market.mostValuableStock();

        assertEquals(stock1, mostValuableStock);
    }
}
