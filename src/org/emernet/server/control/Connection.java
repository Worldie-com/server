package org.emernet.server.control;

import org.emernet.server.colorlib.CmdColors;
import dev.miit0o.clilib.lib.TextColors;

public class Connection {
    public static void checkConnection(){
        System.out.println("\nChecking connection...");
        if(init.isConnected()){
            System.out.println("Connection established.\n");
        }else{
            System.out.println(TextColors.red + "Entering Lockdown mode..." + TextColors.reset);
            Lockdown.enterLockdown();
        }
    }
}
