package com.luo.state;

//观察测试线程状态
public class TestState {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("......");
        });

        Thread.State state;
        //观察状态1-NEW
        state = thread.getState();
        System.out.println(state);

        //观察状态2-RUNNABLE
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED){ //只要线程不停止，就一直输出状态
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState(); //更新线程状态
            System.out.println(state);
        }

    }
}
