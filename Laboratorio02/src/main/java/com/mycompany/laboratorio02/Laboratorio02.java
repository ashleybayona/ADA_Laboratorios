/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laboratorio02;

import java.util.Random;

/**
 *
 * @author ASHLEY
 */
public class Laboratorio02 {
    
    public static int[] generarArreglo (int tamanio) {
        int[] nuevoArreglo = new int[tamanio];
        Random rand = new Random();
        
        for(int i = 0; i < tamanio; i++) {
            nuevoArreglo[i] = rand.nextInt(20) - 10;
        }
        
        return nuevoArreglo;
    }
    
    public static int[] algoritmo(int[] arreglo) {
        int[] resultado = new int[4]; // [sumaActual, mejorSuma, inicio, fin]

        int sumaActual = 0;
        int mejorSuma = Integer.MIN_VALUE;
        int inicioTemp = 0;

        for (int i = 0; i < arreglo.length; i++) {
            sumaActual += arreglo[i];

            if (sumaActual > mejorSuma) {
                mejorSuma = sumaActual;
                resultado[1] = mejorSuma;
                resultado[2] = inicioTemp;
                resultado[3] = i;
            }

            if (sumaActual < 0) {
                sumaActual = 0;
                inicioTemp = i + 1;
            }
        }

        resultado[0] = sumaActual; 
        return resultado;
    }
    
    public static void mostrarArreglo(int[] arr){
        int tamanio = arr.length;
        
        for(int i = 0; i < tamanio; i++){
            System.out.print(arr[i]);
            if(i < tamanio - 1){
                System.out.print(", ");
            } else {
                System.out.println("}");
            }
        }
    }

    public static void main(String[] args) {
        int[] arreglo = generarArreglo(10);
        int tamanioArr = arreglo.length;
        int[] subArr = algoritmo(arreglo);
        
        System.out.print("Arreglo inicial: {");
        mostrarArreglo(arreglo);
        System.out.println("");
        
        System.out.println("La suma total es: " + subArr[1]);
        System.out.println("Desde la posicion " + (subArr[2]+1) + " hasta " + (subArr[3]+1));
    }
}
