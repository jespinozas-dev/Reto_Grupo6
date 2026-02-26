/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto_grupo6;

import java.util.ArrayList;

/**
 *
 * @author J.ESPINOZA
 */
public class Reto_Grupo6 {


    private static ArrayList<DLC> minecraftDLC = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto a = new Producto("Half-Life", 19.99, 17);
        Videojuego b = new Videojuego("Minecraft", 8.99, 14, "Supervivencia", 2009, "Mojang", 94, false, minecraftDLC);
        System.out.println(b.consultar());
        System.out.println(b.probar());
    }

}
