package com.company;

import java.util.Scanner;

/**
 * Created by rteach on 2/9/2017.
 */
public class Validate {
    static Scanner scnr = new Scanner(System.in);


    public static String getString(String prompt)
    {
        System.out.println(prompt);
        String s = scnr.next();  // read user entry
        scnr.nextLine();  // discard any other data entered on the line
        return s;
    }

    public static String validateYesOrNo(String prompt)
    {
        System.out.println(prompt);
        String input = scnr.next();
        while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            input = scnr.nextLine();
            System.out.println("Input error");
            System.out.println(prompt);
        }
        return input;
    }

    public static int validateInt(String prompt) {

        System.out.println(prompt);
        while (!scnr.hasNextInt()) {
            System.out.println("Input error");
            System.out.println(prompt);
            scnr.nextLine();
        }
        return scnr.nextInt();
    }

    public static int validateInt(String prompt, int min, int max) {
        int num = validateInt(prompt);

        while (!checkRange(num, min, max)) {
            System.out.println("Input error");
            scnr.nextLine();
            num = validateInt(prompt);
        }
        scnr.nextLine();
        return num;
    }

    public static double validateDouble(String prompt) {

        System.out.println(prompt);
        while (!scnr.hasNextDouble()) {
            System.out.println("Input error");
            System.out.println(prompt);
            scnr.nextLine();

        }
        return scnr.nextDouble();
    }


    public static double validateDouble(String prompt, double  min, double max) {
        double num = validateDouble(prompt);

        while (!checkRange(num, min, max)) {
            System.out.println("Input error");
            scnr.nextLine();
            num = validateDouble(prompt);
        }
        scnr.nextLine();
        return num;
    }


    public static boolean checkRange(int num, int min, int max) {

        if (num < min || num > max) {
            return false;
        }
        return true;
    }

    public static boolean checkRange(double num, double min, double max) {

        if (num < min || num > max) {
            return false;
        }
        return true;
    }




}
