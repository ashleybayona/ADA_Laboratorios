/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio06;

/**
 *
 * @author ASHLEY
 */
public class HashArbol {
    private ArbolBinarioBusqueda[] tabla;
    private int capacidad;

    public HashArbol(int capacidad) {
        this.capacidad = capacidad;
        tabla = new ArbolBinarioBusqueda[capacidad];
        for (int i = 0; i < capacidad; i++) tabla[i] = new ArbolBinarioBusqueda();
    }

    public void insertar(Cliente cliente) {
        int hash = HashLineal.generarHash(cliente.getClaveHash(), capacidad);
        tabla[hash].insertar(cliente);
    }

    public Cliente buscar(String clave) {
        int hash = HashLineal.generarHash(clave, capacidad);
        return tabla[hash].buscar(clave);
    }
}
