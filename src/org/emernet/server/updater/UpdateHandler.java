package org.emernet.server.updater;

import org.emernet.server.control.Downloader;
import org.emernet.server.colorlib.CmdColors;
public class UpdateHandler {
    public static void manageUpdate(){

        //Download new version
        System.out.println("Downloading Update...");
        Downloader.downloadSystem();
        System.out.println(CmdColors.CMD_GREEN + "This is NOT an error. Everything is fine." + CmdColors.CMD_RESET);

        // Backup the current System
        System.out.println("Backing up current System...");
        fileTask.backupSys();

        // Delete old System
        System.out.println("Deleting old System...");
        fileTask.deleteOld();

        // Unzip new System
        System.out.println("Unzipping new System...");
        fileTask.unzip();

        // Move new System
        System.out.println("Moving System to /var/www/emernet...");
        fileTask.moveSystem();

        // Copy B-Deployer.md
        fileTask.copyDeployer();

        // Create new SystemInfo
        System.out.println("Creating Systeminfo...");
        fileTask.createSysInfo();

        // Create .done File
        System.out.println("Done!");
        fileTask.createDone();

    }

}
