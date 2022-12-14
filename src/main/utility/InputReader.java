package main.utility;

import java.util.Scanner;

public class InputReader {
    private static Scanner scanner = new Scanner(System.in);

    public static int readNumber(String prompt, int min, int max) {
        int inputNumber;
        System.out.print(prompt);
        while (true) {
            try {
                inputNumber = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Please only choose between " + min + " and " + max + ".");
            }
        }
        return inputNumber;
    }
    public static int readNumber(String prompt) {
        int inputNumber;
        System.out.print(prompt);
        while (true) {
            try {
                inputNumber = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Please only input a valid number.");
                System.out.println(prompt);
            }
        }
        return inputNumber;
    }
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
