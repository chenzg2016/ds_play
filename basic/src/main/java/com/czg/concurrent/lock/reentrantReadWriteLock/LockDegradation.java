package com.czg.concurrent.lock.reentrantReadWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenzg
 * @date 8/4/21 4:58 PM
 * @description
 * 读写锁的 降级
 */
public class LockDegradation implements Runnable{

    /**
     * 当前资源
     */
    private Integer resource = 1;

    /**
     * 共享资源(存放在数据库)
     */
    private static Integer shareResources = 1;

    /**
     * 数据是是否发生变更，false 发生了变更
     */
    public static volatile boolean update = true;

    private ReentrantReadWriteLock reentrantReadWriteLock;

    public LockDegradation() {
        reentrantReadWriteLock = new ReentrantReadWriteLock();
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            work();
        }
    }

    public void work() {
        reentrantReadWriteLock.readLock().lock();

        if (!update) {
            // 先释放读锁，应为修改需要
            reentrantReadWriteLock.readLock().unlock();

            // 锁降级开始
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (!update) {
                    // 准备数据
                    System.out.println("【开始获取新数据】" );
                    resource = getShareResourcesFromDb();
                    System.out.println("【获取新数据结束】" );
                    update = true;
                }
                reentrantReadWriteLock.readLock().lock();
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
                // 锁降级结束,降级为读锁
            }
        }
        try {
            // 使用数据
            System.out.println(Thread.currentThread().getName() + ":" + resource);
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        LockDegradation lockDegradation = new LockDegradation();
        Thread thread1 = new Thread(lockDegradation);
        Thread thread2 = new Thread(lockDegradation);
        Thread thread3 = new Thread(lockDegradation);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockDegradation.reentrantReadWriteLock.writeLock().lock();
        System.out.println("【修改数据】开始");
        updateShareResourcesFromDb(2);
        // 数据发成变更后，update修改为 false
        update = false;
        System.out.println("【修改数据】结束");
        lockDegradation.reentrantReadWriteLock.writeLock().unlock();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockDegradation.reentrantReadWriteLock.writeLock().lock();
        System.out.println("【修改数据】开始");
        updateShareResourcesFromDb(3);
        // 数据发成变更后，update修改为 false
        update = false;
        System.out.println("【修改数据】结束");
        lockDegradation.reentrantReadWriteLock.writeLock().unlock();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockDegradation.reentrantReadWriteLock.writeLock().lock();
        System.out.println("【修改数据】开始");
        updateShareResourcesFromDb(4);
        // 数据发成变更后，update修改为 false
        update = false;
        System.out.println("【修改数据】结束");
        lockDegradation.reentrantReadWriteLock.writeLock().unlock();
    }

    /**
     * 模拟从数据库中获取数据
     */
    public Integer getShareResourcesFromDb() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shareResources;
    }

    /**
     * 模拟修改数据库中数据
     */
    public static synchronized void updateShareResourcesFromDb(Integer newShareResources) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shareResources = newShareResources;
    }


}
