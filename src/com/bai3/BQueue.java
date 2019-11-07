package com.bai3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BQueue {
    public static void main(String[] args) {
        String filePath1 = "/home/cong/Downloads/exjava/number1.txt";
        String filePath2 = "/home/cong/Downloads/exjava/number2.txt";
        String filePath3 = "/home/cong/Downloads/exjava/number3.txt";

        BlockingQueue drop = new LinkedBlockingDeque();
        Producer producer1 = new Producer(drop, filePath1);
        Producer producer2 = new Producer(drop, filePath2);
        Producer producer3 = new Producer(drop, filePath3);
        Consumer consumer = new Consumer(drop);

        Thread threadP1 = new Thread(producer1);
        Thread threadP2 = new Thread(producer2);
        Thread threadP3 = new Thread(producer3);
        Thread threadC = new Thread(consumer);

        threadP1.start();
        threadP2.start();
        threadP3.start();
        threadC.start();
    }
}


