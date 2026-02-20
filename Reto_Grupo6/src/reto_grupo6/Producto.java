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
    

public Producto(String nombre, double precio, int unidades){
    this.nombre=nombre;
    this.precio=precio;
    this.unidades=unidades;
}

public String getNombre(){
    return nombre;
}

public double getPrecio(){
    return precio;
}

public int getUnidades(){
    return unidades;
}

public void setNombre(String nombre){
    this.nombre=nombre;
}

public void setPrecio(double precio){
    this.precio=precio;
}

public void setUnidades(int unidades){
    this.unidades=unidades;
}

public String consultar(){
    return "Nombre: " + nombre + "\n Precio: " + precio + "\n Unidades: " + unidades;
}

public String probar(){
    return "Se prueba el producto";
}

public boolean reducirUnidades(){
    if(unidades<1){
        return false;
    }else{
        unidades-=1;
        return true;
    } 
}

}
