package py.com.misgruposv05.datos;

import java.util.ArrayList;
import java.util.Date;

public class Grupo {
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Usuario creador;
    private double ubicacionLatitud;
    private double ubicacionLongitud;
    private ArrayList<Usuario> usuariosIntegrantes;

    public static ArrayList<Grupo> grupos = new ArrayList<>();

    static {
        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
        grupos.add( new Grupo("Estudiantes IDT", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
    }

    public Grupo(String nombre, String descripcion, double ubicacionLatitud,
                 double ubicacionLongitud, Usuario creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = new Date();
        this.ubicacionLatitud = ubicacionLatitud;
        this.ubicacionLongitud = ubicacionLongitud;
        this.creador = creador;
        usuariosIntegrantes = new ArrayList<>();
        usuariosIntegrantes.add( creador );
    }

    public static void agregarGrupo( Grupo unGrupo ) {
        grupos.add( unGrupo );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public double getUbicacionLatitud() {
        return ubicacionLatitud;
    }

    public void setUbicacionLatitud(double ubicacionLatitud) {
        this.ubicacionLatitud = ubicacionLatitud;
    }

    public double getUbicacionLongitud() {
        return ubicacionLongitud;
    }

    public void setUbicacionLongitud(double ubicacionLongitud) {
        this.ubicacionLongitud = ubicacionLongitud;
    }
}
