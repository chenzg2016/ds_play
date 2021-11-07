package com.czg.lock;

/**
 * @author chenzg
 * @date 8/6/21 10:48 AM
 * @description
 */
public class ThreadUtils{
    //根据线程id获取线程句柄
    public static Thread getThreadByThreadId(long threadId){
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null){
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++){
                if(threadId == threads[i].getId()){
                    return threads[i];
                }
            }
        }
        return null;
    }
}
