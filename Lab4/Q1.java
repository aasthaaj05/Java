/*Problem Statement:

Create a Vehicle Rental System that manages different types of vehicles available for rent.
Encapsulation:

    Store vehicle details (license plate, model, rental cost) as private fields.
    Allow modifications only through setter methods, ensuring valid values are set.

Implement method overriding for different vehicle types:

    Car rental includes fuel charges.
    Bike rental does not include fuel charges.

Use method overloading for calculating rental cost based
*/

import java.util.Scanner;

class Vehicle {
    private final String licensePlate;
    private String model;
    private final int rentalCost;

    public Vehicle(String licensePlate, String model, int rentalCost) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalCost = rentalCost;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void display() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Model: " + model);
        System.out.println("Rental Cost per Day: ₹" + rentalCost);
    }
}

class Car {
    private Vehicle vehicle;
    private final int fuelChargePerKm = 10;
    private final int finePerDay = 500;

    public Car() {
        vehicle = new Vehicle("MH12AB1234", "Car", 2000);
    }

    public int calculateRentalCost(int days, int actualDays, int kms) {
        int baseCost = vehicle.getRentalCost() * days;
        int extraDays = actualDays - days;
        int fine = (extraDays > 0) ? extraDays * finePerDay : 0;
        int fuelCost = kms * fuelChargePerKm;
        return baseCost + fine + fuelCost;
    }

    public void displayDetails() {
        vehicle.display();
        System.out.println("Fuel Charge per Km: ₹" + fuelChargePerKm);
        System.out.println("Late Return Fine per Day: ₹" + finePerDay);
    }
}

class Bike {
    private Vehicle vehicle;
    private final int finePerDay = 200;

    public Bike() {
        vehicle = new Vehicle("MH12XY5678", "Bike", 500);
    }

    public int calculateRentalCost(int days, int actualDays, int kms) {
        int baseCost = vehicle.getRentalCost() * days;
        int extraDays = actualDays - days;
        int fine = (extraDays > 0) ? extraDays * finePerDay : 0;
        return baseCost + fine;
    }

    public void displayDetails() {
        vehicle.display();
        System.out.println("Late Return Fine per Day: ₹" + finePerDay);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vehicle type (Car/Bike): ");
        String type = scanner.nextLine().toLowerCase();

        System.out.println("Enter number of days you want to rent: ");
        int days = scanner.nextInt();

        System.out.println("Enter actual number of days before returning: ");
        int actualDays = scanner.nextInt();

        System.out.println("Enter number of kilometers traveled: ");
        int kms = scanner.nextInt();

        switch (type) {
            case "car":
                Car car = new Car();
                int carTotalCost = car.calculateRentalCost(days, actualDays, kms);
                System.out.println("\nCar Rental Details:");
                car.displayDetails();
                System.out.println("Total Cost: ₹" + carTotalCost);
                break;
            case "bike":
                Bike bike = new Bike();
                int bikeTotalCost = bike.calculateRentalCost(days, actualDays, kms);
                System.out.println("\nBike Rental Details:");
                bike.displayDetails();
                System.out.println("Total Cost: ₹" + bikeTotalCost);
                break;
            default:
                System.out.println("Invalid vehicle type! Please enter 'Car' or 'Bike'.");
        }

        scanner.close();
    }
}
