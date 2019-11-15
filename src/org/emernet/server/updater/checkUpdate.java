package org.emernet.server.updater;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class checkUpdate {
    public static boolean isLatest() {

        String latestVers = "";
        String currentVers = "";

        try {

            URL url = new URL("text file Link");

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


        File currVers = new File("/var/www/emernet/.currVers");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(currVers));
            while ((currentVers = br.readLine()) != null)
                System.out.println(currentVers);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert currentVers != null;
        if (!currentVers.equals(latestVers)){
            return false;
        }else {
            return true;
        }

    }

}
