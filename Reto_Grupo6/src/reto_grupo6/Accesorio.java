/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;

/**
 *
 * @author h.ramos
 */
public class Accesorio extends Producto {
    private String marca;
    private String color;
    
    public Accesorio(String nombre, int precio, int unidades, String marca, String color){
        super  (nombre, precio, unidades);
        this.marca=marca;
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public String getMarca(){
        return marca;
    } 
    
    public String probar(){
        return "El accesorio funciona correctamente";
    }
}
