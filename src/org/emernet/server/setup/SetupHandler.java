package org.emernet.server.setup;

import org.emernet.server.colorlib.CmdColors;

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
    // 2. apt-update
    // 3. install apache2
    // 4. install unzip
    // 5. mkdir /var/www/emernet
    // 6. download/create Apache .conf for EMERNET
    // 7. Download EMERNET System
    // 8. unzip
    // 9. Cleanup (remove .zip)


}
