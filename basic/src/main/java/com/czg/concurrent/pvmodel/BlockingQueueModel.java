package com.czg.concurrent.pvmodel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzg
 * @date 2018.08.22 15:27
 * @description
 **/
public class BlockingQueueModel implements Model{

    private final BlockingQueue<Task> queue;

    private final AtomicInteger increTaskNo = new AtomicInteger(0);


    public BlockingQueueModel(int cap){
        this.queue = new LinkedBlockingQueue<>(cap);
    }
    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    private class ProducerImpl extends AbstractProducer implements Runnable,Producer{

        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            queue.put(task);

            System.out.println("produce: " + task.no);
        }

    }

    private class ConsumerImpl extends AbstractConsumer implements Runnable,Consumer {

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.no);
        }
    }

    public static void main(String[] args) {
        Model model = new BlockingQueueModel(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}

