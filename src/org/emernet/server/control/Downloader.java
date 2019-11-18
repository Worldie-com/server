package org.emernet.server.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
    public static Runtime rt = Runtime.getRuntime();
    public static String versionNbr= "";

    public static void downloadSystem(){
        //get Latest Version Tag from GitHub
        String latestVers = "";

        try {

            URL url = new URL("https://raw.githubusercontent.com/emernet-eins/system/master/version.md");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                latestVers = line;
            }
            in.close();
            versionNbr = latestVers;

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        //What a link looks like: https://github.com/emernet-eins/system/archive/testing-1.zip
        //Building link:
        String versDL = "https://github.com/emernet-eins/system/archive/"+ latestVers +".zip";

        //Download latest Version from releases
        try {
            Process dlVers = rt.exec("wget " + versDL);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(dlVers.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(dlVers.getErrorStream()));

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
}
