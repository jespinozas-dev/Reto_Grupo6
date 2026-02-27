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

    public Auriculares(String nombre, int precio, int unidades, String descripcion, String marca, String color, boolean microfono) {
        super(nombre, precio, unidades, descripcion, marca, color);
        this.microfono = microfono;
    }

    public boolean isMicrofono() {
        return microfono;
    }

    public void setMicrofono(boolean microfono) {
        this.microfono = microfono;
    }

    @Override
    public String consultar() {
        return "\nNombre: " + super.getNombre() + "\nPrecio: " + super.getPrecio() + "\nDescripción del producto: " + super.getDescripcion() + "\nMarca: " + super.getMarca() + "\nColor: " + super.getColor() + "\nMicrófono: " + (microfono ? "Sí" : "No");
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
