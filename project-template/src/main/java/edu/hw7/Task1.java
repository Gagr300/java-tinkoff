package edu.hw7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Task1 {
    public static int task1(int num, int threadCnt) throws InterruptedException {
        if (threadCnt < 1) {
            return -1;
        }
        var ans = new AtomicInteger(num);
        Thread[] threads = new Thread[threadCnt];
        for (int i = 0; i < threadCnt; ++i) {
            threads[i] = new Thread(ans::incrementAndGet);
            threads[i].start();
        }
        for (int i = 0; i < threadCnt; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return ans.get();
    }
}
