package com.example;

import java.util.*;

/*
 * ChavviCalc assignment for CSIS 26
 */
public class App 
{
    static float a = 0.000f;
    static float b = 0.000f;

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
    
    // rounds numbers when displayed
    private static String roundNumber(float x) {        
        return (String.format("%.3f", x));
        // The program returns a string, not a float, because the value
        // returned from this function is immediately used in a print 
        // statement, not a calculation.
    }

    // prints the menu
    public static void printMenu() {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();
        System.out.println("A = " + roundNumber(a) + "     B = " + roundNumber(b));
        //System.out.println(String.format("%.3f", a));
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

    // This function is used when the user wants to enter a value for a variable
    private static Boolean enterValueBoolean(Scanner scan, Character variable) {
        Boolean success = true;
        System.out.print("Please enter a value: ");
        // The use of the try-catch statement makes input validation easier.
        try {
            float numericalInput = Float.parseFloat(scan.nextLine());
            switch(variable) {
                // the use of a switch statement here makes the program more extensible.
                // For example, if we wanted to add a third variable named 'c', it 
                // wouldn't be too hard to add it into the program. (All you would
                // have to do is add a third case to the switch statement below.)
                case 'a':
                    a = numericalInput;
                    break;
                case 'b':
                    b = numericalInput;
                    break;
            }
            System.out.println("The value has successfully been changed to " + roundNumber(numericalInput));
        }
        catch(Exception e) {
            System.out.println("ERROR: You must enter a valid number");
            success = false;
        }
        return success;
    }
    // Calculator functions
    private static Boolean executeCommand(Scanner scan, Character command) {
        Boolean success = true;
        switch (command) {
            case 'a':
                enterValueBoolean(scan, 'a');
                break;
            case 'b':
                enterValueBoolean(scan, 'b');
                break;
            case '+':
                a += b;
                break;
            case '-':
                a -= b;
                break;
            case '*':
                a *= b;
                break;
            case '/':
                if (b == 0.0) {
                    System.out.println("ERROR: Division by zero is not allowed");
                    success = false;    
                }
                else {
                    a /= b;
                }
                break;
            case 'c':
                a = 0.000f;
                b = 0.000f;
                System.out.println("The variables A and B have been reset to zero.");
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
