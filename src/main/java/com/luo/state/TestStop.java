package com.luo.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStop implements Runnable{
    private boolean stopFlag = false;

    @Override
    public void run() {
        int i = 0;
        while (!stopFlag){
            System.out.println(++i + ": Thread is running...");
        }
    }

    public void stop(){
        this.stopFlag = true;
    }

    public static void main(String[] args) {
        TestStop thread = new TestStop();
        new Thread(thread).start();
        for (int i = 0; i < 50; i++) {
            System.out.println((i+1) + ": Main Thread is running...");
            if(i == 40){
                thread.stop();
                System.out.println("子线程停止了");
            }
        }
    }
}
