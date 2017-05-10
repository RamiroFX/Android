package py.com.misgruposv06.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import py.com.misgruposv06.R;
import py.com.misgruposv06.datos.Grupo;
import py.com.misgruposv06.utils.LogUtils;
import py.com.misgruposv06.utils.RequestCode;

public class VerDatosGrupoActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosGrupoActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idGrupo = -1;
    private Grupo unGrupo;
    private TextView nombre;
    private TextView objetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosGrupoActivity.onCreate");
        setContentView(R.layout.activity_ver_datos_grupo);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idGrupo = extras.getInt("idGrupo", -1);
            Log.i(LogUtils.tag, "Id recibido del grupo: "+idGrupo);
        }

        actualizarVista();
    }

    public void actualizarVista(){
        if ( idGrupo < 0 || idGrupo > (Grupo.grupos.size()-1) ) {
            desplegarMensajeNoExisteGrupo();
            finish();
            return;
        }

        unGrupo = Grupo.grupos.get( idGrupo );

        nombre = (TextView) findViewById(R.id.id_nombre_grupo_valor);
        nombre.setText( unGrupo.getNombre() );

        objetivo = (TextView) findViewById(R.id.id_objetivo_grupo_valor);
        objetivo.setText(unGrupo.getDescripcion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.ver_grupo_menu , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId() ) {
            case R.id.editar_grupo:
                lanzarActividadEdicionGrupo();
                break;
            case R.id.eliminar_grupo:
                Grupo.grupos.remove( idGrupo );
                desplegarMensajeEliminacionGrupo();
                finish();
        }
        return true;
    }

    private void lanzarActividadEdicionGrupo() {
        Intent i = new Intent( this, CrearGrupoActivity.class );
        i.putExtra("idGrupo", idGrupo );
        startActivityForResult( i, RequestCode.PETICION_EDITAR_GRUPO.getCodigo());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dato) {
        if (requestCode == RequestCode.PETICION_EDITAR_GRUPO.getCodigo()) {
            if (resultCode == RESULT_OK) {
                Bundle extras = dato.getExtras();
                int resultado = extras.getInt("resultado", -1);
                if ( resultado == 1) {
                    desplegarMensajeEdicioGrupoExitoso();
                    actualizarVista();
                }
            }
        }
    }

    public void desplegarMensajeEliminacionGrupo() {
        Toast toast = Toast.makeText( this, "El grupo fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioGrupoExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del grupo fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteGrupo() {
        Toast toast = Toast.makeText( this, "El grupo no existe", Toast.LENGTH_SHORT);
        toast.show();
    }
}
