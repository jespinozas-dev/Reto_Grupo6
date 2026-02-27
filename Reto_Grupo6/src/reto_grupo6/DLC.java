package reto_grupo6;

/**
 *
 * @author l.lopez
 */
public class DLC extends Producto {
    private Videojuego videojuego;
    private int anio;

    public DLC(String nombre, double precio, String descripcion, Videojuego videojuego, int anio) {
        super(nombre, precio, descripcion);
        this.videojuego = videojuego;
        videojuego.addDLCs(this);
        this.anio = anio;
    }

    @Override
    public String consultar() {
        return "\nTítulo: " + videojuego + ":" + super.getNombre() + "\nAño: " + anio + "\nGénero: " + videojuego.getGenero() + "\nEmpresa desarrolladora: " + videojuego.getEmpresa() + "\nPuntuación " + videojuego.getPuntuacion() + "\nPlataforma: " + videojuego.getPlataforma() + "\nSinopsis " + super.getDescripcion();
    }

    @Override
    public String probar() {
        return "Vamos a probar el nuevo material de " + super.getNombre() + ", llamado \"" + videojuego.getNombre() + "\"";
    }
}
