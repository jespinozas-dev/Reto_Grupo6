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

    static Scanner scanner;
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    static ArrayList<Producto> productos = new ArrayList<Producto>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }

    public static void bienvenida() {
        scanner = new Scanner(System.in);
        System.out.println("Bienvenido, que quieres hacer? \n"
                + "1. Iniciar sesion"
                + "2. Registarse");
        int opcion = scanner.nextInt();

        while (opcion != 1 || opcion != 2) { //bucle para validar la opcion del menu
            System.out.println("Esa opcion no existe");
            opcion = scanner.nextInt();
        }

        if (opcion == 1) {
            System.out.println("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.println("Contraseña: ");
            String contraseña = scanner.nextLine();
            Usuario iniciadoSesion = null;

            for (int i = 0; i < usuarios.size(); i++) {
                if (usuario.equals(usuarios.get(i).getNombre()) && contraseña.equals(usuarios.get(i).getContraseña())) {
                    iniciadoSesion = usuarios.get(i);
                    break;
                }
            }

            if (iniciadoSesion != null) {
                System.out.println("Bienvenido, " + iniciadoSesion.getNombre());
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
            
            //A COMPLETAR (EN EL MAIN TODOS LOS DATOS DEL USUARIOS SE SACAN DEL USUARIOS QUE ESTE EN INICIADOSESION)

        } else if (opcion == 2) {
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            LocalDate fecha_nacimiento = null;
            boolean fechaValida = false;

            while (!fechaValida) { // Bucle hasta que la fecha sea válida
                try {
                    System.out.println("Fecha de nacimiento");

                    System.out.println("Año: ");
                    int año = scanner.nextInt();

                    System.out.println("Mes: ");
                    int mes = scanner.nextInt();

                    System.out.println("Dia: ");
                    int dia = scanner.nextInt();

                    fecha_nacimiento = LocalDate.of(año, mes, dia);   // Intentar crear la fecha; si es inválida saltará DateTimeException
                    fechaValida = true;

                } catch (Exception e) {
                    System.out.println("La fecha ingresada no es válida. Intenta de nuevo.");
                } finally {
                    scanner.nextLine(); // limpiar buffer
                }
            }

            System.out.println("Saldo inicial: ");
            int saldo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Contraseña: ");
            String contraseña = scanner.nextLine();

            Usuario usuario1 = new Usuario(nombre, fecha_nacimiento, saldo, contraseña);

        }

    }

}
