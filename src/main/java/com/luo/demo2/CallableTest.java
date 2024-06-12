package com.luo.demo2;

import com.luo.demo1.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallableTest implements Callable<Boolean> {
    private String sourceUrl;
    private String fileName;

    public CallableTest(String sourceUrl, String fileName){
        this.sourceUrl = sourceUrl;
        this.fileName = fileName;
    }

    @Override
    public Boolean call() throws Exception {
        //重写
        new CallableTest.webDownLoader().downLoader(sourceUrl, fileName);
        System.out.println("下载了文件名为：" + fileName);
        return true;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建Callable线程
        CallableTest t1 = new CallableTest("https://p4.itc.cn/q_70/images01/20231219/676ab03391d54237a8b2da2e5f5d60db.jpeg", "src/main/resources/pic/txw1.jpg");
        CallableTest t2 = new CallableTest("https://p8.itc.cn/q_70/images01/20231219/b35c88a433044938ac654b3d70659020.jpeg", "src/main/resources/pic/txw2.jpg");
        CallableTest t3 = new CallableTest("https://p4.itc.cn/q_70/images01/20231219/a0b0e4a89074439cbe431630f34fdf2e.jpeg", "src/main/resources/pic/txw3.jpg");

        //2.创建执行任务,开启服务,创建线程池
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //3.提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //4.获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        //5.关闭服务
        ser.shutdown();
    }
}
