package com.google.common.collect;

/**
 * 1.对不同的对象加锁不成功
 * 2.对相同的对象加锁成功，有两种方式，JDK自带的intern()以及Guava提供的Interners,
 * 推荐Guava提供的。
 */
public class InternersDemo {

    public static void main(String[] args) {
        Interner<String> pool = Interners.newWeakInterner();
        for (int i = 1; i <= 5; i++) {
            String lock = new String("lock");
            TestInterns testInterns = new TestInterns(pool, lock, i);
            Thread thread = new Thread(testInterns);
            thread.start();
        }
    }
}

class TestInterns implements Runnable {
    private String lock;
    private int out;
    private Interner<String> pool;

    public TestInterns(Interner<String> pool, String lock, int out) {
        this.lock = lock;
        this.out = out;
        this.pool = pool;
    }

    @Override
    public void run() {
        // 1.不同的lock，加锁失败
        // String lockRun = lock;

        // 2.1.利用JDK的intern()返回相同的lock，加锁成功
        // String lockRun = lock.intern();

        // 2.2.利用Guava的intern()返回相同的lock，加锁成功
        String lockRun = pool.intern(lock);

        // 重点,加锁保证原子操作
        synchronized (lockRun) {
            System.out.println(out + "-_-");
            System.out.println(out + "-" + lockRun);
            System.out.println();
        }
    }
}