package org.emernet.server.updater;

import dev.miit0o.clilib.lib.TextColors;
import org.emernet.server.control.Downloader;

import java.io.*;

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
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println(TextColors.red);
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println(TextColors.reset);
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
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println(TextColors.red);
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println(TextColors.reset);
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

    public static void createSysInfo(){
        File sysInfo = new File("/var/www/emernet/systeminfo.md");

        // Get System Information
        String SystemInfo = System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ")";

        try {
            sysInfo.createNewFile();

            BufferedWriter writeInfo = new BufferedWriter(new FileWriter(sysInfo));
            writeInfo.write(SystemInfo);
            writeInfo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyDeployer(){
        System.out.println("Copying b-deployer.md...");
        try {
            Process copyDeployer = rt.exec("cp /var/www/b-deployer.md /var/www/emernet/deployer.md");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
