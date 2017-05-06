package misgruposv04.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import py.com.misgruposv05.R;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void lanzarCrearCuenta(View view) {
        Intent intentCrearCuenta = new Intent( this, CrearCuentaActivity.class );
        startActivity( intentCrearCuenta );
    }

    public void lanzarLogin(View view) {
        Intent intentLogin = new Intent( this, LoginActivity.class );
        startActivity( intentLogin );
    }
}
