/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio06;

/**
 *
 * @author ASHLEY
 */
public class HashLineal {
    private Cliente[] tabla;
    private int capacidad;

    public HashLineal(int capacidad) {
        this.capacidad = capacidad;
        tabla = new Cliente[capacidad];
    }
    
    public static int generarHash(String clave, int tamanoTabla) {
        int hash = 0;
        for (char c : clave.toCharArray()) {
            hash = (hash * 31 + c) % tamanoTabla;
        }
        return hash;
    }

    public void insertar(Cliente cliente) {
        int hash = generarHash(cliente.getClaveHash(), capacidad);
        int original = hash;
        while (tabla[hash] != null) {
            hash = (hash + 1) % capacidad;
            if (hash == original) return; 
        }
        tabla[hash] = cliente;
    }

    public Cliente buscar(String clave) {
        int hash = generarHash(clave, capacidad);
        int original = hash;
        while (tabla[hash] != null && !tabla[hash].getClaveHash().equals(clave)) {
            hash = (hash + 1) % capacidad;
            if (hash == original) return null;
        }
        return tabla[hash];
    }
}
