/*
 * Leap Year Checker

Problem Statement:
Write a program to check if a given year is a leap year.

    A year is a leap year if:
        It is divisible by 4, and
        It is not divisible by 100 unless it is also divisible by 400.
        Use conditional statements to check the conditions.
 */

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                System.out.println("Is a leap year");
            } else {
                System.out.println("Not a leap year");
            }
        } else {
            System.out.println("Not a leap year");
        }

        scanner.close(); // Close scanner to prevent resource leaks
    }
}
