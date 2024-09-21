package org.example.javaconcepts.threadEx;

public class RunnableTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
