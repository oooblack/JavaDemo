package com.xiayu.JavaDemo.xiayu.java.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author: starc
 * @date: 2019/6/25
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(1000),
                new ThreadPoolExecutor.AbortPolicy());
    }

    @Test
    public void newCachedThreadPoolDemo() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Thread(() -> {

        })


        );
    }

    @Test
    public void newFixedThreadPoolDemo() {
        //ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("1---" + i);
            }
        })
        );
        executorService.execute(new Thread(() -> {
            System.out.println("t2开始运行");
            for (int i = 0; i < 10000; i++) {
                System.out.println("2---" + i);
            }
        })
        );
        for (int i = 0; i < 1000000; i++) {
            System.out.print("");
        }
    }

    /*
    任务顺序
     */
    @Test
    public void newSingleThreadPoolDemo() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("1---" + i);
            }
        });
        executorService.execute(() -> {
            System.out.println("t2开始运行");
            for (int i = 0; i < 10000; i++) {
                System.out.println("2---" + i);
            }
        }
        );
        executorService.execute(() -> {
            System.out.println("t3开始运行");
            for (int i = 0; i < 10000; i++) {
                System.out.println("3---" + i);
            }
        }
        );
        executorService.execute(() -> {
            System.out.println("t4开始运行");
            for (int i = 0; i < 10000; i++) {
                System.out.println("4---" + i);
            }
        }
        );
        executorService.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("t5开始运行");
                                        for (int i = 0; i < 10000; i++) {
                                            System.out.println("5---" + i);
                                        }
                                    }
                                }
        );
        for (int i = 0; i < 1000000; i++) {
            System.out.print("");
        }
    }
}
