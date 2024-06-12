package com.luo.state;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 1; i <= 50; i++) {
            System.out.println("main线程" + i);
            if(i == 2){
                thread.join(); //线程插队
            }
        }
    }
}
