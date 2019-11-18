package org.emernet.server.setup;

import org.emernet.server.colorlib.CmdColors;
import org.emernet.server.control.Downloader;

public class SetupHandler {
    public static void handler(){
        //Check for root privileges
        checkRoot();

        //Check for Package Updates
        aptTask.aptUpdate();
        //Install Apache2
        aptTask.instApache();
        //Install Unzip
        aptTask.instUnzip();

        //get ApacheConfig
        fileTask.getConfig();

        //Download System
        Downloader.downloadSystem();

        //Unzip System
        fileTask.unzip();

        //move System
        fileTask.moveSystem();

        //Fix Permissions
        fileTask.fixPerms();

        // Cleanup
        fileTask.cleanup();
    }

    public static void checkRoot(){
        if (isRoot()){
            System.out.println(CmdColors.CMD_GREEN + "Root is granted!" + CmdColors.CMD_RESET);
        }else{
            System.out.println(CmdColors.CMD_RED + "No root available! Continuing anyway..." + CmdColors.CMD_RESET);
        }
    }

    public static boolean isRoot(){
        return true;
        // TODO: Will be added later on
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
