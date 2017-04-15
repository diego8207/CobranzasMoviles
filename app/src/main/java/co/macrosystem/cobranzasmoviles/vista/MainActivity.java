package co.macrosystem.cobranzasmoviles.vista;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.macrosystem.cobranzasmoviles.R;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText txtUser;
    private TextInputEditText txtPassw;
    private TextInputLayout txtInputUser;
    private TextInputLayout txtInputPassw;
    private Toolbar toolbar;
    private Button btnEntrar;

    AlertDialog alert = null;
    Location location;
    LocationManager locationManager;
    LocationListener locationListener;

    private SharedPreferences datos_compartidos;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos la barra superior
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.logo_cobranzas_title);
        setSupportActionBar(toolbar);

        //Asignamos los objetos a las variables locales
        txtUser = (TextInputEditText) findViewById(R.id.editTextUser);
        txtPassw = (TextInputEditText) findViewById(R.id.editTextPassword);
        txtInputUser = (TextInputLayout) findViewById(R.id.text_input_layout_user);
        txtInputPassw = (TextInputLayout) findViewById(R.id.text_input_layout_pass);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        //Validamos si hay GPS activo
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            AlertNoGps();
        }

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });

    }

    private void AlertNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("El sistema GPS esta desactivado, ¡activelo por favor!")
                .setCancelable(false)
                .setPositiveButton("Activar GPS", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                });

        alert = builder.create();
        alert.show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(alert != null)
        {
            alert.dismiss ();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void validar() {

        /**
         * Valido si los campos estan sin digitar y en caso de que no mostrar mensaje de error obligatorio
         */
        String userError = null;
        String passError = null;
        /**
         * Si el campo mail esta vacio se muestra el error obligatorio de lo
         * contrario se hace la validacion del formato del email
         * si no corresponde muestra el error formato formatoMail
         */
        if (TextUtils.isEmpty(txtUser.getText())) {
            userError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtPassw.getText())) {
            passError = getString(R.string.obligatorio);
        }

        /**
         * si ambos campos se encuentran con datos se debe ejecutar el siguiente codigo.
         * el cual debe validar en base de datos local o remota las credenciales y
         * posteriormente visualizar la actividad segun su rol.
         */
        if (!TextUtils.isEmpty(txtUser.getText()) && !TextUtils.isEmpty(txtPassw.getText())){

            /**
             * Hacemos uso de SharePreferences para el nombre de usuario el cual nos va a servir para poder sincronizar
             * las suspensiones de este usuario.
             */

            datos_compartidos = getSharedPreferences("usuarioCompartido", 0);
            editor = datos_compartidos.edit();
            editor.putString("usuario", txtUser.getText().toString());
            editor.commit();
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        }

        /**
         * envio informacion a la uncion toogleTextInputLayoutError para
         * que se valide si se muestra el error en casi de haberlo.
         */
        toggleTextInputLayoutError(txtInputUser, userError);
        toggleTextInputLayoutError(txtInputPassw, passError);

        /*
        eliminacion del foco actual
         */
        clearFocus();
    }

    private void clearFocus() {
        View view = this.getCurrentFocus();
        if (view != null && view instanceof EditText) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus();
        }
    }

    /**
     * Muestra u oculta el mensaje de error dependiendo si el campo estuvo vacio o no en
     * este caso con el parametro msg
     *
     * @param textInputLayout
     * @param msg
     */
    private void toggleTextInputLayoutError(@NonNull TextInputLayout textInputLayout, String msg) {
        textInputLayout.setError(msg);
        if (msg == null) {
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setErrorEnabled(true);
        }
    }






}