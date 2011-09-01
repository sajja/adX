package com.adX.adserver;

import java.io.*;
import java.util.Date;
import java.util.Random;

public class LogGenerator implements Runnable {

    private volatile boolean running = true;
    private String localLogPath;
    private volatile String status = "NOT_RUNNING";

    public LogGenerator(String localLogPath) {
        this.localLogPath = localLogPath;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void run() {
        Random r = new Random();
        BufferedWriter bw = null;
        try {
            File f = new File("");
            f.lastModified();

            bw = new BufferedWriter(new FileWriter(new File(localLogPath + "/" + new Date().getTime())));
            int count = 0;
            running = true;
            while (running) {
                status = "RUNNING";
                if (count > 300) {
                    bw.flush();
                    bw.close();
                    bw = new BufferedWriter(new FileWriter(new File(localLogPath + "/" + new Date().getTime())));
                    count = 0;
                }

                StringBuffer logLine = new StringBuffer();
                logLine.append("X").append(r.nextInt(200)).append(" ").append(new Date().getTime()).append("\n");
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            status = "NOT_RUNNING";
        }
    }

    public String getStatus() {
        return status;
    }
}
