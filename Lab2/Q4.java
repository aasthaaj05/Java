/*Write a program to print the following patterns using loops:
1  
12  
123  
1234  
12345  

    *  
   ***  
  *****  
 *******  
*********
 */

public class Q4 {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            for (int j=1;j<=i;j++) {System.out.print(j);}
            System.out.println();
        }
        int r=5;
        for (int i=1;i<=r;i++) {
            for (int j=1;j<=r-i;j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}