package org.emernet.server.updater;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class checkUpdate {
    public static boolean isLatest() {

        String latestVers = "";
        String currentVers = "";
        String instVers  ="";

        try {

            URL url = new URL("https://raw.githubusercontent.com/emernet-eins/system/master/version.md");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                latestVers = line;
            }
            in.close();
            //System.out.println(latestVers);

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }


        File currVers = new File("/var/www/emernet/version.md");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(currVers));
            while ((currentVers = br.readLine()) != null)
                instVers = currentVers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(instVers);


        if (!instVers.equals(latestVers)) {
            return false;
        } else {
            return true;
        }

    }

}
