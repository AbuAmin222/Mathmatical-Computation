/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignments;

import java.util.Scanner;

/**
 *
 * @author Abu Amin
 */
public class NewtonsMethod {
    /**
     * Equation for f(x) method,
     * @param x
     * Variable,
     * Type double,
     * @return 
     * Double value type,
     * Value of f(x) for ,
     * f(x) = x^3 - 2 * 2 * x^2.
     */
    public static double f(double x){
        double result = Math.pow(x, 3) - 2 * Math.pow(x, 2) - 5;
        return result;
    }
    
    /**
     * Equation for f`(x) method,
     * @param x
     * Variable ,
     * Type double,
     * @return 
     * Double value type,
     * Result of f`(x) for ,
     * f`(x) = 3 * x^2 - 4 * x.
     */
    public static double fPrime(double x){
        double result = 3 * Math.pow(x, 2) - 4 * x;
        return result;
    }
    
    /**
     * Equation for p(x) method,
     * @param p
     * double type value,
     * value of p0,
     * @return 
     * Double value type,
     * Result of p(x) for ,
     * p(x) = p - (f(p) / f`(p)).
     */
    public static double p(double p){
        double result = p - (f(p) / fPrime(p));
        return result;
    }
    
    /**
     * Condition method
     * @param p
     * Double value type,
     * validate if between min and max numbers, 
     * validate if f`(p) not equal zero,
     * @param max
     * maximum number on the 
     * validate if max greater than minimum number,
     * @param min
     * minimum number on the 
     * validate if minimum number less than maximum number,
     * @return 
     * true if is right and,
     * p between min and max numbers,
     * f`(p) not equal zero,
     * else 
     * error message.
     */
    public static boolean condition(double p, double max, double min){
        if(p > max || p < min || max < min){
            throw new IllegalArgumentException("Please Enter number between [ " + min + ", " + max + "]!!!");
        }else if(fPrime(p) == 0 ){
            throw new IllegalArgumentException("Please Enter number greater than zero!!!");
        }else{
            return true;        
        }
    }
    
    /**
     * Additional condition method
     * @param N
     * Maximum number of iteration,
     * Integer data type,
     * validate if greater than zero,
     * @return 
     * true,
     * if n value greater than zero,
     * else,
     * error message.
     */
    public static boolean additionCondition(int N){
        if(N > 0){
            return true;
        }else{
            throw new IllegalArgumentException("Please Enter number of (N) maximum iteration greater than zero!!!");
        }
    }
    
    /**
     * Basic method for compute newtons method algorithm,
     * @param p
     * initial p => p0,
     * @param tolerance
     * Accuracy value,
     * @param min
     * minimum number in ,
     * @param max
     * maximum number in ,
     * @param N
     * maximum number of iteration,
     * if not arrive to tolerance value,
     * @return 
     * p value,
     * double data type.
     */
    public static double newtons(double p, double tolerance, double min, double max, int  N){
//        validate n value.
        additionCondition(N);
//        validate p, max, min, value.
        condition(p, max, min);
        
//        pn value.
//        default / starter with p1 value.
        double P_up = p(p);
//        pn-1 value.
//        default / starter with p0 value.
        double P_down = p;
//        number of iterations.
//        starter one because first opertion are execute auto.
        int NIteration = 1;
        
//        do code if pn - pn-1 equal tolerance value ,
//        or number of iteraton equal n value.
        while(Math.abs(P_up - P_down) >= tolerance && NIteration < N){
            P_down = P_up;
            P_up = p(P_up);
            NIteration++;
        }
        System.out.print("P" + NIteration);
        return P_up;
    }
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double result = 0;

        try {            
            System.out.println("Enter p value: ");
            String p0 = input.nextLine();
            double p = Double.parseDouble(p0);
            
            System.out.println("Enter tolerance value: ");
            String t = input.nextLine();
            double tolerance = Double.parseDouble(t);
            
            System.out.println("Enter minemum number: ");
            String m = input.nextLine();
            double min = Double.parseDouble(m);
            
            System.out.println("Enter maximum number: ");
            String ma = input.nextLine();
            double max = Double.parseDouble(ma);
            
            System.out.println("Enter number of maximum iteration: ");
            int N = input.nextInt();
            
            result = newtons(p, tolerance, min, max, N);
//            if here an exception in mehtod.
        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
//            if here an exception in inputs or program.
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
//            run in all way error or true.
        } finally {
            System.out.println(" = " + result);
            System.out.println("Finished");
        }
    }
}
