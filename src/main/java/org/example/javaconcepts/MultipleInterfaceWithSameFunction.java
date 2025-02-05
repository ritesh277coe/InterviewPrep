package org.example.javaconcepts;


public class MultipleInterfaceWithSameFunction implements IOne, ITwo  {

        @Override
        public void test() {
            IOne.super.test();
        }

        @Override
        public void func1() {
            System.out.println("func1");
        }

        @Override
        public void func2() {
            System.out.println("func2");
        }

        public static void main(String[] args) {
            MultipleInterfaceWithSameFunction c = new MultipleInterfaceWithSameFunction();
            c.test();

    }
}
