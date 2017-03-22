package co.macrosystem.cobranzasmoviles.vista;

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
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import co.macrosystem.cobranzasmoviles.R;
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
    private TextView txtFechaCarga;

    private TextInputLayout til_sticker;
    private TextInputEditText txtSticker;
    private TextInputLayout til_sello_serial;
    private TextInputEditText txtSelloSerial;
    private TextInputLayout til_lectura;
    private TextInputEditText txtLectura;
    private TextInputLayout til_nom_contacto;
    private TextInputEditText txtNom_contacto;
    private TextInputLayout til_tel_celular;
    private TextInputEditText txtTel_celular;
    private TextInputLayout til_Observacion;
    private TextInputEditText txtObservaciones;

    private RadioGroup rdgEstado_Sticker;
    private RadioGroup rdgOpciones_matricula_medidor;
    private RadioGroup rdgOpciones_matricula_pago;
    private RadioGroup rdgOpciones_tiene_luz;
    private RadioGroup rdgOpciones_rechazo;

    private String opcionEstadoSticker;
    private String opcionMatriculaMedidor;
    private String opcionMatriculaPago;
    private String opcionTieneLuz;
    private String Opcion_rechazo;

    private Button btnRegistrar;

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
        toolbar.setLogo(R.drawable.logo_cobranzas_title);
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
        txtFechaCarga = (TextView) findViewById(R.id.txtfechaCarga);

        //capturamos los elementos del formulario que van a estar disponibles para ingresar informacion

        rdgEstado_Sticker = (RadioGroup) findViewById(R.id.rgbOpciones_estado_sticker);
        rdgOpciones_matricula_medidor = (RadioGroup) findViewById(R.id.rdgOpciones_matricula_medidor);
        rdgOpciones_matricula_pago = (RadioGroup) findViewById(R.id.rgbOpciones_matricula_pago);
        rdgOpciones_tiene_luz = (RadioGroup) findViewById(R.id.rdgOpciones_tiene_luz);
        rdgOpciones_rechazo = (RadioGroup) findViewById(R.id.rdgOpciones_rechazo);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        txtSticker = (TextInputEditText) findViewById(R.id.txtSticker);
        til_sticker = (TextInputLayout) findViewById(R.id.til_sticker);
        txtSelloSerial = (TextInputEditText) findViewById(R.id.txtSelloSerial);
        til_sello_serial = (TextInputLayout) findViewById(R.id.til_sello_serial);
        til_lectura = (TextInputLayout) findViewById(R.id.til_lectura);
        txtLectura = (TextInputEditText) findViewById(R.id.txtLectura);
        til_nom_contacto = (TextInputLayout) findViewById(R.id.til_nom_contacto);
        txtNom_contacto = (TextInputEditText) findViewById(R.id.txtNom_contacto);
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
        txtFechaCarga.setText(suspension.getSUSP_FECHA_CARGA());

        Log.e(null, "MATRICULA: " + suspension.getSUSP_MATRICULA());
        Log.e(null, "FECHA DE CARGA: " + suspension.getSUSP_FECHA_CARGA());
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

    public void ProcesarSuspension(){

        //capturamos la opcion elegida en los cuatro RadioGroup implementados en el formulario
        rdgEstado_Sticker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbtn_estado_roto){
                    opcionEstadoSticker = "Roto";
                }else if (checkedId == R.id.rbtn_estado_No_instal){
                    opcionEstadoSticker = "No Instalado";
                }else if (checkedId == R.id.rbtn_estado_sin_diligen){
                    opcionEstadoSticker = "Sin Diligenciar";
                }
            }
        });

        rdgOpciones_matricula_medidor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbtn_si_matr_med){
                    opcionMatriculaMedidor = "Si";
                }else if (checkedId == R.id.rbtn_no_matr_med){
                    opcionMatriculaMedidor = "No";
                }else if (checkedId == R.id.rbtn_no_aplica_matr_med){
                    opcionMatriculaMedidor = "No aplica";
                }
            }
        });

        rdgOpciones_matricula_pago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbtn_mcp_si){
                    opcionMatriculaPago = "Si";
                }else if (checkedId == R.id.rbtn_mcp_no){
                    opcionMatriculaPago = "No";
                }else if (checkedId == R.id.rbtn_mcp_no_aplica){
                    opcionMatriculaPago = "No aplica";
                }
            }
        });

        rdgOpciones_tiene_luz.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbtn_luz_si){
                    opcionTieneLuz = "Si";
                }else if (checkedId == R.id.rbtn_luz_no){
                    opcionTieneLuz = "No";
                }else if (checkedId == R.id.rbtn_luz_no_aplica){
                    opcionTieneLuz = "No aplica";
                }
            }
        });

        rdgOpciones_rechazo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbtn_rechazo_si){
                    Opcion_rechazo = "Si";
                }else if (checkedId == R.id.rbtn_rechazo_no){
                    Opcion_rechazo = "No";
                }
            }
        });

        //creamos el objeto suspension el cual almacenara los campos diligenciados del formulario
        Suspension suspProce = new Suspension();
        suspProce.setSUSP_MATRICULA(suspension.getSUSP_MATRICULA());
        suspProce.setSUSP_NUM_STICKER(txtSticker.getText().toString());
        suspProce.setSUSP_ESTADO_STICKER(opcionEstadoSticker);
        suspProce.setSUSP_SELLOSERIAL("--");// ----------------> FALTA
        suspProce.setSUSP_SELLOSERIAL_ESTADO("--");// ----------------> FALTA
        suspProce.setSUSP_COINC_MAT_MEDI(opcionMatriculaMedidor);
        suspProce.setSUSP_CON_PAGO(opcionMatriculaPago);
        suspProce.setSUSP_TIENE_ENERGIA(opcionTieneLuz);
        suspProce.setSUSP_LECTURA("--");// ----------------> FALTA
        suspProce.setSUSP_NOM_CONTACTO("--");// ----------------> FALTA
        suspProce.setSUSP_NUM_CONTACTO("--");// ----------------> FALTA
        suspProce.setSUSP_OBSERVACIONES("--");// ----------------> FALTA
        suspProce.setSUSP_RECHAZADO(Opcion_rechazo);

    }

}
