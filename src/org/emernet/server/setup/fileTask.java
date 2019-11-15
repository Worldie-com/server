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
        try {
            // Get Config File from Github
            //TODO: Change to master branch as soon as branch will be merged
            Process getConfig = rt.exec("wget https://github.com/emernet-eins/server/blob/implement-setup/emernet.conf");
            //Move Config to the right place
            Process moveConfig = rt.exec("sudo mv emernet.conf /etc/apache2/sites-enabled");
            //remove 000-default.conf
            Process removeDefault = rt.exec("sudo rm -rf /etc/apache2/sites-enabled/000-default.conf");
            //Restart apache2
            Process restartApache = rt.exec("sudo service apache2 restart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
