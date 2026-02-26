package reto_grupo6;

/**
 *
 * @author l.lopez
 */
public class DLC extends Producto {
    private Videojuego videojuego;
    private int anio;

    public DLC(String nombre, double precio, Videojuego videojuego, int anio) {
        super(nombre, precio);
        this.videojuego = videojuego;
        videojuego.addDLCs(this);
        this.anio = anio;
    }

    @Override
    public String consultar() {
        return "\nTítulo: " + videojuego + ":" + super.getNombre() + "\nAño: " + anio + "\nGénero: " + videojuego.getGenero() + "\nEmpresa desarroladora: " + videojuego.getEmpresa() + "\nPuntuación " + videojuego.getPuntuacion();
    }
}
