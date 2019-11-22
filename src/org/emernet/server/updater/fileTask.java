package org.emernet.server.updater;

import org.emernet.server.control.Downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileTask {

    public static Runtime rt = Runtime.getRuntime();

    public static void getUpdate(){

    }

    public static void backupSys(){
        try {
            Process zipSys = rt.exec("zip -r /var/www/backup.zip /var/www/emernet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOld(){
        try {
            Process delSys = rt.exec("sudo rm -rf /var/www/emernet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzip() {
        String latestVers = Downloader.versionNbr;

        try {

            Process moveConfig = null;

            moveConfig = rt.exec("unzip " + latestVers + ".zip -d /var/www/");


            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(moveConfig.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(moveConfig.getErrorStream()));

            // Read the output from the command
            System.out.println("Command Log:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println("Errors:\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveSystem() {
        try {
            Thread.sleep(2000);

            Process mvSys = rt.exec("mv /var/www/system-" + Downloader.versionNbr + "/ /var/www/emernet");
            // mv -v system-testing-1/* /var/www/emernet

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(mvSys.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(mvSys.getErrorStream()));

            // Read the output from the command
            System.out.println("Command Log:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println("Errors:\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void createDone(){
        try {
            Process crDone = rt.exec("touch /var/www/emernet/.done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
