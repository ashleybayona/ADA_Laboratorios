/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laboratorio06;

import java.util.Scanner;

/**
 *
 * @author ASHLEY
 */
public class Laboratorio06 {

    public static void main(String[] args) {
        final int TAMANO_TABLA = 10;
        HashLineal tablaLineal = new HashLineal(TAMANO_TABLA);
        HashArbol tablaArbol = new HashArbol(TAMANO_TABLA);

        Cliente[] clientes = {
            new Cliente("001", "Ana", "Torres", "123456", "ana@mail.com", "Av. Siempre Viva", "15001"),
            new Cliente("002", "Luis", "Perez", "789456", "luis@mail.com", "Calle Falsa", "15002"),
            new Cliente("003", "Carlos", "Ramos", "456123", "carlos@mail.com", "Jr. Sol", "15003")
        };

        // Insertar datos
        for (Cliente c : clientes) {
            tablaLineal.insertar(c);
            tablaArbol.insertar(c);
        }

        // Buscar un cliente
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre y apellido a buscar (ej: Ana Torres): ");
        String clave = sc.nextLine();

        long inicioLineal = System.nanoTime();
        Cliente encontradoLineal = tablaLineal.buscar(clave);
        long finLineal = System.nanoTime();

        long inicioArbol = System.nanoTime();
        Cliente encontradoArbol = tablaArbol.buscar(clave);
        long finArbol = System.nanoTime();

        System.out.println("\n=== Resultados ===");
        if (encontradoLineal != null)
            System.out.println("Lineal: " + encontradoLineal);
        else
            System.out.println("Lineal: No encontrado");

        if (encontradoArbol != null)
            System.out.println("Arbol: " + encontradoArbol);
        else
            System.out.println("Arbol: No encontrado");

        System.out.println("\nTiempos (en nanosegundos):");
        System.out.println("Reasignacion Lineal: " + (finLineal - inicioLineal));
        System.out.println("Encadenamiento Arbol: " + (finArbol - inicioArbol));
    }
}
