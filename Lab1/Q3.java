//Create a program that swaps the values of two variables without using a temporary variable.
public class Q3 {
    public static void main(String[] args) {
        int x=20;
        int y=2;
        System.out.println("Before swapping x is " + x + " y is " + y);
        x=x-y;
        y=x+y;
        x=-x+y;
        System.out.println("After swapping x is " + x + " y is " + y);
    }
}