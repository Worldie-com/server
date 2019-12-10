package org.emernet.server.control;

import dev.miit0o.clilib.lib.TextColors;
import java.util.Scanner;

public class Deployer {

    public static String askDeployer(){
        System.out.println(TextColors.cyan + "Who is this instance deployed by?" + TextColors.reset);
        System.out.println(TextColors.cyan + "If you don't want to enter a name, just press enter." + TextColors.reset);
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();
        if (input.equals("")){
            return "EMERNET-E.I.N.S";
        }else{
            return input;
        }
    }
}
