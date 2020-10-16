/* Written by Ben Joens
October 15, 2020
This program can convert Celsius to Fahrenheit and vice versa
*/
import java.util.InputMismatchException; // This is essential for my "try-and-catch"; this is an error that it looks for
import java.util.Scanner; // Imports the Java Scanner class to get user input

public class programOne {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Creates the Scanner object to get user input
        System.out.println("Type 1 for Fahrenheit to Celsius conversion.");
        System.out.println("Type 2 for Celsius to Fahrenheit conversion.");

        String choice = myObj.nextLine(); // Reads user input in String format
        try { // I used the try and catch because it's a great way to eliminate any errors that come up, such as entering something that isn't a number
            int choiceInt = Integer.parseInt(choice); // I couldn't get the if statements to work with the String choice, so I converted it into an int
            if (choiceInt == 1) { // Fahrenheit to Celsius conversion
                try {
                    System.out.println("Enter Fahrenheit value:");
                    int fahrenheit = myObj.nextInt(); // Reads user input again in int format to print
                    double fahrenheitDouble = (double) fahrenheit; // Converting the int to double to get the exact conversion
                    double cConversion = ((double) 5 / 9) * (fahrenheitDouble - 32); // Casting to get an exact value of Celsius
                    int cConversionInt = (int) cConversion; // Converting the double that we got into an int
                    if (cConversion - cConversionInt >= 0.5) { // Here, I am rounding the final number either up or down, depending on the difference between the double and int
                        System.out.println(fahrenheit + " degrees Fahrenheit is approximately equal to " + (cConversionInt + 1) + " degrees Celsius.");
                    } else if (cConversion - cConversionInt <= -0.5) {
                        System.out.println(fahrenheit + " degrees Fahrenheit is approximately equal to " + (cConversionInt - 1) + " degrees Celsius.");
                    } else {
                        System.out.println(fahrenheit + " degrees Fahrenheit is approximately equal to " + cConversionInt + " degrees Celsius.");
                    }
                } catch (InputMismatchException ex) { // InputMismatchException is an error you get when you don't type in a valid double
                    System.out.println("Please enter a valid value.");
                    main(args);
                }
            } else if (choiceInt == 2) { // The same thing, but for Celsius to Fahrenheit conversion
                try {
                    System.out.println("Enter Celsius value:");
                    int celsius = myObj.nextInt();
                    double celsiusDouble = (double) celsius;
                    double fConversion = ((celsiusDouble * ((double) 9 / 5)) + 32);
                    int fConversionInt = (int) fConversion;
                    if (fConversion - fConversionInt >= 0.5) {
                        System.out.println(celsius + " degrees Celsius is approximately equal to " + (fConversionInt + 1) + " degrees Fahrenheit.");
                    } else if (fConversion - fConversionInt <= -0.5) {
                        System.out.println(celsius + " degrees Celsius is approximately equal to " + (fConversionInt - 1) + " degrees Fahrenheit.");
                    } else {
                        System.out.println(celsius + " degrees Celsius is approximately equal to " + fConversionInt + " degrees Fahrenheit.");
                    }
                } catch (InputMismatchException ex) { // Look at line 30
                    System.out.println("Please enter a valid value.");
                    main(args);
                }
            } else { // If the program gets any other response besides 1 or 2, it runs the main() method again
                System.out.println("That's not a 1 or 2. Just read it next time.");
                main(args);
            }
        } catch (NumberFormatException ex) { // NumberFormatException is when you type in a String that can't be parsed into an int, so this catch statement covers that error
            System.out.println("That's not a 1 or 2. Just read it next time.");
            main(args);
        }
        myObj.close(); // Closing the scanner object because it told me to
    }
}
/* Basically, I tried to cover all possible scenarios for user input,
so everytime I got an error, the program wouldn't shut down
Try and catch statements really helped with that
*/