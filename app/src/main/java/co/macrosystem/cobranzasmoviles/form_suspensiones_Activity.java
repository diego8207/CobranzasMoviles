package co.macrosystem.cobranzasmoviles;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import co.macrosystem.cobranzasmoviles.pojo.Suspension;

public class form_suspensiones_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private Suspension suspension;
    private TextView txtProceso;
    private TextView txtMedidor;
    private TextView txtSuscriptor;
    private TextView txtCiclo;
    private TextView txtMunicipio;
    private TextView txtDireccion;
    private TextView txtfecha_actividad;
    private TextView txtTipoActividad;
    private TextView txtCodcAccion;
    private TextView txtDescAccion;
    private TextView txtCodTecnico;
    private TextView txtGlosa;
    private TextView txtProveedor;

    private TextInputLayout til_sticker;
    private TextInputEditText txtSticker;
    private TextInputLayout til_sello_serial;
    private TextInputEditText txtSelloSerial;
    private TextInputLayout til_lectura;
    private TextInputEditText txtLectura;
    private TextInputLayout til_nom_contacto;
    private TextInputEditText txtNom_contacto;
    private TextInputLayout til_tel_fijo;
    private TextInputEditText txtTel_fijo;
    private TextInputLayout til_tel_celular;
    private TextInputEditText txtTel_celular;
    private TextInputLayout til_Observacion;
    private TextInputEditText txtObservaciones;

    String[] SPNR_ESTADO_SELLO = {"Roto", "No instalado", "Sin diligenciar", "No reportado", "Conforme"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_suspensiones);

        suspension = getIntent().getParcelableExtra("objSuspension");
        Toolbar toolbarCard = (Toolbar) findViewById(R.id.toolbarCardFormSuspensiones);
        toolbarCard.setTitle("Matricula: " + suspension.getSUSP_MATRICULA());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        txtProceso = (TextView) findViewById(R.id.txtProceso);
        txtMedidor = (TextView) findViewById(R.id.txtMedidor);
        txtSuscriptor = (TextView) findViewById(R.id.txtSuscriptor);
        txtCiclo = (TextView) findViewById(R.id.txtCiclo);
        txtMunicipio = (TextView) findViewById(R.id.txtMunicipio);
        txtDireccion = (TextView) findViewById(R.id.txtDireccion);
        txtfecha_actividad = (TextView) findViewById(R.id.txtfecha_actividad);
        txtTipoActividad = (TextView) findViewById(R.id.txtTipoActividad);
        txtCodcAccion = (TextView) findViewById(R.id.txtCodAccion);
        txtDescAccion = (TextView) findViewById(R.id.txtDescAccion);
        txtCodTecnico = (TextView) findViewById(R.id.txtCodTecnico);
        txtGlosa = (TextView) findViewById(R.id.txtGlosa);
        txtProveedor = (TextView) findViewById(R.id.txtProveedor);

        txtSticker = (TextInputEditText) findViewById(R.id.txtSticker);
        til_sticker = (TextInputLayout) findViewById(R.id.til_sticker);
        txtSelloSerial = (TextInputEditText) findViewById(R.id.txtSelloSerial);
        til_sello_serial = (TextInputLayout) findViewById(R.id.til_sello_serial);
        til_lectura = (TextInputLayout) findViewById(R.id.til_lectura);
        txtLectura = (TextInputEditText) findViewById(R.id.txtLectura);
        til_nom_contacto = (TextInputLayout) findViewById(R.id.til_nom_contacto);
        txtNom_contacto = (TextInputEditText) findViewById(R.id.txtNom_contacto);
        til_tel_fijo = (TextInputLayout) findViewById(R.id.til_tel_fijo);
        txtTel_fijo = (TextInputEditText) findViewById(R.id.txtTel_fijo);
        til_tel_celular = (TextInputLayout) findViewById(R.id.til_tel_celular);
        txtTel_celular = (TextInputEditText) findViewById(R.id.txtTel_celular);
        til_Observacion = (TextInputLayout) findViewById(R.id.til_Observacion);
        txtObservaciones = (TextInputEditText) findViewById(R.id.txtObservaciones);


        txtProceso.setText(suspension.getSUSP_NUM_PROCESO());
        txtMedidor.setText(suspension.getSUSP_NUM_MEDIDOR());
        txtSuscriptor.setText(suspension.getSUSP_SUSCRIPTOR());
        txtCiclo.setText(suspension.getSUSP_CICLO());
        txtMunicipio.setText(suspension.getSUSP_MUNICIPIO());
        txtDireccion.setText(suspension.getSUSP_DIRECCION());
        txtfecha_actividad.setText(suspension.getSUSP_FECHA_ACTI());
        txtTipoActividad.setText(suspension.getSUSP_TIPO_ACTI());
        txtCodcAccion.setText(suspension.getSUSP_COD_ACCION());
        txtDescAccion.setText(suspension.getSUSP_DESCR_ACCION());
        txtCodTecnico.setText(suspension.getSUSP_COD_TECNICO());
        txtGlosa.setText(suspension.getSUSP_GLOSA());
        txtProveedor.setText(suspension.getSUSP_PROVEEDOR());

        Log.e(null, "MATRICULA: " + suspension.getSUSP_MATRICULA());
        Log.e(null, "Datos almacenados en esta suspension: ");

        ArrayAdapter<String> arrayAdapterSello = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, SPNR_ESTADO_SELLO);
        MaterialBetterSpinner materialDesignSpinnerSello = (MaterialBetterSpinner) findViewById(R.id.spnr_estado_sello);
        materialDesignSpinnerSello.setAdapter(arrayAdapterSello);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public void validar(View view) {
        String stickerError = null;
        String estadoStikerError = null;
        String selloSerialError = null;
        String estadoSelloError = null;
        String matriculaMedidorError = null;
        String matriculaPagoError = null;
        String energiaError = null;
        String lecturaError = null;
        String contactoError = null;
        String telFijoError = null;
        String TelCelularError = null;
        String observacionesError = null;
        String rechazoError = null;


        if (TextUtils.isEmpty(txtSticker.getText())) {
            stickerError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtSelloSerial.getText())) {
            selloSerialError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtLectura.getText())) {
            lecturaError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtNom_contacto.getText())) {
            contactoError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtTel_fijo.getText())) {
            telFijoError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtTel_celular.getText())) {
            TelCelularError = getString(R.string.obligatorio);
        }
        if (TextUtils.isEmpty(txtObservaciones.getText())) {
            observacionesError = getString(R.string.obligatorio);
        }

        toggleTextInputLayoutError(til_sticker, stickerError);
        toggleTextInputLayoutError(til_sello_serial, selloSerialError);
        toggleTextInputLayoutError(til_lectura, lecturaError);
        toggleTextInputLayoutError(til_nom_contacto, contactoError);
        toggleTextInputLayoutError(til_tel_fijo, telFijoError);
        toggleTextInputLayoutError(til_tel_celular, TelCelularError);
        toggleTextInputLayoutError(til_Observacion, observacionesError);

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
