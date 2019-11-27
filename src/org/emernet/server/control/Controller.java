package org.emernet.server.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public static Runtime rt = Runtime.getRuntime();

    public static void relaunch(){
        try {
            //Create new Screen session
            System.out.println("Relaunching runtime in screen 'emernet'");
            Process createScreen = rt.exec("sh ./relaunch.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
