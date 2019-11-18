package org.emernet.server.setup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileTask {

    public static Runtime rt = Runtime.getRuntime();

    public static void mkdir(){
        try {
            Process createDir = rt.exec("sudo mkdir /var/www/emernet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getConfig(){
        try {
            // Get Config File from Github
            //TODO: Change to master branch as soon as branch will be merged
            Process getConfig = rt.exec("wget https://raw.githubusercontent.com/emernet-eins/server/implement-setup/emernet.conf");
            Thread.sleep(2000);
            //Move Config to the right place
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
            Process removeDefault = rt.exec("sudo rm -rf /etc/apache2/sites-enabled/000-default.conf");
            //Restart apache2
            Process restartApache = rt.exec("sudo service apache2 restart");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
