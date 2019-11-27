package org.emernet.server.control;

import org.emernet.server.colorlib.CmdColors;

public class Connection {
    public static void checkConnection(){
        if(init.isConnected()){
            System.out.println("Connection established.");
        }else{
            System.out.println(CmdColors.CMD_RED + "Entering Lockdown mode..." + CmdColors.CMD_RESET);
            Lockdown.enterLockdown();
        }
    }
}
