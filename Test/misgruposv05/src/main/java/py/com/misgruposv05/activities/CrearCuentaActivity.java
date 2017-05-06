package py.com.misgruposv05.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv05.R;
import py.com.misgruposv05.datos.Usuario;

public class CrearCuentaActivity extends AppCompatActivity {

    EditText campoNombreApellido;
    EditText campoNickname;
    EditText campoTelefono;
    EditText campoEmail;
    EditText campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        campoNombreApellido = (EditText) findViewById(R.id.crear_cuenta_nombreapellido);
        campoNickname = (EditText) findViewById(R.id.crear_cuenta_nickname);
        campoTelefono = (EditText) findViewById(R.id.crear_cuenta_telefono);
        campoEmail = (EditText) findViewById(R.id.crear_cuenta_email);
        campoPassword = (EditText) findViewById(R.id.crear_cuenta_password);
    }

    public void crearCuenta(View view) {
        String nombreApellido = campoNombreApellido.getText().toString();
        String nickname = campoNickname.getText().toString();
        String telefono = campoTelefono.getText().toString();
        String email = campoEmail.getText().toString();
        String password = campoPassword.getText().toString();

        Usuario usuario = new Usuario( nickname, nombreApellido, email, password, telefono);
        Usuario.agregarUsuario(usuario);

        Intent intentLanzarLogin = new Intent( this, LoginActivity.class ) ;
        startActivity( intentLanzarLogin );
    }
}
