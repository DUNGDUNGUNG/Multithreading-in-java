package com.bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run() {
                String filePath = "/home/cong/Downloads/exjava/number1.txt";
                BufferedReader bufferedReader = null;
                Reader reader;

                try {
                    reader = new FileReader(filePath);
                    bufferedReader = new BufferedReader(reader);

                    String currentLine;

                    while ((currentLine = bufferedReader.readLine()) != null) {
                        int sum = 0;
                        for (int i = currentLine.length() - 1; i >= currentLine.length() - 3; i--) {

                            char character = currentLine.charAt(i);
                            int number = Character.getNumericValue(character);
                            sum += number;
                        }
                        if (sum > 10) {
                            System.out.println("number1.txt: " + ": " + currentLine + ": " + sum);
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
        };

        ThreadNumber threadNumber = new ThreadNumber();
        Thread thread2 = new Thread(threadNumber);

        NumberPhoneThread thread3 = new NumberPhoneThread();

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class NumberPhoneThread extends Thread {

    public void run() {

        String filePath = "/home/cong/Downloads/exjava/number3.txt";
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
                        System.out.println("number3.txt: " + ": " + currentLine + ": " + sum);
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

