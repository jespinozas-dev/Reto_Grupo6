package reto_grupo6;

import java.util.ArrayList;

/**
 *
 * @author l.lopez
 */
public class Videojuego extends Producto {
    private String genero;
    private int anio;
    private String empresa;
    private int puntuacion;
    private String plataforma;
    private boolean formato;
    private ArrayList<DLC> DLCs;

    public Videojuego(String nombre, double precio, int unidades, String descripcion, String genero, int anio, String empresa, int puntuacion, String plataforma, boolean formato, ArrayList<DLC> DLCs) {
        super(nombre, precio, unidades, descripcion);
        this.genero = genero;
        this.anio = anio;
        this.empresa = empresa;
        this.puntuacion = puntuacion;
        this.plataforma = plataforma;
        this.formato = formato;
        this.DLCs = new ArrayList<DLC>();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean isFormato() {
        return formato;
    }

    public void setFormato(boolean formato) {
        this.formato = formato;
    }

    public ArrayList<DLC> getDLCs() {
        return DLCs;
    }

    public void addDLCs(DLC dlc) {
        DLCs.add(dlc);
    }

    @Override
    public String consultar() {
        return "\nTítulo: " + super.getNombre() + "\nAño: " + anio + "\nGénero: " + genero + "\nEmpresa desarrolladora: " + empresa + "\nPuntuación " + puntuacion + "\nPlataforma: " + plataforma + "\nVersión física: " + (formato ? "Sí" : "No") + "\nSinopsis: " + super.getDescripcion();
    }

    @Override
    public String probar() {
        return "\nVamos a jugar una demo de " + super.getNombre() + ".";
    }
}
