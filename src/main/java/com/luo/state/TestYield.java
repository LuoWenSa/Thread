package com.luo.state;

public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"a线程").start();
        new Thread(myYield,"b线程").start();

    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " --> start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " --> end");
    }
}
