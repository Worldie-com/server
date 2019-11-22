package org.emernet.server.updater;

import org.emernet.server.control.Downloader;

public class UpdateHandler {
    public static void manageUpdate(){

        //Download new version
        Downloader.downloadSystem();

        // Backup the current System
        fileTask.backupSys();

        // Delete old System
        fileTask.deleteOld();

        // Unzip new System
        fileTask.unzip();

        // Move new System
        fileTask.moveSystem();

        // Create .done File
        fileTask.createDone();

    }

    //Outline
    // 1. Download Update - done
    // 2. Backup current - done
    // 3. delete old - done
    // 4. move in new

}
