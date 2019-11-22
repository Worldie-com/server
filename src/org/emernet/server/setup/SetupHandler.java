package org.emernet.server.setup;

import org.emernet.server.colorlib.CmdColors;
import org.emernet.server.control.Downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetupHandler {
    public static Runtime rt = Runtime.getRuntime();

    public static void handler() {
        //Check for root privileges
        System.out.println("Checking for root privileges...");
        checkRoot();

        //Check for Package Updates
        System.out.println("Refreshing Package List...");
        aptTask.aptUpdate();

        //Install Apache2
        System.out.println("Installing Apache2...");
        aptTask.instApache();

        //Install Unzip
        System.out.println("Installing unzip...");
        aptTask.instUnzip();

        //Install Zip
        System.out.println("Installing zip...");
        aptTask.instZip();

        // Install Screen
        System.out.println("Installing Screen...");
        aptTask.instScreen();

        //get ApacheConfig
        fileTask.getConfig();

        //Download System
        System.out.println("Downloading latest System...");
        Downloader.downloadSystem();

        //Unzip System
        System.out.println("Unzipping System...");
        fileTask.unzip();

        //move System
        System.out.println("Moving System to /var/www/emernet...");
        fileTask.moveSystem();

        //Fix Permissions
        System.out.println("Fixing permissions...");
        fileTask.fixPerms();

        // Cleanup
        System.out.println("Cleaning up...");
        fileTask.cleanup();

        // Create Done File
        System.out.println("Done!");
        fileTask.createDone();
    }

    public static void checkRoot() {
        if (isRoot()) {
            System.out.println(CmdColors.CMD_GREEN + "Root is granted!" + CmdColors.CMD_RESET);
        } else {
            System.out.println(CmdColors.CMD_RED + "No root available!" + CmdColors.CMD_RESET);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(CmdColors.CMD_RED + "Please login as root using su, or start the process again with sudo!" + CmdColors.CMD_RESET);
            System.exit(1);

        }
    }

    public static boolean isRoot() {
        String username = "";
        StringBuilder str = new StringBuilder();

        try {
            Process whoami = rt.exec("whoami");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(whoami.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(whoami.getErrorStream()));

            // Read the output from the command
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                str.append(s);
            }
            username = str.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (username.equals("root")){
            return true;
        }else{
            return false;
        }

    }


    // Outline
    // 1. Check for root
    // 2. apt-update - done
    // 3. install apache2 - done
    // 4. install unzip - done
    // 5. mkdir /var/www/emernet - done
    // 6. download/create Apache .conf for EMERNET - done
    // 7. Download EMERNET System - done
    // 8. unzip and move - done
    // 9. Fix permissions - done
    // 10. Cleanup (remove .zip)


}
