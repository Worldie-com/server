package org.emernet.server.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
    public static Runtime rt = Runtime.getRuntime();

    public static void downloadSystem(){
        //get Latest Version Tag from GitHub
        String latestVers = "";

        try {

            URL url = new URL("https://github.com/emernet-eins/system/blob/master/version.md");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                latestVers = line;
            }
            in.close();

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
