package com.adx.core.index;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: sajith
 * Date: 15/6/11
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class IndexUI {

    private boolean started = false;
    private IndexBuilder indexBuilder;
    private IndexWorker worker = new IndexWorker(indexBuilder);
    private Thread workerThread;

    public void mainLoop() throws IOException, InterruptedException {
        printMenu();
        boolean loop = true;
        worker.setLoop(false);

        while(loop) {
            int resonse = System.in.read();

            switch (resonse) {
                case 1:
                    startIndex();
                    printMenu();
                    break;
                case 2:
                    stopIndex();
                    loop = false;
                    break;
                case 3:
                    dumpIndex();
                    break;
                default:
                    printMenu();
            }

        }
    }

    private void dumpIndex() {


    }

    private void stopIndex() throws InterruptedException {
        if (started) {
            worker.setLoop(false);
            System.out.println("waiting for index to stop ....");
            workerThread.join();
            System.out.println("Index stoped");
        }
    }

    private void startIndex() {
        if (!started) {
            worker.setLoop(true);
            workerThread = new Thread(worker);
            workerThread.start();
            started = true;
            System.out.println("Index started");
        }
    }


    public void printMenu() {
        System.out.println("______________");
        System.out.println("1. Start");
        System.out.println("2. Stop");
        System.out.println("3. Dump");
        System.out.println("______________");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new IndexUI().mainLoop();
    }
}

class IndexWorker implements Runnable {

    private IndexBuilder indexBuilder;
    private volatile boolean loop = true;
    public static final long timeout = 3000;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    IndexWorker(IndexBuilder indexBuilder) {
        this.indexBuilder = indexBuilder;
    }

    public void run() {
        while (loop) {
            try {
                Thread.sleep(timeout);
                int count = indexBuilder.buildIndex();
                System.out.println(count + " number of documents indexed.");
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
