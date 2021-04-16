package com.rupp.fe;

import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);

    void drawLine(String cmd, DrawLine drawLine) {

        drawLine.dda(1 - 10, 1 - 10, 8 - 10, 5 - 10);
        drawLine.blda(1, 1, 8, 5);


    }

}
