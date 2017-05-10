package py.com.misgruposv06.activities;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import py.com.misgruposv06.R;
import py.com.misgruposv06.datos.Usuario;

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

        if ( email.equals("") || password.equals("") ) {
            desplegarMensajeUsuarioPasswordNoIngresado();

        } else {
            boolean estaComprobado = Usuario.comprobarCredenciales(email, password);

            if (estaComprobado) {
                Log.i(TAG, "Credenciales correctas");
                setUsuarioLogueado();
                Intent intentMenuPricipal = new Intent( this, MenuPrincipalActivity.class );
                startActivity( intentMenuPricipal );
            } else {
                Log.i(TAG, "Las credenciales son incorrectas");

                desplegarMensajeCredencialesIncorrectas();
                notificar();
            }
        }

    }

    void notificar() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Credencial Incorrecta")
                        .setContentText("Click aqui para crear cuenta!!!");
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, CrearCuentaActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack( CrearCuentaActivity.class );
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, mBuilder.build());
    }

    public void desplegarMensajeCredencialesIncorrectas() {
//        Toast toast = Toast.makeText( this, "Credenciales incorrectas", Toast.LENGTH_SHORT);
//        toast.show();

        Snackbar
                .make( (View) findViewById( R.id.linearLayout1 ), "Credenciales incorrectas", Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();



    }

    public void desplegarMensajeUsuarioPasswordNoIngresado() {
        new UsuarioPasswordDialogFragment().show( getSupportFragmentManager(), TAG);
    }

    private void setUsuarioLogueado() {
        String email = campoNombreUsuario.getText().toString();
        Usuario.setUsuarioLogueado( Usuario.getUsuario( email ));
    }

    public static class UsuarioPasswordDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("Mensaje de Login")
                    .setMessage( "Debe ingresar usuario y contraseña")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    }) ;

            return builder.create();
        }
    }


}
