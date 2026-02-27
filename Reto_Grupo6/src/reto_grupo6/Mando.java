/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;

/**
 *
 * @author h.ramos
 */
public class Mando extends Accesorio {
    private String consola;

    public Mando(String nombre, int precio, int unidades, String descripcion, String marca, String color, String consola) {
        super(nombre, precio, unidades, descripcion, marca, color);
        this.consola = consola;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    @Override
    public String consultar() {
        return "\nNombre: " + super.getNombre() + "\nPrecio: " + super.getPrecio() + "\nDescripción del producto: " + super.getDescripcion() + "\nMarca: " + super.getMarca() + "\nColor: " + super.getColor() + "\nConsola: " + consola;
    }

    @Override
    public String probar() {
        return "Probando el mando de " + consola;
    }
}
