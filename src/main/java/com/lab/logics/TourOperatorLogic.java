package com.lab.logics;

import com.lab.console.MainConsoleIO;

import java.util.Scanner;

public class TourOperatorLogic implements Logic {

    public void use(){
    MainConsoleIO mainConsoleIO = new MainConsoleIO();
    boolean flag = true;
    label:
            while (flag){
        var scanner = new Scanner(System.in);
        mainConsoleIO.menu();
        var n = scanner.next();
        switch (n) {
            case "1":
                mainConsoleIO.spb();
                if (!mainConsoleIO.tourDetail()) continue ;
                flag = mainConsoleIO.orderProcedure();
                break;
            case "2":
                mainConsoleIO.omsk();
                break label;
            case "0":
                mainConsoleIO.admin();
                break;
            case "exit":
                break label;
            }

        }

    }
}
