package demo.tv.kevin.episode_08.example;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        final int[] sum ={ 0 };
        IntStream.range(0, 100)
                .forEach(i -> sum[0] +=i);
        System.out.println("                                 sum = " + sum[0]);

        final int[] sum2 ={ 0 };
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> sum2[0] +=i);
        System.out.println("     parallel sum (with side-effect) = " + sum2[0]);

        System.out.println("         stream sum (no side-effect) = " +
            IntStream.range(0, 100)
                    .sum()
        );

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);
        
        System.out.println("parallel stream sum (no side-effect) = " +
                IntStream.range(0, 100)
                        .parallel()
                        .sum()
        );
        System.out.println("\n=======================");
        System.out.println("Parallel Stream");
        long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallelStream()
                .map(i-> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start + "ms");

        System.out.println("\n=======================");
        System.out.println("Stream");
        long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .map(i-> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start2 + "ms");

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","1");
        System.out.println("\n=======================");
        System.out.println("Parallel Stream with 2 core");
        long start3 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i-> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start3 + "ms");


        //???
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","0");
        System.out.println("\n=======================");
        System.out.println("Parallel Stream with 1 core");
        long start4 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i-> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start4 + "ms");
    }
}
