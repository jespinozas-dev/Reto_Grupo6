/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;

/**
 *
 * @author h.ramos
 */
public class Mando extends Accesorio{
    private String consola;
    public Mando(String nombre, int precio, int unidades, String marca, String color, String consola){
        super(nombre, precio, unidades, marca, color);
        this.consola=consola;
    }
    
    public String getConsola(){
        return consola;
    }
    
    public String probar(){
        return "Probando el mando de "+consola;
    }
}
