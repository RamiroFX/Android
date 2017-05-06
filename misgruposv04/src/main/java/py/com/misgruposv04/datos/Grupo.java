package py.com.misgruposv04.datos;

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

    private static ArrayList<Grupo> grupos = new ArrayList<>();

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
        grupos.add( this );
    }


}
