package com.adX.adserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdServer {

    private String input;
    private String logPath;
    private String logMonitorHost;
    private int logMonitorPort;
    private LogGenerator logGenerator;
    private Thread loggerThread;

    public void printMenu() throws IOException {
        System.out.println("-----------------------------");
        System.out.println("1. Start");
        System.out.println("2. Stop");
        System.out.println("3. Exit");
        System.out.println("-----------------------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

    }

    public void startUI() throws IOException, InterruptedException {
        printMenu();

        while (true) {
            if (input.equals("1")) {

                start();
                printMenu();
            } else if (input.equals("2")) {
                stop();
                printMenu();
            } else if (input.equals("3")) {
                exit();
            }
        }
    }

    public void start() {
        if (logGenerator.getStatus().equals("NOT_RUNNING")) {
            loggerThread = new Thread(logGenerator);
            loggerThread.start();
        } else {
            System.out.println("Already started..");
        }
    }

    public void stop() throws InterruptedException {
        if (logGenerator.getStatus().equals("RUNNING")) {
            System.out.println("Stopping");
            logGenerator.setRunning(false);
            while (logGenerator.getStatus().equals("RUNNING")) {
                System.out.print(".");
                Thread.sleep(10);
            }
        } else {
            System.out.println("Not running..");
        }

    }

    public void exit() throws InterruptedException {
        if (logGenerator.getStatus().equals("RUNNING")) {
            stop();
        }
        System.exit(0);
    }

    public AdServer(String logPath, String logMonitorHost, int logMonitorPort) {
        this.logPath = logPath;
        this.logMonitorHost = logMonitorHost;
        this.logMonitorPort = logMonitorPort;
        logGenerator = new LogGenerator(logPath);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        if (args.length != 3) {
//            System.out.println("Usage Adserver logpath monitor host port");
//        }
//        new AdServer(args[0],args[1],Integer.parseInt(args[2])).startUI();
        new AdServer("/home/sajith/sandbox/node1", "", 11).startUI();
    }
}
