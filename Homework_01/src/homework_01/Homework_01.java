/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homework_01;

public class Homework_01 {

    // Method to compute absolute value manually
    public static int absolute(int x) {
        return (x < 0) ? -x : x;
    }

    // Method to compute GCD using Euclidean Algorithm
    public static int gcd(int a, int b) {
        a = absolute(a);
        b = absolute(b);

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 48;  // You can change these values manually
        int b = 18;

        int result = gcd(a, b);

        System.out.println("gcd( " + a + ", " + b + " )=> " + result);

    }
    
}
