package org.example;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class TestEx {
    private int a;
    //private static final TestEx defaultEx = new TestEx();
    public TestEx() {

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int a;

        public Builder(){};

        Builder setA(int a) {
            this.a = a;
            return this;
        }

        public TestEx build( ) {
            TestEx ex = new TestEx();
            ex.a = this.a;
            return ex;
        }

    }
}
