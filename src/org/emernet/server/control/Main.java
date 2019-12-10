package org.emernet.server.control;

import dev.miit0o.clilib.lib.TextColors;
import dev.miit0o.clilib.lib.TextStyles;
import org.emernet.server.updater.UpdateHandler;
import org.emernet.server.updater.checkUpdate;
import org.emernet.server.setup.SetupHandler;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println(TextStyles.bold + "Welcome to EMERNET-E.I.N.S server!" + TextStyles.reset);

        //Check if OS is Linux
        System.out.println(TextStyles.italic + "Checking for Linux OS..." + TextStyles.reset);
        init.isLinux();
        if (init.isLinux()) {
            System.out.println(TextColors.green + "OS is Linux! Ready to go!" + TextColors.reset);
        } else {
            System.out.println(TextColors.red + "This application is only working with Linux." + TextColors.reset);
            System.exit(1);
        }

        //Checking if E.I.N.S is setup
        System.out.println(TextStyles.bold + "Checking if a version is installed..." + TextColors.reset);
        init.isSetup();
        if (init.isSetup()) {
            System.out.println(TextColors.cyan + "EMERNET E.I.N.S is already Setup!" + TextColors.reset);

            // Check internet connection
            Connection.checkConnection();

            //Launch Update Checker
            System.out.println(TextStyles.bold + "Checking for updates..." + TextColors.reset);
            checkUpdate.isLatest();
            if (checkUpdate.isLatest()) {
                System.out.println(TextStyles.italic + "EMERNET E.I.N.S is already on the latest Version." + TextColors.reset);
                System.out.println("Going to sleep for 24 hours.");
                try {
                    int count = 0;
                    while (count < 48){
                        count++;
                        Connection.checkConnection();
                        Thread.sleep(TimeUnit.MINUTES.toMillis(30));
                    }
                    //Restart Server to check everything again.
                    System.out.println(TextStyles.italic + "Restarting EMERNET E.I.N.S server..." + TextColors.reset);
                    main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
            {
                UpdateHandler.manageUpdate();
            }
        } else {
            System.out.println(TextColors.red + "EMERNET E.I.N.S seems not to be setup!" + TextColors.reset);
            //Launch Setup
            System.out.println("Launching setup...");
            SetupHandler.handler();
        }
    }
}
