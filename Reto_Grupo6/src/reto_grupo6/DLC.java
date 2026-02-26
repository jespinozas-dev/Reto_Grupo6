package reto_grupo6;

import java.util.ArrayList;

/**
 *
 * @author l.lopez
 */
public class DLC extends Videojuego {
    private String nombreDLC;

    public DLC(String nombre, double precio, int unidades, String genero, int anio, String empresa, int puntuacion, boolean formato, ArrayList<DLC> DLCs, String nombreDLC) {
        super(nombre, precio, unidades, genero, anio, empresa, puntuacion, formato, DLCs);
        this.nombreDLC = nombreDLC;
    }

    @Override
    public String consultar() {
        return "\nTítulo: " + super.getNombre() + ":" + nombreDLC + "\nAño: " + super.getAnio() + "\nGénero: " + super.getGenero() + "\nEmpresa desarroladora: " + super.getEmpresa() + "\nPuntuación " + super.getPuntuacion() + "\nVersión física: " + (super.isFormato() ? "Sí" : "No");
    }
}
