package py.com.misgruposv05.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv05.R;
import py.com.misgruposv05.datos.Usuario;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText campoNombreUsuario;
    private EditText campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Inicia la creacion de la ctividad");
        setContentView(R.layout.activity_login);

        campoNombreUsuario = (EditText) findViewById( R.id.nombre_usuario );
        campoPassword = (EditText) findViewById( R.id.contrasenha );
    }

    public void iniciarSesion(View view) {
        String email = campoNombreUsuario.getText().toString();
        String password = campoPassword.getText().toString();

        boolean estaComprobado = Usuario.comprobarCredenciales(email, password);

        if (estaComprobado) {
            Log.i(TAG, "Credenciales correctas");
            setUsuarioLogueado();
            Intent intentMenuPricipal = new Intent( this, MenuPrincipalActivity.class );
            startActivity( intentMenuPricipal );
        } else {
            Log.i(TAG, "Las credenciales son incorrectas");
            desplegarMensajeCredencialesIncorrectas();
        }

    }

    public void desplegarMensajeCredencialesIncorrectas() {

    }

    private void setUsuarioLogueado() {
        String email = campoNombreUsuario.getText().toString();
        Usuario.setUsuarioLogueado( Usuario.getUsuario( email ));
    }


}
