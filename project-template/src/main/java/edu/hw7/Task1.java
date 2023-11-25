package edu.hw7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Task1 {
    public static int task1(int num, int threadCnt) throws InterruptedException {
        if (threadCnt < 1) return -1;
        CountDownLatch countDownLatch = new CountDownLatch(threadCnt);
        var ans = new AtomicInteger(num);
        Stream.generate(() ->
                new Thread(() -> {
                    ans.incrementAndGet();
                    countDownLatch.countDown();
                })
            ).limit(threadCnt).forEach(Thread::start);
        countDownLatch.await();
        return ans.get();
    }
}
