/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rsaencryption;


public class RSAEncryption {
    public static String ecoding(String text, int p, int q){
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alpha = new char[key.length()];
        String[] number = new String[key.length()];
//        char[][] k = new char[key.length()][key.length()];
        
        for (int i = 0; i < key.length(); i++) {
            alpha[i] = key.charAt(i);
            if (i<10) {
                number[i] = "0" + i;
            }else{
//                number[i] = (String) i;
            }
        }
        return null;
                
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 10;
        
    }

}
