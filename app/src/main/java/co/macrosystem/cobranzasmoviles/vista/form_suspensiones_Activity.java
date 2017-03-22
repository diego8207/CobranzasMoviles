package co.macrosystem.cobranzasmoviles.vista;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;

public class form_suspensiones_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private Suspension suspension;

    private MaterialBetterSpinner spnrEstadoSello;


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

    private TextView error_estado_sticker;
    private TextView error_Opciones_matricula_medidor;
    private TextView error_Opciones_matricula_pago;
    private TextView error_Opciones_tiene_luz;
    private TextView error_Opciones_rechazo;
    private TextView error_Opciones_estado_sello;

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

    private RadioButton rbtn_estado_roto;
    private RadioButton rbtn_estado_No_instal;
    private RadioButton rbtn_estado_sin_diligen;

    private RadioButton rbtn_si_matr_med;
    private RadioButton rbtn_no_matr_med;
    private RadioButton rbtn_no_aplica_matr_med;

    private RadioButton rbtn_luz_si;
    private RadioButton rbtn_luz_no;
    private RadioButton rbtn_luz_no_aplica;

    private RadioButton rbtn_mcp_si;
    private RadioButton rbtn_mcp_no;
    private RadioButton rbtn_mcp_no_aplica;

    private RadioButton rbtn_rechazo_si;
    private RadioButton rbtn_rechazo_no;

    private String latitudGPS;
    private String longitudGPS;

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
        spnrEstadoSello = (MaterialBetterSpinner) findViewById(R.id.spnr_estado_sello);
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

        rbtn_estado_roto = (RadioButton) findViewById(R.id.rbtn_estado_roto);
        rbtn_estado_No_instal = (RadioButton) findViewById(R.id.rbtn_estado_No_instal);
        rbtn_estado_sin_diligen = (RadioButton) findViewById(R.id.rbtn_estado_sin_diligen);

        rbtn_si_matr_med = (RadioButton) findViewById(R.id.rbtn_si_matr_med);
        rbtn_no_matr_med = (RadioButton) findViewById(R.id.rbtn_no_matr_med);
        rbtn_no_aplica_matr_med = (RadioButton) findViewById(R.id.rbtn_no_aplica_matr_med);

        rbtn_luz_si = (RadioButton) findViewById(R.id.rbtn_luz_si);
        rbtn_luz_no = (RadioButton) findViewById(R.id.rbtn_luz_no);
        rbtn_luz_no_aplica = (RadioButton) findViewById(R.id.rbtn_luz_no_aplica);

        rbtn_mcp_si = (RadioButton) findViewById(R.id.rbtn_mcp_si);
        rbtn_mcp_no = (RadioButton) findViewById(R.id.rbtn_mcp_no);
        rbtn_mcp_no_aplica = (RadioButton) findViewById(R.id.rbtn_mcp_no_aplica);

        rbtn_rechazo_si = (RadioButton) findViewById(R.id.rbtn_rechazo_si);
        rbtn_rechazo_no = (RadioButton) findViewById(R.id.rbtn_rechazo_no);

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

        //Capturamos los textview que van a servir para mostrar el mensaje de error al no seleccionar un radioButton del radioGroup
        error_estado_sticker = (TextView) findViewById(R.id.error_estado_sticker);
        error_Opciones_matricula_medidor = (TextView) findViewById(R.id.error_Opciones_matricula_medidor);
        error_Opciones_matricula_pago = (TextView) findViewById(R.id.error_Opciones_matricula_pago);
        error_Opciones_tiene_luz = (TextView) findViewById(R.id.error_Opciones_tiene_luz);
        error_Opciones_rechazo = (TextView) findViewById(R.id.error_Opciones_rechazo);
        error_Opciones_estado_sello = (TextView) findViewById(R.id.error_Opciones_estado_sello);

        //Ocultamos TextView que visualizan mensajes de error para los RadioGroup
        error_estado_sticker.setVisibility(View.GONE);
        error_Opciones_matricula_medidor.setVisibility(View.GONE);
        error_Opciones_matricula_pago.setVisibility(View.GONE);
        error_Opciones_tiene_luz.setVisibility(View.GONE);
        error_Opciones_rechazo.setVisibility(View.GONE);
        error_Opciones_estado_sello.setVisibility(View.GONE);

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

        //Creamos un ArrayAdapter para el Spinner de estado del sello
        ArrayAdapter<String> arrayAdapterSello = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, SPNR_ESTADO_SELLO);
        spnrEstadoSello.setAdapter(arrayAdapterSello);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //Metodo que valida todos los campos obligatorios del formulario de suspension.
    public void validar(View view) {

        int estadoEstickerSelected = rdgEstado_Sticker.getCheckedRadioButtonId();
        int matriculaMedidorSelected = rdgOpciones_matricula_medidor.getCheckedRadioButtonId();
        int matriculaPagoSelected = rdgOpciones_matricula_pago.getCheckedRadioButtonId();
        int energiaSelected = rdgOpciones_tiene_luz.getCheckedRadioButtonId();
        int rechazoSelected = rdgOpciones_rechazo.getCheckedRadioButtonId();

        String stickerError = null;
        String stickerRbgError = null;
        String matriculaMedidorRbgError = null;
        String matriculaPagoRbgError = null;
        String energiaRbgError = null;
        String rechazoRbgError = null;
        String estadoSelloSpnrError = null;

        String selloSerialError = null;
        String lecturaError = null;
        String contactoError = null;
        String TelCelularError = null;
        String observacionesError = null;

        String itemSeleccionadoEstadoSello = spnrEstadoSello.getText().toString();

        //validamos si se ha elegido una aopcion del spinner estado del sello
        if (itemSeleccionadoEstadoSello.equals("")){
            estadoSelloSpnrError = getString(R.string.rgbopcionesError);
            error_Opciones_estado_sello.setText(estadoSelloSpnrError);
            error_Opciones_estado_sello.setVisibility(View.VISIBLE);
        }else{
            error_Opciones_estado_sello.setVisibility(View.GONE);
            suspension.setSUSP_SELLOSERIAL_ESTADO(itemSeleccionadoEstadoSello);
        }


        /**
         * Validamos si el RadioGroup ha sido seleccionado: en case de que no
         * que muestre el un textview con el mensaje de error en caso contrario
         * que almacene el valor selecionado en el objeto suspension
         */
        if (estadoEstickerSelected == -1){
            stickerRbgError = getString(R.string.rgbopcionesError);
            error_estado_sticker.setText(stickerRbgError);
            error_estado_sticker.setVisibility(View.VISIBLE);
        }else{
            error_estado_sticker.setVisibility(View.GONE);

            if (rbtn_estado_roto.isChecked())
                suspension.setSUSP_ESTADO_STICKER("Roto");
            if (rbtn_estado_No_instal.isChecked()){
                suspension.setSUSP_ESTADO_STICKER("No instalado");
            }
            if (rbtn_estado_sin_diligen.isChecked()){
                suspension.setSUSP_ESTADO_STICKER("Sin diligenciar");
            }
        }

        if (matriculaMedidorSelected == -1){
            matriculaMedidorRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_matricula_medidor.setText(matriculaMedidorRbgError);
            error_Opciones_matricula_medidor.setVisibility(View.VISIBLE);
        }else{
            error_Opciones_matricula_medidor.setVisibility(View.GONE);

            if (rbtn_si_matr_med.isChecked()){
                suspension.setSUSP_COINC_MAT_MEDI("Si");
            }
            if (rbtn_no_matr_med.isChecked()){
                suspension.setSUSP_COINC_MAT_MEDI("No");
            }
            if (rbtn_no_aplica_matr_med.isChecked()){
                suspension.setSUSP_COINC_MAT_MEDI("No aplica");
            }
        }

        if (matriculaPagoSelected == -1){
            matriculaPagoRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_matricula_pago.setText(matriculaPagoRbgError);
            error_Opciones_matricula_pago.setVisibility(View.VISIBLE);
        }else{
            error_Opciones_matricula_pago.setVisibility(View.GONE);

            if (rbtn_mcp_si.isChecked()){
                suspension.setSUSP_CON_PAGO("Si");
            }
            if (rbtn_mcp_no.isChecked()){
                suspension.setSUSP_CON_PAGO("No");
            }
            if (rbtn_mcp_no_aplica.isChecked()){
                suspension.setSUSP_CON_PAGO("No aplica");
            }
        }

        if (energiaSelected == -1){
            energiaRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_tiene_luz.setText(energiaRbgError);
            error_Opciones_tiene_luz.setVisibility(View.VISIBLE);
        }else{
            error_Opciones_tiene_luz.setVisibility(View.GONE);

            if (rbtn_luz_si.isChecked()){
                suspension.setSUSP_TIENE_ENERGIA("Si");
            }
            if (rbtn_luz_no.isChecked()){
                suspension.setSUSP_TIENE_ENERGIA("No");
            }
            if (rbtn_luz_no_aplica.isChecked()){
                suspension.setSUSP_TIENE_ENERGIA("No aplica");
            }
        }

        if (rechazoSelected == -1){
            rechazoRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_rechazo.setText(rechazoRbgError);
            error_Opciones_rechazo.setVisibility(View.VISIBLE);
        }else{
            error_Opciones_rechazo.setVisibility(View.GONE);

            if (rbtn_rechazo_si.isChecked()){
                suspension.setSUSP_RECHAZADO("Si");
            }
            if (rbtn_rechazo_no.isChecked()){
                suspension.setSUSP_RECHAZADO("No");
            }
        }

        /**
         * validamos si los InputEditText estan vacios para visualizar mensaje de error
         * en caso contrario almacenamos el valor en el objeto suspension
         */

        if (TextUtils.isEmpty(txtSticker.getText())) {
            stickerError = getString(R.string.obligatorio);
        }else{
            suspension.setSUSP_NUM_STICKER(txtSticker.getText().toString());
        }

        if (TextUtils.isEmpty(txtSelloSerial.getText())) {
            selloSerialError = getString(R.string.obligatorio);
        }else{
            suspension.setSUSP_SELLOSERIAL(txtSelloSerial.getText().toString());
        }

        if (TextUtils.isEmpty(txtLectura.getText())) {
            lecturaError = getString(R.string.obligatorio);
        }else{
            suspension.setSUSP_LECTURA(txtLectura.getText().toString());
        }

        if (TextUtils.isEmpty(txtNom_contacto.getText())) {
            contactoError = getString(R.string.obligatorio);
        }else{
            suspension.setSUSP_NOM_CONTACTO(txtNom_contacto.getText().toString());
        }

        if (TextUtils.isEmpty(txtTel_celular.getText())) {
            TelCelularError = getString(R.string.obligatorio);
        }else{
            suspension.setSUSP_NUM_CONTACTO(txtTel_celular.getText().toString());
        }

        if (TextUtils.isEmpty(txtObservaciones.getText())) {
            observacionesError = getString(R.string.obligatorio);
        }else{
            suspension.setSUSP_OBSERVACIONES(txtObservaciones.getText().toString());
        }

        //asignamos el error a cada TextImputLayout para que se pueda visualizar cuando se presenten las validaciones
        toggleTextInputLayoutError(til_sticker, stickerError);
        toggleTextInputLayoutError(til_sello_serial, selloSerialError);
        toggleTextInputLayoutError(til_lectura, lecturaError);
        toggleTextInputLayoutError(til_nom_contacto, contactoError);
        toggleTextInputLayoutError(til_tel_celular, TelCelularError);
        toggleTextInputLayoutError(til_Observacion, observacionesError);

        visualizarInformacion();

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

    public void visualizarInformacion(){

        //FALTA LA CAPTURA DE LOS RADIO BUTTONS ...

        Toast toast = Toast.makeText(getBaseContext(),
                "MATRICULA: " + suspension.getSUSP_MATRICULA() + "\n" +
                        "STICKER: " + suspension.getSUSP_NUM_STICKER()+ "\n" +
                        "ESTADO DEL STICKER: " + suspension.getSUSP_ESTADO_STICKER()+ "\n" +
                        "SELLO SERIAL: " + suspension.getSUSP_SELLOSERIAL()+ "\n" +
                        "ESTADO DEL SELLO: " + suspension.getSUSP_SELLOSERIAL_ESTADO()+ "\n" +
                        "COINC MATRICULA Y MEDIDOR: " + suspension.getSUSP_COINC_MAT_MEDI()+ "\n" +
                        "MATRICULA CON PAGO: " + suspension.getSUSP_CON_PAGO()+ "\n" +
                        "TIENE ENERGIA: " + suspension.getSUSP_TIENE_ENERGIA()+ "\n" +
                        "LECTURA: " + suspension.getSUSP_LECTURA()+ "\n" +
                        "NOMBRE DE CONTACTO: " + suspension.getSUSP_NOM_CONTACTO()+ "\n" +
                        "CELULAR: " + suspension.getSUSP_NUM_CONTACTO()+ "\n" +
                        "OBSERVACIONES: " + suspension.getSUSP_OBSERVACIONES()+ "\n" +
                        "RECHAZADO: " + suspension.getSUSP_RECHAZADO()+ "\n"

                ,Toast.LENGTH_LONG);
        toast.show();
    }

    public void obtenerCoordenadasGPS(){
        
    }



}
