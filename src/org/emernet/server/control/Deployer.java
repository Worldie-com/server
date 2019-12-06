package org.emernet.server.control;

import org.emernet.server.colorlib.CmdColors;
import java.util.Scanner;

public class Deployer {

    public static String askDeployer(){
        System.out.println(CmdColors.CMD_CYAN + "Who is this instance deployed by?" + CmdColors.CMD_RESET);
        System.out.println(CmdColors.CMD_CYAN + "If you don't want to enter a name, just press enter." + CmdColors.CMD_RESET);
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();
        if (input.equals("")){
            return "EMERNET-E.I.N.S";
        }else{
            return input;
        }
    }
}
