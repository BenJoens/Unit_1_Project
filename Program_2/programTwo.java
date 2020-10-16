/* Written by Ben Joens
October 15, 2020
This program can display solutions for x given a quadratic equation
*/
import java.util.InputMismatchException;
import java.util.Scanner; // Imports the Java Scanner class to get user input

public class programTwo {
    public static void main(String[] args) throws InputMismatchException {
        Scanner myObj = new Scanner(System.in); // Creates the Scanner object to get user input
        
        try {
            System.out.print("a = ");
            int a = myObj.nextInt(); // Getting a, b, and c values from user using Scanner object
            if (a == 0) { System.out.println("That's not a quadratic equation."); main(args); } // If a = 0, then it is simply a linear equation
            double aDouble = (double) a; // Casting int a to a double
            System.out.print("b = ");
            int b = myObj.nextInt();
            double bDouble = (double) b;
            System.out.print("c = ");
            int c = myObj.nextInt();
            double cDouble = (double) c;
            double discriminant = (bDouble * bDouble) - (4 * aDouble * cDouble); // Discriminant is the value under the square root
            if (discriminant > 0) {
                double x1 = ((-bDouble) + Math.sqrt(discriminant) / (2 * aDouble));
                double x2 = ((-bDouble) - Math.sqrt(discriminant) / (2 * aDouble));
                if (x1 == x2) { 
                    System.out.println("x = " + x1 + " (multiplicity of 2)");
                } else {
                    System.out.println("x = " + x1 + ", " + x2);
                }
            } else if (discriminant < 0) { // Results in negative square root
                System.out.println("Yeah, this equation's solutions are imaginary. I don't feel like calculating that.");
            } else { // If discriminant is 0
                double x1 = (-bDouble) / (2 * aDouble);
                System.out.println("x = " + x1 + " (multiplicity of 2)");
            }
        } catch (InputMismatchException ex) { // If the input is anything but an int
            System.out.println("Invalid response. Please enter a whole number.");
            main(args);
        }
        myObj.close(); // Closing the scanner object because it told me to
    }
}