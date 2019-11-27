package org.emernet.server.control;

import com.sun.deploy.util.SystemUtils;

import java.io.File;

public class init {

    public static boolean isLinux() {
        if (System.getProperty("os.name").equals("Linux")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSetup() {
        File doneFile = new File("/var/www/emernet/.done");
        if (doneFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkConnection(){

    }
}
