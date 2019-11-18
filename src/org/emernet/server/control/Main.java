package org.emernet.server.control;

import org.emernet.server.colorlib.CmdColors;
import org.emernet.server.updater.UpdateHandler;
import org.emernet.server.updater.checkUpdate;
import org.emernet.server.setup.SetupHandler;
import org.emernet.server.updater.doUpdate;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to EMERNET-E.I.N.S server!");

        //Check if OS is Linux
        System.out.println("Checking for Linux OS...");
        init.isLinux();
        if (init.isLinux()) {
            System.out.println("OS is Linux! Ready to go!");
        } else {
            System.out.println(CmdColors.CMD_RED + "This application is only working with Linux." + CmdColors.CMD_RESET);
            System.exit(1);
        }

        //Checking if E.I.N.S is setup
        System.out.println("Checking if a version is installed...");
        init.isSetup();
        if (init.isSetup()) {
            System.out.println(CmdColors.CMD_RED + "EMERNET E.I.N.S is already Setup!" + CmdColors.CMD_RESET);
            //Launch Update Checker
            System.out.println("Checking for updates...");
            checkUpdate.isLatest();
            if (checkUpdate.isLatest()) {
                System.out.println("EMERNET E.I.N.S is already on the latest Version.");
                System.out.println("Going to sleep for 24 hours.");
                try {
                    Thread.sleep(TimeUnit.HOURS.toMillis(24));
                    //Restart Server to check everything again.
                    System.out.println("Restarting EMERNET E.I.N.S server...");
                    main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
            {
                UpdateHandler.manageUpdate();
            }
        } else {
            System.out.println("EMERNET E.I.N.S seems not to be setup!");
            //Launch Setup
            System.out.println("Launching setup...");
            SetupHandler.handler();
        }
    }
}
