/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_grupo6;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author J.ESPINOZA
 */
public class Usuario {
    private String nombre;
    private LocalDate fecha_nacimiento;
    private int saldo;
    private String contraseña;
    private ArrayList<Producto> comprasRealizadas;
    
public Usuario(String nombre, LocalDate fecha_nacimiento, int saldo, String contraseña){
    this.nombre=nombre;
    this.fecha_nacimiento=fecha_nacimiento;
    this.saldo=saldo;
    this.contraseña=contraseña;
    this.comprasRealizadas=new ArrayList<>();
}

public String getNombre(){
    return nombre;
}

public LocalDate getfecha_nacimiento(){
    return fecha_nacimiento;
}

public int getEdad() {
     return Period.between(fecha_nacimiento, LocalDate.now()).getYears();
}

public int getSaldo(){
    return saldo;
}

public String getContraseña(){
    return contraseña;
}

public ArrayList<Producto> getComprasRealizadas(){
    return comprasRealizadas;
}

public void setNombre(String nombre){
    this.nombre=nombre;
}

public void setFecha_nacimiento(LocalDate fecha_nacimiento){
    this.fecha_nacimiento=fecha_nacimiento;
}

public void setSaldo(int saldo){
    this.saldo=saldo;
}

public void setContraseña(String contraseña){
    this.contraseña=contraseña;
}


public void añadirSaldo(int saldo){
    this.saldo+=saldo;
}

public boolean comprar(Producto producto){
    if(producto.reducirUnidades()){
        comprasRealizadas.add(producto);
        return true;
    }else{
        return false;
    }
}

}


