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
public class PermutationsCombinationsProbability {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            
            System.out.println("""
                               Enter {n} number 
                               Must be greater than zero,
                               Also not less than 6""");
            int n = input.nextInt();
            
            System.out.println("""
                               Enter {r} number 
                               Must be greater than zero and not exceeding {n} value""");
            int r = input.nextInt();
            
            long per = r_Permitation(n, r);
            long cop = r_Compintation(n, r);
            double prob = Probability(n);
            
            System.out.println("R-Permitation for [ " + n + ", " + r + " ] is: {" + per + "}");
            System.out.println("R-Compination for [ " + n + ", " + r + " ] is: {" + cop + "}");
            System.out.println("Probability for [ " + n + " ] is: {" + prob + "}");
            
        } catch(IllegalArgumentException i){
            System.out.println("Input Error: " + i.getMessage());
        }catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("The Factorial is undefined for negative numbers!!!");
        }
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    public static boolean conditions(int n, int r){
        if(n < 0 || r < 0 || n < r){
            throw new IllegalArgumentException("[ " + n + ", " + r + "] of (n, r) values must be greater than 1, "
                    + "\n[ " + r + " ]Must not exceeding an [ " + n + " ]value");
        }
        return true;
    }
    public static long r_Permitation(int n, int r){
        conditions(n, r);
        return factorial(n) / factorial(n - r);
    }
    public static long r_Compintation(int n, int r){
        conditions(n, r);
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    public static double Probability(int n) {
        if(n > 0 && n > 6){
            double prob = 6 / n;
            return prob;
        }else{

            throw new IllegalArgumentException("The value of n (" + n + ") must be greater than 6!!!");

        }
    }

}
