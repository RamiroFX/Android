package py.com.misgruposv04.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import py.com.misgruposv04.R;

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
        startActivity( intentCreacionGrupo );
    }
}
