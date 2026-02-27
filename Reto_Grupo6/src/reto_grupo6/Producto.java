/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;

/**
 *
 * @author J.ESPINOZA
 */
public class Producto {
    private String nombre;
    private double precio;
    private int unidades;
    private String descripcion;


    public Producto(String nombre, double precio, int unidades, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = -1;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String consultar() {
        return "\nNombre: " + nombre + "\n Precio: " + precio + "\n Descripción del producto: " + descripcion;
    }

    public String probar() {
        return "\nEl producto funciona correctamente.";
    }

    public boolean reducirUnidades() {
        if (unidades < 1) {
            return false;
        } else {
            unidades -= 1;
            return true;
        }
    }
}
