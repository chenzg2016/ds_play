package com.czg.ajcp.ch05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * @author chenzg
 * @date 2019.01.14 15:39
 * @description
 **/
public class Mutex {
    private static class Sync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }

        public boolean tryAccuire(int acquires){
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases){
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();
    public void lock(){
        sync.acquire(1);
    }
    public boolean tryLock(){
        return sync.tryAccuire(1);
    }

    public void unlock(){
        sync.release(1);
    }

    public Condition newCondition(){
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException{
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException{
        return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }
}

