/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio06;

/**
 *
 * @author ASHLEY
 */
public class Cliente {

    private String codigo, nombres, apellidos, telefono, correo, direccion, codigoPostal;

    public Cliente(String codigo, String nombres, String apellidos, String telefono, String correo, String direccion, String codigoPostal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public String getClaveHash() {
        return nombres + " " + apellidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }

}
