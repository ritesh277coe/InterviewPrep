package org.example.design.pattern.creational.builder;

public class TestBuilder {
    private int a;

    private TestBuilder() {}

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getA() {
        return a;
    }

    public static class Builder {
        int a;
        public Builder() {
        }

        public Builder setA(int a) {
            this.a = a;
            return this;
        }

        public TestBuilder build() {
            TestBuilder ex = new TestBuilder();
            ex.a = a;

            return ex;
        }
    }
}
