package co.macrosystem.cobranzasmoviles;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtUser;
    private TextInputEditText txtPassw;
    private TextInputLayout txtInputUser;
    private TextInputLayout txtInputPassw;
    private Toolbar toolbar;

    AlertDialog alert = null;
    Location location;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Version 1.0");
        setSupportActionBar(toolbar);

        txtUser = (TextInputEditText) findViewById(R.id.editTextUser);
        txtPassw = (TextInputEditText) findViewById(R.id.editTextPassword);
        txtInputUser = (TextInputLayout) findViewById(R.id.text_input_layout_user);
        txtInputPassw = (TextInputLayout) findViewById(R.id.text_input_layout_pass);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            AlertNoGps();
        }

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            } else {
                locationManager.removeUpdates(locationListener);
            }
        } else {
            locationManager.removeUpdates(locationListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            } else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        }



    }

    public void validar(View view) {

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
         * si ambos capos se encuentran con datos se debe ejecutar el siguiente codigo.
         * el cual debe validar en base de datos local o remota las credenciales y
         * posteriormente visualizar la actividad segun su rol.
         */
        if (!TextUtils.isEmpty(txtUser.getText()) && !TextUtils.isEmpty(txtPassw.getText())){
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

    /**
     * funcion que valida el formato del email
     * retorna false si el formato no es correcto
     *
     * @param email
     * @return
     */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }






}
