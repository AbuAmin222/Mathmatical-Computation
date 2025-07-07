/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Abu Amin
 */
public class FixedPointIteration {

    /**
     * Function that doing g(x) with equation:
     * x^2 / 5,
     * @param x
     * @return 
     * result of equation for x value.
     */
    public static double g(double x) {
        return (Math.pow(x, 2) / 5);
    }

    /**
     * Condition function that validate 
     * @param tol
     * tolerance (tol) value greater than zero??
     * @param n
     * number of iteration (n) is greater than zero???
     * @return 
     * Exception for error,
     * True if validation success.
     */
    public static boolean condition(double tol, int n) {
        if (tol <= 0 && n <= 0) {
            throw new IllegalArgumentException("Tolerance must be greater than 0.\n\tNumber of iterations must be greater than 0.");
        } 
        if (tol <= 0 || n <= 0) {
            throw new IllegalArgumentException("Tolerance and Number of iterations must be greater than 0.");
        }
        return true;
    }

    /**
     * Fixed point function takes: ,
     * This parameters:
     * @param p0
     * Guess value,
     * @param tol
     * Tolerance value,
     * @param n 
     * Number of iteration value,
     * Print:
     * Success:
     * Iteration [current iterate] with [current p value],
     * Approximate fixed point found: p = [current p value]
     * Fauiler:
     * Method failed after [current iteration] iteration,
     * Error during iteration: [message]
     */
    public static void fixedPoint(double p0, double tol, int n) {
        try {
            double p;
            for (int i = 1; i <= n; i++) {
                p = g(p0);
                System.out.println("Iteration " + i + ": p = " + p);

                if (Math.abs(p - p0) < tol) {
                    System.out.println("\nApproximate fixed point found: p = " + p);
                    return;
                }

                p0 = p;

            }
            System.out.println("\nMethod failed after " + n + "iterations.");
        } catch (Exception e) {
            System.out.println("Error during iteration: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter initial guess p0: ");
//            Because my compiler dont mean double and give many problem im doing this:
//            Sort the value in string and extract it and change to double to p0, tol variabels.
            String p = input.nextLine();
            double p0 = Double.parseDouble(p);

            System.out.println("Enter tolerance: ");
            String t = input.nextLine();
            double tol = Double.parseDouble(t);

            System.out.println("Enter maximum number of iterations: ");
            int n = input.nextInt();

//            Make validation for each tolerance and number of iteration value.
            condition(tol, n);
//            Make based equation.
            fixedPoint(p0, tol, n);

//            If users enter string value.
        } catch (InputMismatchException e) {
            System.err.println("Invalid input type. Please enter numbers only!!!");
//            Display error occured.
        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
//            if program crach.
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
//            Result when finish program.
        } finally {
            input.close();
            System.out.println("Program finished.");
        }
    }
}
