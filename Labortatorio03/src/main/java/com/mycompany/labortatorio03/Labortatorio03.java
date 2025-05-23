/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labortatorio03;

/**
 *
 * @author ASHLEY
 */
public class Labortatorio03 {

    public static void main(String[] args) {
        
    }
    
    public static int ackRecursivo(int m,int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackRecursivo (m-1, 1);
        } else if (m > 0 && n > 0) {
            return ackRecursivo (m-1, ackRecursivo(m, n-1));
        }
    }
}
