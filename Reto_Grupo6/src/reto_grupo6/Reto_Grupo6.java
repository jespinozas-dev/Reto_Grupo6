/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto_grupo6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author J.ESPINOZA
 */
public class Reto_Grupo6 {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuarioActual = bienvenida();
        System.out.println("Usuario logueado: " + usuarioActual.getNombre());

        System.out.println(usuarioActual.getEdad());
    }

    public static Usuario bienvenida() {

        while (true) {
            System.out.println("Bienvenido, ¿qué quieres hacer?");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            while (opcion != 1 && opcion != 2) { //bucle para validar la opcion del menu
                System.out.println("Esa opcion no existe");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
            }

            if (opcion == 1) { // LOGIN
                System.out.println("Usuario: ");
                String usuario = scanner.nextLine();
                System.out.println("Contraseña: ");
                String contraseña = scanner.nextLine();

                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuario.equals(usuarios.get(i).getNombre())
                            && contraseña.equals(usuarios.get(i).getContraseña())) {
                        System.out.println("Bienvenido, " + usuarios.get(i).getNombre());
                        return usuarios.get(i); // devolvemos directamente el usuario
                    }
                }
                System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo.");

            } else if (opcion == 2) { // REGISTRO
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                boolean fechaValida = false;
                LocalDate fecha_nacimiento = null;
                while (!fechaValida) {
                    try {
                        System.out.println("Fecha de nacimiento");
                        System.out.print("Año: ");
                        int año = scanner.nextInt();
                        System.out.print("Mes: ");
                        int mes = scanner.nextInt();
                        System.out.print("Dia: ");
                        int dia = scanner.nextInt();

                        fecha_nacimiento = LocalDate.of(año, mes, dia);
                        fechaValida = true;

                    } catch (Exception e) {
                        System.out.println("La fecha ingresada no es válida. Intenta de nuevo.");
                    } finally {
                        scanner.nextLine(); // limpiar buffer
                    }
                }

                System.out.print("Saldo inicial: ");
                int saldo = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                System.out.print("Contraseña: ");
                String contraseña = scanner.nextLine();

                Usuario usuario1 = new Usuario(nombre, fecha_nacimiento, saldo, contraseña);
                usuarios.add(usuario1);

                System.out.println("Usuario registrado correctamente. Bienvenido, " + usuario1.getNombre());
                return usuario1;
            }
        }
    }
} 
