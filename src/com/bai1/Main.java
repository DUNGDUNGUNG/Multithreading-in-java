package com.bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {
        String filePath1 = "/home/cong/Downloads/exjava/number1.txt";
        String filePath3 = "/home/cong/Downloads/exjava/number3.txt";

        ThreadNumber threadNumber = new ThreadNumber();
        Thread thread2 = new Thread(threadNumber);

        NumberPhoneThread thread3 = new NumberPhoneThread(filePath3);
        NumberPhoneThread thread1 = new NumberPhoneThread(filePath1);

        thread1.setName("number1.txt");
        thread2.setName("number2.txt");
        thread3.setName("number3.txt");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class NumberPhoneThread extends Thread {

    private String filePath;

    NumberPhoneThread(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        Reader reader;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(filePath);
            bufferedReader = new BufferedReader(reader);

            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                int sum = 0;
                if (currentLine.length() != 0) {
                    for (int i = currentLine.length() - 1; i >= currentLine.length() - 3; i--) {

                        char character = currentLine.charAt(i);
                        int number = Character.getNumericValue(character);
                        sum += number;
                    }
                    if (sum > 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + currentLine + ": " + sum);
                    }
                } else {
                    System.out.println("khong co du lieu");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

