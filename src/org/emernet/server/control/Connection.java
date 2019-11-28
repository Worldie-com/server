package org.emernet.server.control;

import org.emernet.server.colorlib.CmdColors;

public class Connection {
    public static void checkConnection(){
        System.out.println("\nChecking connection...");
        if(init.isConnected()){
            System.out.println("Connection established.\n");
        }else{
            System.out.println(CmdColors.CMD_RED + "Entering Lockdown mode..." + CmdColors.CMD_RESET);
            Lockdown.enterLockdown();
        }
    }
}
