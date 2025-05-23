package com.mycompany.labortatorio03;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ASHLEY
 */
public class Labortatorio03 {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el valor de m: ");
        int m = scanner.nextInt();
        System.out.print("Ingresa el valor de n: ");
        int n = scanner.nextInt();
        System.out.println("");

        // tiempo de ejecución de la función recursiva
        long startTimeRecursivo = System.currentTimeMillis();
        int resultadoRecursivo = ackRecursivo(m, n);
        long endTimeRecursivo = System.currentTimeMillis();
        long tiempoRecursivo = endTimeRecursivo - startTimeRecursivo;

        System.out.println("Resultado recursivo: " + resultadoRecursivo);
        System.out.println("Tiempo de ejecucion de la funcion recursiva: " + tiempoRecursivo + " ms");
        System.out.println("");

        // tiempo de ejecución de la función iterativa
        long startTimeIterativo = System.currentTimeMillis();
        int resultadoIterativo = ackIterativo(m, n);
        long endTimeIterativo = System.currentTimeMillis();
        long tiempoIterativo = endTimeIterativo - startTimeIterativo;

        System.out.println("Resultado iterativo: " + resultadoIterativo);
        System.out.println("Tiempo de ejecucion de la funcion iterativa: " + tiempoIterativo + " ms");
        System.out.println("");
        
        

        // notación asintotica
        System.out.println("\nAnalisis:");
        System.out.println("La notacion asintotica de la funcion de Ackermann crece extremadamente rapido.");
        System.out.println("Es una funcion no primitiva recursiva y su tiempo de ejecucion no se puede describir facilmente con funciones tradicionales.");
        System.out.println("La funcion recursiva y la iterativa tienen un crecimiento similar, pero la iterativa evita los desbordamientos de pila y es mas eficiente para grandes valores.");
        System.out.println("El analisis de cada funcion se encuentra comentado en el algoritmo.");
    }
    
    public static Integer ackRecursivo(int m,int n) {
        // Big-O: La función recursiva de Ackermann crece tan rápido que no puede ser expresada de manera convencional en Big-O.
        // Su complejidad no es primitiva recursiva y tiene un crecimiento extremadamente rápido.
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackRecursivo (m-1, 1);
        } else if (m > 0 && n > 0) {
            return ackRecursivo (m-1, ackRecursivo(m, n-1));
        }
        return null;
    }
    
    static class Par {
        int m, n;
        Par(int m, int n) { this.m = m; this.n = n; }
    }
    
    // uso de pila para evitar recursividad
    public static int ackIterativo(int m, int n) {
        // Big-O: La complejidad temporal del algoritmo iterativo es también extremadamente alta.
        // Aunque evitamos desbordamientos de pila, sigue teniendo un crecimiento muy rápido.
        // Similar a la versión recursiva, su tiempo de ejecución crece rápidamente debido a la naturaleza de la función de Ackermann.
        Stack<Par> stack = new Stack<>();
        stack.push(new Par(m, n)); 

        int resultado = 0;

        while (!stack.isEmpty()) {
            Par p = stack.pop(); 
            m = p.m;
            n = p.n;

            // mismas condicionales que en recursivo 
            if (m == 0) {
                resultado = n + 1; 
            } else if (m > 0 && n == 0) {
                stack.push(new Par(m - 1, 1)); 
                continue; 
            } else if (m > 0 && n > 0) {
                stack.push(new Par(m - 1, -1));  
                stack.push(new Par(m, n - 1));   
                continue;
            }

            if (!stack.isEmpty() && stack.peek().n == -1) {
                Par top = stack.pop();
                stack.push(new Par(top.m, resultado)); 
            }
        }

        return resultado;
    }
}
