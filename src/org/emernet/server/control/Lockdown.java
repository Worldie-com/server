package org.emernet.server.control;

import dev.miit0o.clilib.lib.TextColors;
import java.util.concurrent.TimeUnit;

public class Lockdown {
    public static void enterLockdown(){
        System.out.println("\n\n\n\n\n\n");
        System.out.println(TextColors.red + "Lockdown mode was activated." + TextColors.reset);
        System.out.println(TextColors.red + "This could be an emergency!" + TextColors.reset);
        System.out.println(TextColors.red + "Please turn on your radio/tv (if available) to be informed about what's happening!" + TextColors.reset);
        System.out.println("\n\n");
        System.out.println(TextColors.red + "Lockdown will check for an Internet connection every 10 Minutes." + TextColors.reset);
        System.out.println("\n");
        System.out.println(TextColors.red + "Going to sleep for 10 minutes." + TextColors.reset);
        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (init.isConnected()){
            System.out.println(TextColors.green + "Connection established!" + TextColors.reset);
            System.out.println("Restarting EMERNET Runtime...");
            Main.main(null);
        }else{
            System.out.println(TextColors.red + "No connection!" + TextColors.reset);
            System.out.println(TextColors.red + "Staying in Lockdown..." + TextColors.reset);
            enterLockdown();
        }
    }
}
