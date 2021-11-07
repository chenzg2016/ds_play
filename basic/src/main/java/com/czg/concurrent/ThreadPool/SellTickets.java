package com.czg.concurrent.ThreadPool;

/**
 * @author chenzg
 * @date 2019.05.02 21:59
 * @description
 **/
public class SellTickets {


    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        // 　实例化几个抢票用户
        Thread mary = new Thread(ticket, "玛丽");
        Thread tom = new Thread(ticket, "汤姆");
        Thread jack = new Thread(ticket, "杰克");
        Thread helen = new Thread(ticket, "海伦");

        mary.start();
        tom.start();
        jack.start();
        helen.start();

    }

}