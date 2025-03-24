//Design a Car class with attributes like make, model, year, and color. Implement methods to display car details and change the car color.
import java.util.Scanner;

class Car{
    String make, model, color;
    int year;
    public void printFunc(Car car){
        System.out.println(
        "Make of car is "+car.make
        + ", model of car is "+ car.model
        + ", Year of car is "+ car.year
        + ", Colour of car is "+ car.color
        );
    }
}
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car= new Car();
        System.out.println("Enter color of car:");
        car.color= scanner.nextLine();
        System.out.println("Enter make of car:");
        car.make= scanner.nextLine();
        System.out.println("Enter model of car:");
        car.model= scanner.nextLine();
        System.out.println("Enter year of car:");
        car.year= scanner.nextInt();
        scanner.nextLine();
        car.printFunc(car);
        System.out.println("Enter new colour:");
        car.color= scanner.nextLine();
        System.out.println("After changing colour:");
        car.printFunc(car);
    }
}