package com.luo.state;

//测试守护线程-神守护人类
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        People people = new People();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //设置为守护线程

        thread.start();
        new Thread(people).start();
    }
}

//人类
class People implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("第" + (i + 1) + "年在世界上活着");
        }
        System.out.println("======活腻了======");
    }
}

//神
class God implements Runnable{

    @Override
    public void run() {
        System.out.println("god着守护你");
    }
}
