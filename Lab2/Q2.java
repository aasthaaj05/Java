/*Write a program that calculates and displays the grade for n students based on their marks in five subjects.

    Input: Student name, marks for 5 subjects.
    Calculate the total and average marks.
    Use conditional statements to assign grades:
        A for average >= 90
        B for average >= 75 and < 90
        C for average >= 50 and < 75
        F for average < 50

Store the data in arrays and display the results. */

import java.util.Scanner;

class Student {
    String name;
    int subject1, subject2, subject3, subject4, subject5;

    public Student(String name, int subject1, int subject2, int subject3, int subject4, int subject5) {
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
    }

    int total() {
        return subject1 + subject2 + subject3 + subject4 + subject5;
    }

    float average() {
        return (float) (subject1 + subject2 + subject3 + subject4 + subject5) / 5;
    }

    char grade() {
        float avg = average();
        if (avg >= 90) {
            return 'A';
        } else if (avg >= 75) {
            return 'B';
        } else if (avg >= 50) {
            return 'C';
        } else {
            return 'D';
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Marks for Subject 1: ");
            int subject1 = scanner.nextInt();
            System.out.print("Marks for Subject 2: ");
            int subject2 = scanner.nextInt();
            System.out.print("Marks for Subject 3: ");
            int subject3 = scanner.nextInt();
            System.out.print("Marks for Subject 4: ");
            int subject4 = scanner.nextInt();
            System.out.print("Marks for Subject 5: ");
            int subject5 = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            students[i] = new Student(name, subject1, subject2, subject3, subject4, subject5);
        }

        System.out.println("\nResults:");
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Total Marks: " + student.total());
            System.out.println("Average Marks: " + student.average());
            System.out.println("Grade: " + student.grade());
            System.out.println();
        }

        scanner.close(); // Close scanner to prevent resource leaks
    }
}
