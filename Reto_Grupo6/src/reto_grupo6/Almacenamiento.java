/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;

/**
 *
 * @author h.ramos
 */
public class Almacenamiento extends Accesorio {
    private String capacidad;

    public Almacenamiento(String nombre, int precio, int unidades, String marca, String color, String capacidad) {
        super(nombre, precio, unidades, marca, color);
        this.capacidad = capacidad;
    }

    public String getCapacidad() {
        return capacidad;
    }

    @Override
    public String probar() {
        return "Probando almacenamiento con capacidad de " + capacidad;
    }

}
