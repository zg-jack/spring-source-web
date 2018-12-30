package com.zhuguang.jack.test;

import java.util.concurrent.*;

public class XX {

    private static ExecutorService es = new ThreadPoolExecutor(50,100,0L,TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(100000));

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 100000; i++) {
//            es.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(1);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//
//        ThreadPoolExecutor tpe = (ThreadPoolExecutor)es;
//        while(true) {
//            System.out.println();
//            int queueSize = tpe.getQueue().size();
//            System.out.println("当前排队线程数："+ queueSize);
//
//            int activeCount = tpe.getActiveCount();
//            System.out.println("当前活动线程数：" + activeCount);
//
//            long completedThreadCount = tpe.getCompletedTaskCount();
//            System.out.println("执行完成线程数：" + completedThreadCount);
//
//            long taskCount = tpe.getTaskCount();
//            System.out.println("总线程数：" + taskCount);
//
//            Thread.sleep(3000);
//        }
        /*final CountDownLatch cdl = new CountDownLatch(5);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //介绍一个线程就对发令枪减一，直到发令枪中的数字减到为0时，主程序才会从await处执行
                        cdl.countDown();
                    }
                }
            }).start();
        }

        cdl.await();
        System.out.println(cdl.getCount());
        System.out.println("线程执行耗时为：" + (System.currentTimeMillis() - start));*/

        final CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("cyclicBarrier finish");
            }
        });
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程执行耗时：" + (System.currentTimeMillis() - start));
                }
            }).start();
        }
    }
}
