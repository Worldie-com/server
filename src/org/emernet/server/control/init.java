package org.emernet.server.control;

import com.sun.deploy.util.SystemUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class init {

    public static boolean isLinux() {
        if (System.getProperty("os.name").equals("Linux")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSetup() {
        File doneFile = new File("/var/www/emernet/.done");
        if (doneFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isConnected(){
        String status = "";

        try {

            URL url = new URL("http://rustige.me/check.txt");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                status = line;
            }
            in.close();
            //System.out.println(latestVers);

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        if (status.equals("online")){
            status = "";
            return true;
        }else{
            return false;
        }

    }
}
