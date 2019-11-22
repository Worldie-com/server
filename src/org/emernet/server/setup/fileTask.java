package org.emernet.server.setup;

import org.emernet.server.control.Downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class fileTask {

    public static Runtime rt = Runtime.getRuntime();

    public static void getConfig() {
        try {
            // Get Config File from Github
            System.out.println("Downloading Config...");
            Process getConfig = rt.exec("wget https://raw.githubusercontent.com/emernet-eins/server/master/emernet.conf");
            Thread.sleep(2000);
            //Move Config to the right place
            System.out.println("Moving config...");
            Process moveConfig = rt.exec("sudo mv ./emernet.conf /etc/apache2/sites-enabled/");

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

            //remove 000-default.conf
            System.out.println("Removing default config...");
            Process removeDefault = rt.exec("sudo rm -rf /etc/apache2/sites-enabled/000-default.conf");
            //Restart apache2
            System.out.println("Restarting apache");
            Process restartApache = rt.exec("sudo service apache2 restart");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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


    public static void fixPerms() {
        try {
            Process fixPermissions = rt.exec("chown -R www-data:www-data /var/www/emernet/");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(fixPermissions.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(fixPermissions.getErrorStream()));

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

    public static void cleanup(){
        try {
            Process cleaingService = rt.exec("rm " + Downloader.versionNbr +".zip");
        } catch (IOException e) {
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
