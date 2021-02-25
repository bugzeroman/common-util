package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ListenableFuture就是可以监听的Future，
 * 它是对java原生Future的扩展增强。
 * Future表示一个异步计算任务，
 * 当任务完成时可以得到计算结果。
 * 使用ListenableFuture Guava帮我们检测Future是否完成了，
 * 如果完成就自动调用回调函数。
 *
 */
public class ListenableFutureDemo {
    public static void main(String[] args) throws Exception {
        // createListeningExecutorService();
        // addListenerHandleResult();
        addCallbackHandleResult();
    }

    /**
     * 执行此Future并执行Future完成之后的回调函数,获得异步执行的返回结果
     * 方法一：通过ListenableFuture的addListener方法
     */
    public static void addListenerHandleResult() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(3);
                return 7;
            }
        });
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("get listenable future's result " + listenableFuture.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, executorService);
    }

    /**
     * 执行此Future并执行Future完成之后的回调函数,获得异步执行的返回结果
     * 方法二：通过Futures的静态方法addCallback给ListenableFuture添加回调函数
     */
    public static void addCallbackHandleResult() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(3);
                return 7;
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, MoreExecutors.directExecutor());
        // 使用executorService也可以替代directExecutor()
    }

    /**
     * 创建ListenableFuture对象
     */
    public static ListenableFuture<Integer> createListenableFuture() throws Exception {
        // 创建装饰过的线程池
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(3);
                return 7;
            }
        });
        return listenableFuture;
    }

    /**
     * 创建ListenableFuture对象，并且阻塞直到获取结果
     */
    public static void createAndGetListeningExecutorService() throws Exception {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(3);
                return 7;
            }
        });
        // get方法会阻塞直到异步执行的任务返回结果
        Integer result = listenableFuture.get();
        System.out.println("async result=" + result);
    }
}
