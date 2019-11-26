package org.emernet.server.updater;

import org.emernet.server.control.Downloader;

public class UpdateHandler {
    public static void manageUpdate(){

        //Download new version
        System.out.println("Downloading Update...");
        Downloader.downloadSystem();

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

        // Create new SystemInfo
        System.out.println("Creating Systeminfo...");
        fileTask.createSysInfo();

        // Create .done File
        System.out.println("Done!");
        fileTask.createDone();

    }

    //Outline
    // 1. Download Update - done
    // 2. Backup current - done
    // 3. delete old - done
    // 4. move in new

}
