package com.bai2;

public class SynchronizedDemo {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        Thread thread0 = new Thread(threadOne);
        Thread thread1 = new Thread(threadOne);
        Thread thread2 = new Thread(threadOne);
        Thread thread3 = new Thread(threadOne);
        Thread thread4 = new Thread(threadOne);
        Thread thread5 = new Thread(threadOne);
        Thread thread6 = new Thread(threadOne);
        Thread thread7 = new Thread(threadOne);
        Thread thread8 = new Thread(threadOne);
        Thread thread9 = new Thread(threadOne);

        ThreadTwo threadTwo = new ThreadTwo();
        Thread thread10 = new Thread(threadTwo);
        Thread thread11 = new Thread(threadTwo);
        Thread thread12 = new Thread(threadTwo);
        Thread thread13 = new Thread(threadTwo);
        Thread thread14 = new Thread(threadTwo);
        Thread thread15 = new Thread(threadTwo);
        Thread thread16 = new Thread(threadTwo);
        Thread thread17 = new Thread(threadTwo);
        Thread thread18 = new Thread(threadTwo);
        Thread thread19 = new Thread(threadTwo);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        thread16.start();
        thread17.start();
        thread18.start();
        thread19.start();
    }
}

class ThreadOne implements Runnable {

    private int i = 1;

    @Override
    public void run() {

        try {
            Thread.sleep(20);
            System.out.println(Thread.currentThread().getName() + " : " + i++);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTwo implements Runnable {

    private int j = 1;

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(20);
            System.out.println(Thread.currentThread().getName() + " : " + j++);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}