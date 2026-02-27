/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to
edit this template
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
    private static ArrayList<DLC> minecraftDLC = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuarioActual = null;

        while (true) {
            int opcion = menu();
            switch (opcion) {
                case 1:
                    usuarioActual = iniciarSesion();
                    break;
                case 2:
                    usuarioActual = registrarUsuario();
                    break;
                case 3:
                    System.exit(0);
            }

            int opcion2 = 0;

            while (opcion2 == 1 || opcion2 == 2) {
                opcion2 = menuPrincipal();
                switch (opcion2) {
                    case 1:
                        verCatalogo();
                        int opcion3 = menuCatalogo();
                        switch (opcion3) {
                            case 1:
                                consultar();
                                break;
                            case 2:
                                probar();
                                break;
                            case 3:
                                comprar(usuarioActual);
                                break;
                            case 4:
                                break;
                        }
                        break;
                    case 2:
                        verPerfil(usuarioActual);
                        int opcion4 = menuPerfil();
                        switch (opcion4) {
                            case 1:
                                añadirSaldo(usuarioActual);
                                break;
                            case 2:
                                verCompras(usuarioActual);
                                break;
                            case 3:
                                break;
                        }
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

    public static int menuPrincipal() {
        System.out.println("¿Qué quieres hacer ahora?");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Mi perfil");
        System.out.println("3. Cerrar sesión");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion != 1 && opcion != 2 && opcion != 3) {
            System.out.println("Esa opción no existe.");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        return opcion;
    }

    public static int menuCatalogo() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Consultar producto");
        System.out.println("2. Probar producto");
        System.out.println("3. Comprar producto");
        System.out.println("4. Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
            System.out.println("Esa opción no existe");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        return opcion;
    }

    public static int menuPerfil() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Añadir saldo");
        System.out.println("2. Ver tus compras");
        System.out.println("3. Volver al menú principal");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion != 1 && opcion != 2 && opcion != 3) {
            System.out.println("Esa opción no existe");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        return opcion;
    }

    public static int menuCompras() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Devolver producto");
        System.out.println("2. Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion != 1 && opcion != 2) {
            System.out.println("Esa opción no existe");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        return opcion;
    }

    public static int menu() {
        System.out.println("Bienvenido a nuestra tienda, ¿qué quieres hacer?");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        int opcion;


        do {
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR. No ha introducido un número.");
                scanner.nextLine();  // Limpia el String basura
            }
            System.out.println("ERROR. Introduce un número válido (1-3).");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion != 1 && opcion != 2 && opcion != 3);

        // *MANERA DE HACERLO PARA QUE DÉ ERROR CON OTROS TIPOS DE DATO (EN VEZ DE CRASHEAR)*
//        int opcion;
//
//        do {
//            System.out.println("ERROR. Introduce una opción válida.");
//        } while (!scanner.hasNextInt());
//        opcion = scanner.nextInt();
//        scanner.nextLine();

        return opcion;
    }

    public static Usuario iniciarSesion() {
        while (true) { // bucle principal para reintentos
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();

            for (int i = 0; i < usuarios.size(); i++) {
                if (usuario.equals(usuarios.get(i).getNombre())
                        && contraseña.equals(usuarios.get(i).getContraseña())) {

                    System.out.println("Bienvenido, "
                            + usuarios.get(i).getNombre());
                    return usuarios.get(i);
                }
            }

            System.out.println(
                    "Usuario o contraseña incorrectos. Intenta de nuevo.");
        }
    }

    public static Usuario registrarUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        LocalDate fecha_nacimiento = pedirFechaNacimiento();

        int saldo = pedirSaldo();

        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuario1 = new Usuario(nombre, fecha_nacimiento,
                saldo, contraseña);
        usuarios.add(usuario1);

        System.out.println("Usuario registrado correctamente. Bienvenido, " + usuario1.getNombre());
        return usuario1;

    }

    public static int pedirSaldo() {
        while (true) {
            try {
                System.out.print("Saldo inicial: ");
                int saldo = scanner.nextInt();
                scanner.nextLine();
                while (saldo < 0) { //verifica que no metan un saldo negativo
                    System.out.println(
                            "Esa cantidad no es valida, intentalo otra vez.");
                    System.out.print("Saldo inicial: ");
                    saldo = scanner.nextInt();
                    scanner.nextLine();
                }
                return saldo;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Tienes que escribir un número entero.");
                scanner.nextLine();
            }
        }
    }

    public static LocalDate pedirFechaNacimiento() {
        while (true) {
            try {
                System.out.println("Fecha de nacimiento");
                System.out.print("Año: ");
                int año = scanner.nextInt();
                System.out.print("Mes: ");
                int mes = scanner.nextInt();
                System.out.print("Dia: ");
                int dia = scanner.nextInt();

                return LocalDate.of(año, mes, dia);

            } catch (Exception e) {
                System.out.println("La fecha ingresada no es válida. Intenta de nuevo.");
            } finally {
                scanner.nextLine(); // limpiar buffer
            }
        }

    }

    public static void verCatalogo() {
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + "- " + productos.get(i).getNombre());
        }
    }

    public static void verPerfil(Usuario usuarioActual) {
        System.out.println("Nombre: " + usuarioActual.getNombre());
        System.out.println("Edad: " + usuarioActual.getEdad());
        System.out.println("Saldo: " + usuarioActual.getSaldo());
    }

    public static void consultar() {
        System.out.println("¿Qué producto quieres consultar?");
        int numero = scanner.nextInt();
        Producto productoSeleccionado = null;
        for (int i = 0; i < productos.size(); i++) {
            if (i == (numero - 1)) {
                productoSeleccionado = productos.get(i);
            }
        }

        System.out.println(productoSeleccionado.consultar());
    }

    public static void probar() {
        System.out.println("¿Qué producto deseas probar?");
        int numero = scanner.nextInt();
        Producto productoSeleccionado = null;
        for (int i = 0; i < productos.size(); i++) {
            if (i == (numero - 1)) {
                productoSeleccionado = productos.get(i);
            }
        }

        System.out.println(productoSeleccionado.probar());
    }

    public static void comprar(Usuario usuarioActual) {
        System.out.println("¿Qué producto deseas comprar?");
        int numero = scanner.nextInt();
        Producto productoSeleccionado = null;
        for (int i = 0; i < productos.size(); i++) {
            if (i == (numero - 1)) {
                productoSeleccionado = productos.get(i);
            }
        }

        usuarioActual.comprar(productoSeleccionado);
    }

    public static void añadirSaldo(Usuario usuarioActual) {
        System.out.println("¿Cuánto saldo quieres añadir?");
        int cantidad = scanner.nextInt();
        if (usuarioActual.añadirSaldo(cantidad)) {
            System.out.println("Has añadido " + cantidad + "$");
        } else {
            System.out.println("Esa cantidad no es valida.");
        }
    }

    public static void verCompras(Usuario usuarioActual) {
        for (int i = 0; i < usuarioActual.comprasRealizadas.size(); i++) {
            System.out.println((i + 1) + "- " + usuarioActual.comprasRealizadas.get(i));
        }
    }
}
