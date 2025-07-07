/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lagrangeinterpolatingpolynomials;

import java.util.Scanner;

/**
 *
 * @author Abu Amin
 */
public class LagrangeInterpolatingPolynomials {

    /**
     * Computing f(x) equation if required.
     * And if not entered y value,
     * حساب معادلة 
     * f(x)
     * ان تم طلبها في البرنامج تتم عن طريق ادخال المعادلة
     *
     * @param x value of x must getten y value for it.
     * @return the equation.
     */
    public static double F(double x) {

        return (1 / x);
    }

    /**
     * Computing lagrange for polynomial 2
     *
     * @param x value of x value for compute here y value,
     * @param x0 value of x for points number one,
     * @param x1 value of x for points number two
     * @param x2 value of x for points number three
     * @return computing the L0 and return the result in double type.
     */
    public static double L0(double x, double x0, double x1, double x2) {
        double equation = ((x - x1) * (x - x2)) / ((x0 - x1) * (x0 - x2));
        return equation;
    }

    /**
     * Computing lagrange for polynomial 2
     *
     * @param x value of x value for compute here y value,
     * @param x0 value of x for points number one,
     * @param x1 value of x for points number two
     * @param x2 value of x for points number three
     * @return computing the L1 and return the result in double type.
     */
    public static double L1(double x, double x0, double x1, double x2) {
        double equation = ((x - x0) * (x - x2)) / ((x1 - x0) * (x1 - x2));
        return equation;
    }

    /**
     * Computing lagrange for polynomial 2
     *
     * @param x value of x value for compute here y value,
     * @param x0 value of x for points number one,
     * @param x1 value of x for points number two
     * @param x2 value of x for points number three
     * @return computing the L2 and return the result in double type.
     */
    public static double L2(double x, double x0, double x1, double x2) {
        double equation = ((x - x0) * (x - x1)) / ((x2 - x0) * (x2 - x1));
        return equation;
    }

    /**
     * Compute the polynomial for y value
     * @param x
     * value of x value for compute here y value,
     * @param x0
     * value of x for points number one,
     * @param y0
     * value of y|(f(x)) for point number one,  
     * @param x1
     * value of x for points number two,
     * @param y1
     * value of y|(f(x)) for point number two,  
     * @param x2
     * value of x for points number three
     * @param y2
     * value of y|(f(x)) for point number three,  
     * @return 
     * String data type,
     * for right format for disable Pn(x) = result for y|f(x) value.
     */
    public static String P(double x, double x0, double y0, double x1, double y1, double x2, double y2) {
        double l0 = L0(x, x0, x1, x2);
        double l1 = L1(x, x0, x1, x2);
        double l2 = L2(x, x0, x1, x2);

        double part0 = l0 * y0;
        double part1 = l1 * y1;
        double part2 = l2 * y2;

        double result = part0 + part1 + part2;

        return "P2( " + x + ") = " + result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Using degree-02 lagrange interpolation: ");

            System.out.println("Enter value for X point: ");
            String xs = input.nextLine();
            double x = Double.parseDouble(xs);

            System.out.println("Enter first point for: \nX(0): ");
            String x0s = input.nextLine();
            double x0 = Double.parseDouble(x0s);

            System.out.println("Enter first point for: \nY(0): ");
            String y0s = input.nextLine();
            double y0 = Double.parseDouble(y0s);

            System.out.println("Enter first point for: \nX(1): ");
            String x1s = input.nextLine();
            double x1 = Double.parseDouble(x1s);

            System.out.println("Enter first point for: \nY(1): ");
            String y1s = input.nextLine();
            double y1 = Double.parseDouble(y1s);

            System.out.println("Enter first point for: \nX(2): ");
            String x2s = input.nextLine();
            double x2 = Double.parseDouble(x2s);

            System.out.println("Enter first point for: \nY(2): ");
            String y2s = input.nextLine();
            double y2 = Double.parseDouble(y2s);

            String lagrange = P(x, x0, y0, x1, y1, x2, y2);

            System.out.println("""
                               Lagrange Interpolation secound-polynomaial
                               Result: [ """ + lagrange + " ]");

        } catch (IllegalArgumentException e) {
            System.out.println("Type Error: " + e.getMessage() + "!!!");
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage() + "!!!");
        } finally {
            System.out.println("Finished...");
        }
    }

}
