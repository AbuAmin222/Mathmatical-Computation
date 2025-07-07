
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Abu Amin
 */
public class BisectionAlgorithm21 {

    /**
     * Define equation,
     *
     * @param x Variable for (a or b),
     * @return
     */
    public static double f(double x) {
        //use the math liprary for compute the power by use pow(number, power) method
        return Math.pow(x, 3) + (4 * Math.pow(x, 2)) - 10;
    }

    /**
     * Execute conditions for a,b values,
     *
     * @param a
     * @param b
     * @return If values have opposite signs.
     */
    public static boolean condition(double a, double b) {
        double fa = f(a);
        double fb = f(b);
        
        if ((fa * fb > 0)) {
            return true;
        }
        throw new IllegalArgumentException("Values of [f(a), f(b)] should have opposite signs!!!");

    }

    
    /**
     * Addition condition for tolerance and N values,
     *
     * @param tol Tolerance value (Result numbers that program should stop in it
     * when arrive to it.),
     * @param N N value (Number of maximum operation that when program arrive to
     * it number without arrive tolerance number stopped )
     * @return If the [N, tolerance] values greater than (-1).
     */
    public static boolean additionConditions(double tol, int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Vlaue [N] should be greater than (-1) !!!");
        } else if (tol <= 0) {
            throw new IllegalArgumentException("Vlaue [Tolerance] should be greater than (-1) !!!");
        }
        return true;
    }

    /**
     * Building Bisection algorithm,
     *
     * @param a Variable one for a value,
     * @param b Variable two for b value,
     * @param tolerance Variable for tolerance value,
     * @param N Variable for Maximum number for iteration.
     */
    public static void bisection(double a, double b, double tolerance, int N) {
//        try {
//            condition(a, b);
//            additionConditions(tolerance, N);

            double fa = f(a);
            double fb = f(b);

            double p = 0;
            for (int i = 1; i <= N; i++) {
                p = (a + b) / 2;
                double fp = f(p);
                System.out.printf("Iteration %2d: p=%.10f,f(p)=%.10f\n", i, p, fp);

                double temp = (b - a) / 0b10;
                if (fp == 0 || temp < tolerance) {
                    System.out.println("Approximate root found at p = " + p);
                    return;
                }
                if (fa * fp > 0) {
                    a = p;
                    fa = fp;
                } else {
                    b = p;
                    fb = fp;
                }
            }
            System.out.println("\n Method stopped after max iteartions Last approximation: p = " + p);

//        } catch (IllegalArgumentException e) {
//            System.out.println("Input Error: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Unexpected error occured: " + e.getMessage());
//        }finally {
//            System.err.println("Be Happy...");
//        }

    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Please must [a, b] values have opposite signs.\nEnter [a] value: ");
            double a = input.nextDouble();

            System.out.println("Enter [b] value: ");
            double b = input.nextDouble();

            System.out.println("Please must [Tolerance, N] values be greater than zero.\nEnter [Tolerance] value: ");
            double tolerance = input.nextDouble();

            System.out.println("Enter [N] value: ");
            int N = input.nextInt();

            bisection(a, b, tolerance, N);

        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid Inputs!!!\n Reenter values with make conditions!!!" +  e.getMessage());
        } 
    }
}
