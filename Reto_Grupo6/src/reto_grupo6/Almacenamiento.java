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
    private int capacidad;

    public Almacenamiento(String nombre, int precio, int unidades, String descripcion, String marca, String color, int capacidad) {
        super(nombre, precio, unidades, descripcion, marca, color);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String consultar() {
        return "\nNombre: " + super.getNombre() + "\nPrecio: " + super.getPrecio() + "\nDescripción del producto: " + super.getDescripcion() + "\nMarca: " + super.getMarca() + "\nColor: " + super.getColor() + "\nCapacidad (GB): " + capacidad;
    }

    @Override
    public String probar() {
        return "Probando almacenamiento con capacidad de " + capacidad;
    }

}
