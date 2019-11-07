package com.bai3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private String filePath;
    private BlockingQueue<String> drop;

    public Producer(BlockingQueue<String> drop, String filePath) {
        this.drop = drop;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        Reader reader;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(filePath);
            bufferedReader = new BufferedReader(reader);

            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                if (!currentLine.equals("")) {
                    boolean test = drop.offer(currentLine, 3, TimeUnit.SECONDS);
                    if (!test) {
                        System.out.println("BlockingQueue is full now");
                    }
                }
            }
            drop.put("DONE");

        } catch (IOException | InterruptedException e) {
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
