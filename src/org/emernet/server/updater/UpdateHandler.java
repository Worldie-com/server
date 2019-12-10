package org.emernet.server.updater;

import dev.miit0o.clilib.lib.TextColors;
import dev.miit0o.clilib.lib.TextStyles;
import org.emernet.server.control.Downloader;
public class UpdateHandler {
    public static void manageUpdate(){

        //Download new version
        System.out.println(TextStyles.bold + "Downloading Update..." + TextStyles.reset);
        Downloader.downloadSystem();
        System.out.println(TextColors.green + "This is NOT an error. Everything is fine." + TextColors.reset);

        // Backup the current System
        System.out.println(TextStyles.bold + "Backing up current System..." + TextStyles.reset);
        fileTask.backupSys();

        // Delete old System
        System.out.println(TextStyles.bold + "Deleting old System..." + TextStyles.reset);
        fileTask.deleteOld();

        // Unzip new System
        System.out.println(TextStyles.bold + "Unzipping new System..." + TextStyles.reset);
        fileTask.unzip();

        // Move new System
        System.out.println(TextStyles.bold + "Moving System to /var/www/emernet..." + TextStyles.reset);
        fileTask.moveSystem();

        // Copy B-Deployer.md
        fileTask.copyDeployer();

        // Create new SystemInfo
        System.out.println(TextStyles.bold + "Creating Systeminfo..." + TextStyles.reset);
        fileTask.createSysInfo();

        // Create .done File
        System.out.println(TextStyles.bold + "Done!" + TextStyles.reset);
        fileTask.createDone();

    }

}
