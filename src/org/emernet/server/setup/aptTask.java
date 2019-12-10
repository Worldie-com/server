package org.emernet.server.setup;

import dev.miit0o.clilib.lib.TextColors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aptTask {
    public static Runtime rt = Runtime.getRuntime();

    public static void aptUpdate() {
        try {
            Process aptUpdater = rt.exec("sudo apt-get update");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(aptUpdater.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(aptUpdater.getErrorStream()));

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

    public static void instApache() {
        try {
            Process installApache = rt.exec("sudo apt-get -y install apache2");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(installApache.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(installApache.getErrorStream()));

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

    public static void instZip(){
        try {
            Process installZip = rt.exec("sudo apt-get -y install unzip");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(installZip.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(installZip.getErrorStream()));

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


    public static void instUnzip() {
        try {
            Process installUnzip = rt.exec("sudo apt-get -y install unzip");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(installUnzip.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(installUnzip.getErrorStream()));

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

    public static void instScreen(){
        try {
            Process installScreen = rt.exec("apt-get install screen");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(installScreen.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(installScreen.getErrorStream()));

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

}
