package edu.hw3.Task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final ArrayList<T> list;
    private int currentInd = 0;

    public BackwardIterator(Collection<T> collection) {
        this.list = new ArrayList<>(collection);
        currentInd = collection.size() - 1;
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
