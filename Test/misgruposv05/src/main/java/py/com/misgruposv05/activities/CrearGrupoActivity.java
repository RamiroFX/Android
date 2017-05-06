package py.com.misgruposv05.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv05.R;
import py.com.misgruposv05.datos.Grupo;
import py.com.misgruposv05.datos.Usuario;

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

        // TODO verificar si se lanzó la actividad para edición, setear campos de acuerdo a valores del grupo

    }

    public void crearGrupo(View view) {

        // TODO verificar que todos los campos se hayan completado

        // TODO incluir lógica de modo creación o edición

        Grupo grupo = new Grupo(campoNombre.getText().toString(),
                campoObjetivo.getText().toString(), 0, 0, Usuario.getUsuarioLogueado() );
        Grupo.agregarGrupo( grupo );
        Log.i(TAG, "Se creó el grupo ");

        Intent intent = new Intent();
        intent.putExtra("resultado", 10);
        setResult(RESULT_OK, intent);
        finish();

    }
}
