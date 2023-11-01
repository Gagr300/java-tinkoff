package edu.hw3.Task6;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import static edu.hw3.Task6.Stock.PRICE_COMPARATOR;

public class Market implements StockMarket {
    private Queue<Stock> stocks = new PriorityQueue<>(PRICE_COMPARATOR);

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
