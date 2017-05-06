package py.com.misgruposv05.datos;

import java.util.ArrayList;

public class Usuario {
    private String nickname;
    private String nombreApellido;
    private String mail;
    private String password;
    private String telefono;
    private ArrayList<Contacto> contactos;

    private static Usuario usuarioLogueado;
    private static ArrayList<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>();
        usuarios.add( new Usuario("batman", "Bruce Wine", "batman@ciudadgotica.com", "batman", "0900123123"));
    }

    public Usuario(String nickname, String nombreApellido, String mail, String password,
                   String telefono) {
        this.nickname = nickname;
        this.nombreApellido = nombreApellido;
        this.mail = mail;
        this.password = password;
        this.telefono = telefono;
        contactos = new ArrayList<>();
    }

    public void agregarContato(Contacto contacto) {
        contactos.add( contacto );
    }


    public static void agregarUsuario(Usuario usuario) {
        usuarios.add( usuario );
    }

    public static boolean comprobarCredenciales(String email, String password) {

        for( Usuario usuario : usuarios) {
            if ( email.equals(usuario.getMail()) && password.equals(usuario.getPassword())){
                return true;
            }
        }
        return false;
    }

    public static void setUsuarioLogueado(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static Usuario getUsuario( String email ) {
        for( Usuario usuario : usuarios) {
            if ( email.equals(usuario.getMail()) ){
                return usuario;
            }
        }
        // TODO se podria lanzar una excepcion al no encontrar el usuairo
        return null;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
