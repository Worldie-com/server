package org.emernet.server.setup;

import org.emernet.server.colorlib.CmdColors;

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
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

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
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

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
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
