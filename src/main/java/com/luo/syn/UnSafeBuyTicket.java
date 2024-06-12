package com.luo.syn;

//不安全的买票
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "旅客1").start();
        new Thread(station, "旅客2").start();
        new Thread(station, "旅客3").start();
    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNum = 10;
    boolean flag = true; //外部停止方式

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        if(ticketNum <= 0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);

        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNum--);
    }
}
