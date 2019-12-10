package org.emernet.server.setup;

import org.emernet.server.control.Downloader;
import org.emernet.server.control.Controller;
import dev.miit0o.clilib.lib.TextColors;
import dev.miit0o.clilib.lib.TextStyles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetupHandler {
    public static Runtime rt = Runtime.getRuntime();

    public static void handler() {
        //Check for root privileges
        System.out.println(TextStyles.bold + "Checking for root privileges..." + TextColors.reset);
        checkRoot();

        //Check for Package Updates
        System.out.println(TextStyles.bold + "Refreshing Package List..." + TextColors.reset);
        aptTask.aptUpdate();

        //Install Apache2
        System.out.println(TextStyles.bold + "Installing Apache2..." + TextColors.reset);
        aptTask.instApache();

        //Install Unzip
        System.out.println(TextStyles.bold + "Installing unzip..." + TextColors.reset);
        aptTask.instUnzip();

        //Install Zip
        System.out.println(TextStyles.bold + "Installing zip..." + TextColors.reset);
        aptTask.instZip();

        // Install Screen
        System.out.println(TextStyles.bold + "Installing Screen..." + TextColors.reset);
        aptTask.instScreen();

        //get ApacheConfig
        fileTask.getConfig();

        //Download System
        System.out.println(TextStyles.bold + "Downloading latest System..." + TextColors.reset);
        Downloader.downloadSystem();
        System.out.println(TextColors.green + "This is NOT an error. Everything is fine." + TextColors.reset);

        //Unzip System
        System.out.println(TextStyles.bold + "Unzipping System..." + TextColors.reset);
        fileTask.unzip();

        //move System
        System.out.println(TextStyles.bold + "Moving System to /var/www/emernet..." + TextColors.reset);
        fileTask.moveSystem();

        //Download relaunch.sh
        System.out.println(TextStyles.bold + "Downloading relaunch.sh..." + TextColors.reset);
        fileTask.downloadShell();

        //Fix Permissions
        System.out.println(TextStyles.bold + "Fixing permissions..." + TextColors.reset);
        fileTask.fixPerms();

        // Cleanup
        System.out.println(TextStyles.bold + "Cleaning up..." + TextColors.reset);
        fileTask.cleanup();

        // Deployed by Question
        // Generate deployer.md
        fileTask.createDeployer();
        // Generate b-deployer.md
        fileTask.createBDeployer();


        // Create Systeminfo
        System.out.println(TextStyles.bold + "Creating System-Info..." + TextColors.reset);
        fileTask.createSysInfo();

        // Create Done File
        System.out.println(TextStyles.bold + "Done!" + TextColors.reset);
        fileTask.createDone();

        // Relaunch Runtime in Screen
        Controller.relaunch();
        System.out.println(TextStyles.underline + "Use 'screen -r emernet' to view runtime.\n\n\n" + TextColors.reset);
    }

    public static void checkRoot() {
        if (isRoot()) {
            System.out.println(TextColors.green + "Root is granted!" + TextColors.reset);
        } else {
            System.out.println(TextColors.red + "No root available!" + TextColors.reset);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(TextColors.red + "Please login as root using su, or start the process again with sudo!" + TextColors.reset);
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
}
