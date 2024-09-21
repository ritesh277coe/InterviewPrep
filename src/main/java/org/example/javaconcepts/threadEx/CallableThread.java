package org.example.javaconcepts.threadEx;

import java.util.Timer;
import java.util.concurrent.*;

public class CallableThread {

    private static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int i = 0;
            while (i < 10000) {
                Thread.sleep(1000);
                System.out.println("INSIDE THREAD" + Thread.currentThread().getName());
                i++;
            }
            return new Integer(10);
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future = executorService.submit(task);
        Integer integer = null;
//        while (integer == null) {
//            try {
//                integer = future.get(1, TimeUnit.SECONDS); //.get is blocking call
//            } catch (TimeoutException e) {
//                //throw new RuntimeException(e);
//            }
//            System.out.println(integer);
//        }

        Future<Integer>  future1 = executorService.submit(task);
        Future<Integer>  future2 = executorService.submit(task);
        integer = 0;
        while (integer == null) {
            try {
                integer = future.get(1, TimeUnit.SECONDS); //.get is blocking call
            } catch (TimeoutException e) {
                //throw new RuntimeException(e);
            }
            System.out.println(integer);
        }

        executorService.shutdown();
        while (!executorService.isShutdown()){
            System.out.println("Still running");
        }

        RunnableTask runnableTask = new RunnableTask();
        Integer cool = 100;
        System.out.println("TESTING COMPLETEABLEFUTURE");
        CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName());
                    return new Integer(1);
                })
                .thenApplyAsync((i) -> {
                    System.out.println(Thread.currentThread().getName());
                    return ++i;})
                .thenAccept((i) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(i);})
                .thenRun(() -> {
                    System.out.println("its runnable interface blocking main thread");
                })
                .thenRun(runnableTask)
                .thenRunAsync(runnableTask);

        int loop = 10;
        while (loop > 0) {
            System.out.println("Wait in thread:"
                    + Thread.currentThread().getName()
                    + " because supplyasync is sleeping");
            loop--;

            Thread.sleep(1000);
        }

        Thread.sleep(1000000000);
    }
}
