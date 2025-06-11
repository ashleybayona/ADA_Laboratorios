/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio06;

/**
 *
 * @author ASHLEY
 */
public class ArbolBinarioBusqueda {
    private NodoArbol raiz;

    public void insertar(Cliente cliente) {
        raiz = insertarRecursivo(raiz, cliente);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Cliente cliente) {
        if (nodo == null) return new NodoArbol(cliente);
        if (cliente.getClaveHash().compareTo(nodo.cliente.getClaveHash()) < 0)
            nodo.izquierda = insertarRecursivo(nodo.izquierda, cliente);
        else
            nodo.derecha = insertarRecursivo(nodo.derecha, cliente);
        return nodo;
    }

    public Cliente buscar(String clave) {
        return buscarRecursivo(raiz, clave);
    }

    private Cliente buscarRecursivo(NodoArbol nodo, String clave) {
        if (nodo == null) return null;
        if (nodo.cliente.getClaveHash().equals(clave)) return nodo.cliente;
        if (clave.compareTo(nodo.cliente.getClaveHash()) < 0)
            return buscarRecursivo(nodo.izquierda, clave);
        else
            return buscarRecursivo(nodo.derecha, clave);
    }
}
