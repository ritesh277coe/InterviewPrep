package org.example.javaconcepts.threadEx;

public class SimpleRunnableThread {

    public static void main(String[] args) throws InterruptedException {
        RunnableTask task = new RunnableTask();
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
    }
}
