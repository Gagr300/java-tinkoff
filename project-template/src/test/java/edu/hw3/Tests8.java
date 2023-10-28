package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests8 {
    @Test
    @DisplayName("T-0")
    void test0() {
        List<Integer> list = List.of(1, 2, 3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);
        List<Integer> inds = new ArrayList<>();
        while (iterator.hasNext()) {
            inds.add(iterator.next());
        }
        assertEquals(List.of(3, 2, 1), inds);
    }
}
