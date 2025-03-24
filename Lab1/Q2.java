//Enter cost of 3 items from the user (using float data type) - a pencil, a pen and an eraser. You have to output the total cost of the items back to the user as their bill. (Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem)
import java.util.Scanner;

class Item{
    float price;
}

public class Q2 {
    public static double priceCal(float x, float y, float z){
        return 1.18*(x+y+z);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Item pen= new Item();
        Item pencil= new Item();
        Item eraser= new Item();
        System.out.println("Enter prices for Pen:");
        pen.price= scanner.nextFloat();
        System.out.println("Enter prices for Pencil:");
        pencil.price= scanner.nextFloat();System.out.println("Enter prices for Eraser:");
        eraser.price= scanner.nextFloat();
        double result=priceCal(pen.price, pencil.price, eraser.price);
        System.out.println("Bill of all the items(with GST is) " + result);
    }
}