package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int currentInd = 0;

    public BackwardIterator(List<T> list) {
        this.list = list;
        currentInd = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentInd >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("Iterator is out of bounds");
        }
        currentInd--;
        return list.get(currentInd + 1);
    }
}
