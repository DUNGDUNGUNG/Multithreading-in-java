package com.bai3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private BlockingQueue drop;

    public Consumer(BlockingQueue drop) {
        this.drop = drop;
    }

    @Override
    public void run() {

        try {
            String msg = null;
            while (true) {
                msg = (String) drop.poll(3, TimeUnit.SECONDS); // 2
                if (msg == null) {
                    System.out.println("BlockingQueue is empty now");
                }
                if (msg.equals("DONE")) {
                    break;
                }
                System.out.println(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
