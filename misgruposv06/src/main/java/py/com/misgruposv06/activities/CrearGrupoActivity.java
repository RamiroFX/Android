package py.com.misgruposv06.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import py.com.misgruposv06.R;
import py.com.misgruposv06.datos.Grupo;
import py.com.misgruposv06.datos.Usuario;

public class CrearGrupoActivity extends AppCompatActivity {
    private static final String TAG = "CrearGrupoActivity";
    private EditText campoNombre;
    private EditText campoObjetivo;
    private Button boton;

    private int idGrupo = -1;
    private boolean modoEdicion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_grupo);

        campoNombre = (EditText) findViewById( R.id.creacion_nombre_grupo );
        campoObjetivo = (EditText) findViewById( R.id.creacion_objetivo_encuentro );
        boton = (Button) findViewById( R.id.boton_crear_grupo );

        // Verificamos si nos llamaron para editar algun grupo
        Bundle extras = getIntent().getExtras();
        if ( extras != null ) {
            idGrupo = extras.getInt( "idGrupo", -1 );
            if ( idGrupo != -1 ) {
                modoEdicion = true;
                campoNombre.setText( Grupo.grupos.get( idGrupo ).getNombre() );
                campoObjetivo.setText( Grupo.grupos.get( idGrupo ).getDescripcion() );
                boton.setText( "Editar Grupo" );
            }
        }
    }

    public void crearGrupo(View view) {

        String nombre = campoNombre.getText().toString();
        String objetivo = campoObjetivo.getText().toString();

        if ( nombre.equals("") || objetivo.equals("") ) {
            desplegarMensajeCamposRequeridos();
        } else {
            if ( modoEdicion ) {
                Grupo grupo = Grupo.grupos.get( idGrupo );
                grupo.setNombre( nombre );
                grupo.setDescripcion( objetivo );

                Intent intent = new Intent();
                intent.putExtra("resultado", 1);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Grupo grupo = new Grupo( nombre, objetivo , 0, 0, Usuario.getUsuarioLogueado() );
                Grupo.agregarGrupo( grupo );
                desplegarMensajeResgistroExitoso();

                Intent intent = new Intent();
                intent.putExtra("resultado", 10);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText( this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText( this, "Registro exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }
}
