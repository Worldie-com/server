package org.emernet.server.updater;

import java.io.IOException;

public class fileTask {

    public static Runtime rt = Runtime.getRuntime();

    public static void getUpdate(){

    }

    public static void backupSys(){
        try {
            Process zipSys = rt.exec("zip -r /var/www/backup.zip /var/www/emernet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOld(){
        try {
            Process delSys = rt.exec("sudo rm -rf /var/www/emernet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
