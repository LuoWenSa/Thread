package com.luo.demo1;

//创建线程方式二：实现Runnable接口
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        //run方法，可重写
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码" + i);
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new TestThread3());
        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
