package py.com.misgruposv04.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv04.datos.Grupo;
import py.com.misgruposv04.datos.Usuario;
import py.com.misgruposv04.R;

public class CrearGrupoActivity extends AppCompatActivity {
    private static final String TAG = "CrearGrupoActivity";
    private EditText campoNombre;
    private EditText campoObjetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_grupo);

        campoNombre = (EditText) findViewById( R.id.creacion_nombre_grupo );
        campoObjetivo = (EditText) findViewById( R.id.creacion_objetivo_encuentro );
    }

    public void crearGrupo(View view) {
        Grupo grupo = new Grupo(campoNombre.getText().toString(),
                campoObjetivo.getText().toString(), 0, 0, Usuario.getUsuarioLogueado() );
        Log.i(TAG, "Se creó el grupo ");

    }
}
