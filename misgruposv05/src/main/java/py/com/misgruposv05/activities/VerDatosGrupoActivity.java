package py.com.misgruposv05.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import py.com.misgruposv05.R;
import py.com.misgruposv05.datos.Grupo;
import py.com.misgruposv05.utils.LogUtils;

public class VerDatosGrupoActivity extends AppCompatActivity {
    private int idGrupo = 0;
    private Grupo unGrupo;
    private TextView nombre;
    private TextView objetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LogUtils.tag, "Inicia metodo en VerDatosGrupoActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_grupo);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idGrupo = extras.getInt("idGrupo", -1);
            Log.d(LogUtils.tag, "Id recibido del grupo: "+idGrupo);
        }

        actualizarVista();
    }

    public void actualizarVista(){

        // TODO controlar que el idGrupo ingresado este en el rango de grupos creados hasta el momento


        unGrupo = Grupo.grupos.get( idGrupo );

        nombre = (TextView) findViewById(R.id.id_nombre_grupo_valor);
        nombre.setText(unGrupo.getNombre());

        objetivo = (TextView) findViewById(R.id.id_objetivo_grupo_valor);
        objetivo.setText(unGrupo.getDescripcion());

    }

    // TODO crear metodo onCreateOptionsMenu

    // TODO crear metodo onOptionsItemSelected

    // TODO crear metodo para lanzar la actividad

    // TODO crear metodo onActivityResult
}
