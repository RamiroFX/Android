package py.com.misgruposv06.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv06.R;
import py.com.misgruposv06.utils.LogUtils;
import py.com.misgruposv06.utils.RequestCode;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void lanzarVistaAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarCreacionGrupo(View view) {
        Intent intentCreacionGrupo = new Intent( this, CrearGrupoActivity.class);
        //startActivity( intentCreacionGrupo );
        startActivityForResult(intentCreacionGrupo, RequestCode.ACT_LANZADA_CREAR_GRUPO.getCodigo());
    }

    public void lanzarVerDatosGrupos(View view) {
        final EditText entrada = new EditText(this);
        entrada.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Selección de grupo")
                .setMessage("Indica su id:")
                .setView(entrada)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        int id = Integer.parseInt( entrada.getText().toString());
                        Intent i = new Intent( MenuPrincipalActivity.this, VerDatosGrupoActivity.class);
                        i.putExtra("idGrupo", id);
                        startActivity( i );
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RequestCode.ACT_LANZADA_CREAR_GRUPO.getCodigo() && resultCode == Activity.RESULT_OK){
            int res = data.getExtras().getInt("resultado");
            Log.i(LogUtils.tag, "Resultado:" + res);
        }
    }
}
