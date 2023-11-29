package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task4 {
    public static double calculateMonteCarloPi(int iterNum) {
        int circleCount = 0;
        for (int i = 0; i < iterNum; i++) {
            double x = ThreadLocalRandom.current().nextDouble(0, 1);
            double y = ThreadLocalRandom.current().nextDouble(0, 1);
            circleCount += isInCircle(x, y)? 1 : 0;
        }
        return 4.0 * circleCount / iterNum;
    }

    public static double calculateMonteCarloPiMulti(int iterNum, int threadNum) throws Exception {
        int totalCount;
        try (
            ExecutorService executorService = Executors.newFixedThreadPool(threadNum)) {
            Future<Integer>[] future = new Future[threadNum];
            for (int i = 0; i < threadNum; i++) {
                future[i] = executorService.submit(() -> simulatePoints(iterNum / threadNum));
            }
            totalCount = 0;
            for (int i = 0; i < threadNum; i++) {
                totalCount += future[i].get();
            }
            executorService.shutdown();
        }

        return 4.0 * totalCount / iterNum;
    }

    private static int simulatePoints(int iterations) {
        int circleCount = 0;
        for (int i = 0; i < iterations; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-1, 1);
            double y = ThreadLocalRandom.current().nextDouble(-1, 1);

            if (isInCircle(x, y)) {
                circleCount++;
            }
        }
        return circleCount;
    }

    private static boolean isInCircle(double x, double y) {
        return x * x + y * y <= 1;
    }
}
