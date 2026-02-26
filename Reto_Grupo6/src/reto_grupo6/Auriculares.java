/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;

/**
 *
 * @author h.ramos
 */
public class Auriculares extends Accesorio {
    private boolean microfono;

    public Auriculares(String nombre, int precio, int unidades, String marca, String color, boolean microfono) {
        super(nombre, precio, unidades, marca, color);
        this.microfono = microfono;
    }

    public boolean getMicrofono() {
        return microfono;
    }

    @Override
    public String probar() {
        if (microfono) {
            return "Probando auriculares con microfono";
        } else {
            return "Probando auriculares sin microfono";
        }
    }
}
