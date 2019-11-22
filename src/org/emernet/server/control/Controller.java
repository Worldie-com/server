package org.emernet.server.control;

import java.io.IOException;

public class Controller {

    public static Runtime rt = Runtime.getRuntime();

    public static void relaunch(){
        try {
            Process relaunchRuntime = rt.exec("screen -S emernet java -jar emernet*");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
