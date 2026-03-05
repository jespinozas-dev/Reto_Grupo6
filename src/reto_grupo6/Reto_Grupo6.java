/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to
edit this template
 */
package reto_grupo6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author J.ESPINOZA
 */
public class Reto_Grupo6 {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Producto> productos = new ArrayList<>();

    // Listas auxiliares para separar catálogo
    private static ArrayList<Producto> catalogoVideojuegosYDlcs = new ArrayList<>();
    private static ArrayList<Producto> catalogoAccesorios = new ArrayList<>();

    public static void main(String[] args) {
        Usuario usuarioActual = null;
        generarProductos();
        separarCatalogos(); // rellenamos las dos listas auxiliares

        while (true) {
            while (usuarioActual == null) {
                int opcion = menuInicial();
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
            }

            int opcion2 = 0;

            opcion2 = menuPrincipal();
            switch (opcion2) {
                case 1:
                    int opcionCatalogoTipo = menuCatalogoTipo();
                    if (opcionCatalogoTipo == 1) {
                        verCatalogoVideojuegos();
                    } else if (opcionCatalogoTipo == 2) {
                        verCatalogoAccesorios();
                    }

                    int opcion3;

                    do {

                        opcion3 = menuCatalogoAcciones();

                        switch (opcion3) {
                            case 1:
                                consultar(opcionCatalogoTipo);
                                break;

                            case 2:
                                probar(opcionCatalogoTipo);
                                break;

                            case 3:
                                comprar(usuarioActual, opcionCatalogoTipo);
                                break;

                            case 4:
                                break;
                        }

                    } while (opcion3 != 4);
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

                            int opcion5;

                            do {
                                opcion5 = menuCompras();
                                
                                switch (opcion5) {
                                    case 1:
                                        if (usuarioActual.comprasRealizadas.isEmpty()) {
                                            System.out.println("No tienes compras para devolver.");
                                        } else {
                                            devolver(usuarioActual);
                                        }
                                        break;
                                case 2:
                                        break;
                                }

                            } while (opcion5 != 2);

                                break;

                              case 3:
                            break;
                    }
                    
                            break;
                        case 3:
                            usuarioActual = null;
                            break;
                    }
            }
        }

    

    public static int menuPrincipal() {
        while (true) { // <<< TRY-CATCH INICIO
            try {
                System.out.println("\n¿Qué quieres hacer ahora?");
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
            }
        } // <<< TRY-CATCH FIN
    }

    public static int menuCatalogoTipo() {
        while (true) {
            try {
                System.out.println("\n¿Qué catálogo quieres ver?");
                System.out.println("1. Videojuegos y DLC");
                System.out.println("2. Accesorios (mandos, auriculares, almacenamiento)");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                while (opcion != 1 && opcion != 2) {
                    System.out.println("Esa opción no existe.");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }
                return opcion;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    // Acciones sobre el catálogo (antes era menuCatalogo)
    public static int menuCatalogoAcciones() {
        while (true) {
            try {
                System.out.println("\n¿Qué quieres hacer?");
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    public static int menuPerfil() {
        while (true) {
            try {
                System.out.println("\n¿Qué quieres hacer?");
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    public static int menuCompras() {
        while (true) {
            try {
                System.out.println("\n¿Qué quieres hacer?");
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debes ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    public static int menuInicial() {
        while (true) { // <<< TRY-CATCH INICIO
            try {
                System.out.println("\nBienvenido a nuestra tienda, ¿qué quieres hacer?");
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                int opcion;

                do {
                    while (!scanner.hasNextInt()) {
                        System.out.println("ERROR. No ha introducido un número.");
                        scanner.nextLine();  // Limpia el String basura
                    }
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion != 1 && opcion != 2 && opcion != 3) {
                        System.out.println("ERROR. Introduce un número válido (1-3).");
                    }
                } while (opcion != 1 && opcion != 2 && opcion != 3);

                return opcion;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Tienes que ingresar un número entero válido.");
                scanner.nextLine();
            }
        } // <<< TRY-CATCH FIN
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

            System.out.println("Usuario o contraseña incorrectos. Quieres intentarlo otra vez o salir?");
            System.out.println("1. Intentarlo otra vez");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            while (opcion != 1 && opcion != 2) {
                System.out.println("Esa opcion no existe");
                opcion = scanner.nextInt();
            }

            if (opcion == 2) {
                return null;
            }
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

    // Nuevo catálogo solo videojuegos y DLC
    public static void verCatalogoVideojuegos() {
        System.out.println("===== CATALOGO VIDEOJUEGOS Y DLC =====");
        for (int i = 0; i < catalogoVideojuegosYDlcs.size(); i++) {
            Producto p = catalogoVideojuegosYDlcs.get(i);
            System.out.println((i + 1) + "- " + p.getNombre() + " [" + p.getClass().getSimpleName() + "]");
        }
    }

    // Nuevo catálogo solo accesorios
    public static void verCatalogoAccesorios() {
        System.out.println("===== CATALOGO ACCESORIOS =====");
        for (int i = 0; i < catalogoAccesorios.size(); i++) {
            Producto p = catalogoAccesorios.get(i);
            System.out.println((i + 1) + "- " + p.getNombre() + " [" + p.getClass().getSimpleName() + "]");
        }
    }

    public static void verPerfil(Usuario usuarioActual) {
        System.out.println("Nombre: " + usuarioActual.getNombre());
        System.out.println("Edad: " + usuarioActual.getEdad());
        System.out.println("Saldo: " + usuarioActual.getSaldo());
    }

    // Consultar según catálogo elegido (1 videojuegos/DLC, 2 accesorios)
    public static void consultar(int tipoCatalogo) {
        System.out.println("\n¿Qué producto quieres consultar?");
        try { // <<< TRY-CATCH INICIO
            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero < 1 || numero > productos.size()) {
                System.out.println("Producto no existe.");
                return;
            }

            Producto productoSeleccionado = obtenerProductoDeCatalogo(tipoCatalogo, numero);
            System.out.println(productoSeleccionado.consultar());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Debes ingresar un número válido.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("No se pudo consultar el producto (objeto nulo).");
        } // <<< TRY-CATCH FIN
    }

    public static void probar(int tipoCatalogo) {
        System.out.println("¿Qué producto deseas probar?");
        try { // <<< TRY-CATCH INICIO
            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero < 1 || numero > productos.size()) {
                System.out.println("Producto no existe.");
                return;
            }

            Producto productoSeleccionado = obtenerProductoDeCatalogo(tipoCatalogo, numero);

            System.out.println(productoSeleccionado.probar());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Debes ingresar un número válido.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("No se pudo probar el producto (objeto nulo).");
        } // <<< TRY-CATCH FIN
    }

    public static void comprar(Usuario usuarioActual, int tipoCatalogo) {
        System.out.println("\n¿Qué producto deseas comprar?");
        try { // <<< TRY-CATCH INICIO
            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero < 1 || numero > productos.size()) {
                System.out.println("Producto no existe.");
                return;
            }

            Producto productoSeleccionado = obtenerProductoDeCatalogo(tipoCatalogo, numero);
            if (usuarioActual.comprar(productoSeleccionado)) {
                System.out.println("Compraste el " + productoSeleccionado.getNombre());
            } else {
                System.out.println("Hubo un error en la compra");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Debes ingresar un número válido.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("No se pudo completar la compra (objeto nulo).");
        } // <<< TRY-CATCH FIN
    }

    private static Producto obtenerProductoDeCatalogo(int tipoCatalogo, int numero) {
        ArrayList<Producto> lista;
        if (tipoCatalogo == 1) {
            lista = catalogoVideojuegosYDlcs;
        } else {
            lista = catalogoAccesorios;
        }

        int index = numero - 1;
        if (index >= 0 && index < lista.size()) {
            return lista.get(index);
        }
        return null;
    }

    public static void añadirSaldo(Usuario usuarioActual) {

        System.out.println("\n¿Cuánto saldo quieres añadir?");

        try { // <<< TRY-CATCH INICIO
            double cantidad = scanner.nextInt();
            scanner.nextLine();

            if (usuarioActual.añadirSaldo(cantidad)) {
                System.out.println("Has añadido " + cantidad + "$");
            } else {
                System.out.println("Esa cantidad no es valida");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Debes ingresar un número válido.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("No se pudo añadir saldo (usuario nulo).");
        } // <<< TRY-CATCH FIN
    }

    public static void verCompras(Usuario usuarioActual) {
        for (int i = 0; i < usuarioActual.comprasRealizadas.size(); i++) {
            System.out.println((i + 1) + "- " + usuarioActual.comprasRealizadas.get(i).getNombre());
        }
    }

    public static void devolver(Usuario usuario) {
        Producto productoSeleccionado;
        System.out.println("¿Que producto quieres devolver?");

        try {
            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero < 1 || numero > usuario.comprasRealizadas.size()) {
                System.out.println("Ese producto no existe");
                return;
            }

            productoSeleccionado = usuario.comprasRealizadas.get(numero - 1);

            usuario.devolver(productoSeleccionado);
            System.out.println("Devolviste el producto exitosamente");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Debes ingresar un número válido.");
            scanner.nextLine();
        } catch (NullPointerException e) {
            System.out.println("No se pudo devolver el producto (objeto nulo).");
        }

    }

    private static void generarProductos() {
        Random rand = new Random();

        // Más variedad de videojuegos
        String[] videojuegosBase = {
            "The Legend of Zelda: Tears of the Kingdom",
            "Elden Ring",
            "God of War: Ragnarök",
            "Hogwarts Legacy",
            "Cyberpunk 2077",
            "Marvel's Spider-Man 2",
            "Assassin’s Creed Mirage",
            "EA Sports FC 24",
            "Minecraft",
            "Fortnite",
            "Call of Duty: Modern Warfare III",
            "The Witcher 3: Wild Hunt",
            "Super Mario Bros. Wonder",
            "Starfield",
            "GTA V",
            "Red Dead Redemption 2",
            "Resident Evil 4 Remake",
            "Overwatch 2",
            "Baldur’s Gate 3",
            "Animal Crossing: New Horizons",
            "Hades II",
            "Sekiro: Shadows Die Twice",
            "Dark Souls III",
            "Monster Hunter: World",
            "League of Legends",
            "Valorant",
            "Apex Legends",
            "Diablo IV",
            "Metroid Dread",
            "Splatoon 3"
        };

        String[] generos = {"Acción", "Aventura", "RPG", "Shooter", "Deportes", "Simulación", "Lucha", "Estrategia"};
        String[] plataformas = {"PlayStation 5", "Xbox Series X", "Nintendo Switch", "PC"};
        String[] empresas = {"Nintendo", "Sony", "Microsoft", "Ubisoft", "EA", "Bandai Namco", "Rockstar Games", "CD Projekt Red", "FromSoftware", "Blizzard"};
        String[] marcas = {"Sony", "Microsoft", "Nintendo", "Logitech", "Seagate", "Razer", "Corsair", "SteelSeries", "HyperX"};
        String[] colores = {"Negro", "Blanco", "Rojo", "Azul", "Plata", "Verde", "Morado"};

        // 1️⃣ Generar 25 videojuegos (no 60) para menos repetición y más variedad
        for (int i = 0; i < 25; i++) {
            String base = videojuegosBase[rand.nextInt(videojuegosBase.length)];
            double precio = 29.99 + rand.nextInt(51); // 29–79 €
            int unidades = 5 + rand.nextInt(21);
            String descripcion = "Edición para " + plataformas[rand.nextInt(plataformas.length)] + " del juego " + base + ".";
            String genero = generos[rand.nextInt(generos.length)];
            int anio = 2014 + rand.nextInt(13);
            String empresa = empresas[rand.nextInt(empresas.length)];
            int puntuacion = 60 + rand.nextInt(41);
            String plataforma = plataformas[rand.nextInt(plataformas.length)];
            boolean formato = rand.nextBoolean();

            Videojuego v = new Videojuego(base, precio, unidades, descripcion, genero, anio, empresa, puntuacion, plataforma, formato, new ArrayList<>());
            productos.add(v);

            // Agregar algunos DLCs asociados con nombres más reales/creativos
            int numDlcs = rand.nextInt(3); // 0, 1 o 2
            for (int j = 0; j < numDlcs; j++) {
                String dlcNombre = nombreDLC(base, j);
                DLC d = new DLC(
                        dlcNombre,
                        4.99 + rand.nextInt(11),
                        "Contenido adicional para " + base,
                        v,
                        anio + 1
                );
                productos.add(d);
            }
        }

        // 2️⃣ Generar 10 mandos reales
        String[] consolas = {"PS5", "Xbox Series X", "Nintendo Switch", "PC"};
        for (int i = 0; i < 10; i++) {
            String marca = marcas[rand.nextInt(marcas.length)];
            String consola = consolas[rand.nextInt(consolas.length)];
            String nombre = "Mando " + marca + " " + consola;
            int precio = 40 + rand.nextInt(41);
            int unidades = 4 + rand.nextInt(11);
            String color = colores[rand.nextInt(colores.length)];
            String descripcion = "Mando ergonómico " + marca + " para " + consola + " color " + color + ".";

            productos.add(new Mando(nombre, precio, unidades, descripcion, marca, color, consola));
        }

        // 3️⃣ Generar 10 auriculares
        for (int i = 0; i < 10; i++) {
            String marca = marcas[rand.nextInt(marcas.length)];
            String nombre = "Auriculares " + marca + " Gaming";
            int precio = 30 + rand.nextInt(71);
            int unidades = 3 + rand.nextInt(13);
            String descripcion = "Auriculares de calidad con sonido envolvente 7.1 para gaming.";
            String color = colores[rand.nextInt(colores.length)];
            boolean microfono = rand.nextBoolean();

            productos.add(new Auriculares(nombre, precio, unidades, descripcion, marca, color, microfono));
        }

        // 4️⃣ Generar 10 unidades de almacenamiento
        int[] capacidadesPosibles = {500, 1000, 2000, 4000};
        for (int i = 0; i < 10; i++) {
            String marca = marcas[rand.nextInt(marcas.length)];
            String nombre = "SSD " + marca + " Gaming";
            int precio = 50 + rand.nextInt(101);
            int unidades = 3 + rand.nextInt(8);
            String descripcion = "Unidad SSD externa de alta velocidad para consola o PC.";
            String color = colores[rand.nextInt(colores.length)];
            int capacidad = capacidadesPosibles[rand.nextInt(capacidadesPosibles.length)];

            productos.add(new Almacenamiento(nombre, precio, unidades, descripcion, marca, color, capacidad));
        }
    }

    private static String nombreDLC(String juego, int numero) {
        if (juego.contains("Elden Ring")) {
            String[] eldenDlcs = {"Shadow of the Erdtree", "Eternal Ashes", "Thorned Realm"};
            return "Elden Ring: " + eldenDlcs[Math.min(numero, eldenDlcs.length - 1)];
        } else if (juego.contains("Witcher 3")) {
            String[] w3Dlcs = {"Hearts of Stone", "Blood and Wine", "Path of the Wolf"};
            return "The Witcher 3: " + w3Dlcs[Math.min(numero, w3Dlcs.length - 1)];
        } else if (juego.toLowerCase().contains("cyberpunk")) {
            String[] cpDlcs = {"Phantom Liberty", "Neon Nights", "Chrome Dreams"};
            return "Cyberpunk 2077: " + cpDlcs[Math.min(numero, cpDlcs.length - 1)];
        } else if (juego.contains("Minecraft")) {
            String[] mcDlcs = {"Cueva Abisal Pack", "Nether Explorers", "Ender Expansion"};
            return "Minecraft: " + mcDlcs[Math.min(numero, mcDlcs.length - 1)];
        } else if (juego.contains("GTA V") || juego.contains("GTA")) {
            String[] gtaDlcs = {"Nightlife City", "Heists Pack", "Los Santos Stories"};
            return "GTA V: " + gtaDlcs[Math.min(numero, gtaDlcs.length - 1)];
        } else if (juego.contains("Fortnite")) {
            String[] fnDlcs = {"Battle Pass Legends", "Cosmic Skins Pack", "Victory Royale Bundle"};
            return "Fortnite: " + fnDlcs[Math.min(numero, fnDlcs.length - 1)];
        } else {
            String[] genericos = {"Expansion Pack", "Season Pass", "Ultimate Content"};
            return juego.substring(0, Math.min(25, juego.length())) + ": " + genericos[numero % genericos.length];
        }
    }

    // Rellena las listas auxiliares de catálogo
    private static void separarCatalogos() {
        catalogoVideojuegosYDlcs.clear();
        catalogoAccesorios.clear();

        for (Producto p : productos) {
            if (p instanceof Videojuego || p instanceof DLC) {
                catalogoVideojuegosYDlcs.add(p);
            } else if (p instanceof Accesorio) {
                catalogoAccesorios.add(p);
            }
        }
    }

}
