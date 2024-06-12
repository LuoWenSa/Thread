package com.luo.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread{

    private String sourceUrl;
    private String fileName;

    public TestThread2(String sourceUrl, String fileName){
        this.sourceUrl = sourceUrl;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        //重写
        new webDownLoader().downLoader(sourceUrl, fileName);
        System.out.println("下载了文件名为：" + fileName);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://p4.itc.cn/q_70/images01/20231219/676ab03391d54237a8b2da2e5f5d60db.jpeg", "src/main/resources/pic/txw1.jpg");
//        TestThread2 t2 = new TestThread2("https://p8.itc.cn/q_70/images01/20231219/b35c88a433044938ac654b3d70659020.jpeg", "txw2.jpg");
//        TestThread2 t3 = new TestThread2("https://p4.itc.cn/q_70/images01/20231219/a0b0e4a89074439cbe431630f34fdf2e.jpeg", "txw3.jpg");

        t1.start();
//        t2.start();
//        t3.start();
    }



    //下载器
    class webDownLoader{
        public void downLoader(String sourceUrl, String fileName){
            try {
                FileUtils.copyURLToFile(new URL(sourceUrl), new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO失败，下载文件失败");
            }
        }
    }
}
