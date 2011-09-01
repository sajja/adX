package com.adX.logmonitor;

import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class LogMonitor implements Runnable
{
    private String[] monitorDirs = new String[]{"/home/sajith/sandbox/node1"};

    public void Monitor() {

    }

    public static void main( String[] args )
    {

    }

    public void run() {
        File timeStampFile;
        try {
        while (true) {
            for (int i = 0; i < monitorDirs.length; i++) {
                String monitorDir = monitorDirs[i];
                timeStampFile = new File(monitorDir + "/ts/" + "timestamp");
                BufferedReader br = new BufferedReader(new FileReader(timeStampFile));
                String timestamp = br.readLine();
                br.close();

                File[] files =  new File(monitorDir).listFiles();
                List<File> interestedFiles = new ArrayList<File>(files.length);

                if (timestamp == null) {
                    interestedFiles = Arrays.asList(files);
                } else {
                    long ts = Long.parseLong(timestamp);
                    for (int j = 0; j < files.length; j++) {
                        File file = files[j];
                        if (file.lastModified() > ts) {
                            interestedFiles.add(file);
                        }
                    }
                }

            }



        }
        } catch (FileNotFoundException e) {
                         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                     } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
