package com.example;

import java.util.*;

/*
 * ChavviCalc assignment for CSIS 26
 */
public class App 
{
    static double a = 0.000;
    static double b = 0.000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character command = '_';

        // loop until user quits
        while (command != 'q') {
        printMenu();
        System.out.print("Enter a command: ");
        command = menuGetCommand(scan);

        executeCommand(scan, command);
        }

        scan.close();
    }

    //
    // menu functions
    //
    private static void printMenuLine() {
        System.out.println(
        "----------------------------------------------------------"
        );
    }

    private static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // prints the menu
    public static void printMenu() {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();

        printMenuCommand('a', "Enter a value for A");
        printMenuCommand('b', "Enter a value for B");
        printMenuCommand('+', "Add");
        printMenuCommand('-', "Subtract");
        printMenuCommand('*', "Multiply");
        printMenuCommand('/', "Divide");
        printMenuCommand('c', "Clear");
        printMenuCommand('q', "Quit");


        printMenuLine();
    }

    // get first character from input
    private static Character menuGetCommand(Scanner scan) {
        Character command = '_';

        String rawInput = scan.nextLine();

        if (rawInput.length() > 0) {
        rawInput = rawInput.toLowerCase();
        command = rawInput.charAt(0);
        }

        return command;
    }

    private static Boolean enterValueBoolean(Scanner scan, Character variable) {
        Boolean success = true;
        System.out.print("Please enter a value: ");
        String rawInput = scan.nextLine();
        try {
            switch(variable) {
                // the use of a switch statement makes the program more extensible.
                // For example, if we wanted to add a third variable named 'c', it 
                // wouldn't be too hard to add it into the program.
                case 'a':
                    a = Double.parseDouble(rawInput);
                case 'b':
                    b = Double.parseDouble(rawInput);
            }
            System.out.println("The value has successfully been changed to " + a);
            // todo; FIX THE ABOVE BUG BEFORE SUBMITTING
        }
        catch(Exception e) {
            System.out.println("ERROR: You must enter a valid number");
            success = false;
        }
        return success;
    }
    // calculator functions
    private static Boolean executeCommand(Scanner scan, Character command) {
        Boolean success = true;
        System.out.println("Debug: " + command);

        switch (command) {
            case 'a':
                enterValueBoolean(scan, 'a');
            case 'b':
                enterValueBoolean(scan, 'b');
            case '+':
                System.out.println("The sum of A and B is: " + (a+b));
                break;
            case 'q':
                System.out.println("Thank you for using Chavvi Calc");
                break;
            default:
                System.out.println("ERROR: Unknown commmand");
                success = false;
        }

        return success;
    }

}
