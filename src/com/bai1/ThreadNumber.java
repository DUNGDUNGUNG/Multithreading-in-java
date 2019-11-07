package com.bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ThreadNumber implements Runnable {

    @Override
    public void run() {
        String filePath = "/home/cong/Downloads/exjava/number2.txt";
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
