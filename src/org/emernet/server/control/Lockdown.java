package org.emernet.server.control;

import org.emernet.server.colorlib.CmdColors;

import java.util.concurrent.TimeUnit;

public class Lockdown {
    public static void enterLockdown(){
        System.out.println("\n\n\n\n\n\n");
        System.out.println(CmdColors.CMD_RED + "Lockdown mode was activated." + CmdColors.CMD_RESET);
        System.out.println(CmdColors.CMD_RED + "This could be an emergency!" + CmdColors.CMD_RESET);
        System.out.println(CmdColors.CMD_RED + "Please turn on your radio/tv (if available) to be informed about what's happening!" + CmdColors.CMD_RESET);
        System.out.println("\n\n");
        System.out.println(CmdColors.CMD_RED + "Lockdown will check for an Internet connection every 10 Minutes." + CmdColors.CMD_RESET);
        System.out.println("\n");
        System.out.println(CmdColors.CMD_RED + "Going to sleep for 10 minutes." + CmdColors.CMD_RESET);
        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (init.isConnected()){
            System.out.println(CmdColors.CMD_GREEN + "Connection established!" + CmdColors.CMD_RESET);
            System.out.println("Restarting EMERNET Runtime...");
            Main.main(null);
        }else{
            System.out.println(CmdColors.CMD_RED + "No connection!" + CmdColors.CMD_RESET);
            System.out.println(CmdColors.CMD_RED + "Staying in Lockdown..." + CmdColors.CMD_RESET);
            enterLockdown();
        }
    }
}
