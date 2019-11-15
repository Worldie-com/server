package org.emernet.server.setup;

import java.io.IOException;

public class fileTask {

    public static Runtime rt = Runtime.getRuntime();

    public static void mkdir(){
        try {
            Process createDir = rt.exec("sudo mkdir /var/www/emernet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getConfig(){

    }

}
