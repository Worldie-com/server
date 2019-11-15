package org.emernet.server.setup;

import org.emernet.server.colorlib.CmdColors;

import java.io.IOException;

public class aptTask {
    public static Runtime rt = Runtime.getRuntime();

    public static void aptUpdate() {
        try {
            Process aptUpdater = rt.exec("sudo apt-get update");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void instApache(){
        try {
            Process installApache = rt.exec("sudo apt-get -y install apache2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void instUnzip(){
        try {
            Process installUnzip = rt.exec("sudo apt-get -y install unzip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
