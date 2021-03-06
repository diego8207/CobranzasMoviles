package co.macrosystem.cobranzasmoviles.vista;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.DbBitmapUtility;
import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;

public class form_suspensiones_Activity extends AppCompatActivity implements LocationListener {

    private static final int MI_PERMISO_ACCESS_COARSE_LOCATION = 1;
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private Toolbar toolbar;

    private Suspension suspension;
    private ConstructorSuspensiones constructorSuspensiones;
    private Context context;

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

    //Variables para Localización
    private TextView txtLatitudGPS;
    private TextView txtLongitudGPS;
    private TextView txtProveedorGPS;
    private String provider;
    public LocationManager handle;
    private Intent intent;


    private Button btnRegistrar;

    private ImageView imgFoto1;
    private ImageView imgFoto2;
    private ImageView imgFoto3;
    private ImageView imgFoto4;
    private ImageView imgFoto5;
    private ImageView imgFoto6;
    private ImageView imgFoto7;
    private ImageView imgFoto8;
    private ImageView imgFoto9;
    private ImageView imgFoto10;
    private ImageView imgFoto11;
    private ImageView imgFoto12;
    ArrayList<String> fotos;
    final int CAMERA_REQUEST = 1100;
    Bitmap bmp;
    private int numFoto = 0;



    String[] SPNR_ESTADO_SELLO = {"Roto", "No instalado", "Sin diligenciar", "No reportado", "Conforme"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_suspensiones);
        imgFoto1 = (ImageView) findViewById(R.id.imgFoto1);
        imgFoto2 = (ImageView) findViewById(R.id.imgFoto2);
        imgFoto3 = (ImageView) findViewById(R.id.imgFoto3);
        imgFoto4 = (ImageView) findViewById(R.id.imgFoto4);
        imgFoto5 = (ImageView) findViewById(R.id.imgFoto5);
        imgFoto6 = (ImageView) findViewById(R.id.imgFoto6);
        imgFoto7 = (ImageView) findViewById(R.id.imgFoto7);
        imgFoto8 = (ImageView) findViewById(R.id.imgFoto8);
        imgFoto9 = (ImageView) findViewById(R.id.imgFoto9);
        imgFoto10 = (ImageView) findViewById(R.id.imgFoto10);
        imgFoto11 = (ImageView) findViewById(R.id.imgFoto11);
        imgFoto12 = (ImageView) findViewById(R.id.imgFoto12);

        fotos = new ArrayList<>();

        context = this.getBaseContext();
        intent = new Intent(this, MenuPrincipal.class);

        FloatingActionButton floatingActionButtonCamera = (FloatingActionButton) findViewById(R.id.fab);

        suspension = getIntent().getParcelableExtra("objSuspension");

        Toolbar toolbarCard = (Toolbar) findViewById(R.id.toolbarCardFormSuspensiones);
        toolbarCard.setTitle("Matricula: " + suspension.getSUSP_MATRICULA() + "  ::: " + suspension.getSUSP_ESTADO() + " :::");
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

        //Capturamos los TextView donde se visualizaran los datos de localizacion
        txtProveedorGPS = (TextView) findViewById(R.id.etiqueta_txtProveedorGPS);
        txtLatitudGPS = (TextView) findViewById(R.id.etiqueta_txtLatitudGPS);
        txtLongitudGPS = (TextView) findViewById(R.id.etiqueta_txtLongitudGPS);

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


        /**
         * Vamos a validar si es una suspension procesada o subida debe mostrar en solo lectura la informacion
         */
        String suspen = suspension.getSUSP_ESTADO();

        if (!suspen.equals("restantes")) {
            txtObservaciones.setEnabled(false);
            txtSticker.setEnabled(false);
            rbtn_estado_roto.setEnabled(false);
            rbtn_estado_No_instal.setEnabled(false);
            rbtn_estado_sin_diligen.setEnabled(false);
            txtSelloSerial.setEnabled(false);
            spnrEstadoSello.setEnabled(false);
            rbtn_si_matr_med.setEnabled(false);
            rbtn_no_matr_med.setEnabled(false);
            rbtn_no_aplica_matr_med.setEnabled(false);
            rbtn_mcp_si.setEnabled(false);
            rbtn_mcp_no.setEnabled(false);
            rbtn_mcp_no_aplica.setEnabled(false);
            rbtn_luz_si.setEnabled(false);
            rbtn_luz_no.setEnabled(false);
            rbtn_luz_no_aplica.setEnabled(false);
            txtLectura.setEnabled(false);
            txtNom_contacto.setEnabled(false);
            txtTel_celular.setEnabled(false);
            rbtn_rechazo_si.setEnabled(false);
            rbtn_rechazo_no.setEnabled(false);
            btnRegistrar.setEnabled(false);

            if (suspen.equals("subidas")) {
                btnRegistrar.setText("SUBIDA");
                btnRegistrar.setBackgroundColor(getResources().getColor(R.color.teal));
                toolbarCard.setBackgroundColor(getResources().getColor(R.color.teal));
                toolbar.setBackgroundColor(getResources().getColor(R.color.teal));

                //crear una funcion que cargue todos los elementos de la suspension
                //asi le sirve a subidas como a procesadas
                visualizarSoloLectura(suspension);

            } else if (suspen.equals("procesadas")) {
                btnRegistrar.setText("PROCESADA: " + suspension.getSUSP_FECHA_EJECUCION());
                btnRegistrar.setBackgroundColor(getResources().getColor(R.color.orange));
                toolbarCard.setBackgroundColor(getResources().getColor(R.color.orange));
                toolbar.setBackgroundColor(getResources().getColor(R.color.orange));

                visualizarSoloLectura(suspension);

            }
        } else {
            txtObservaciones.setText("");
        }

        //Log.e(null, "MATRICULA: " + suspension.getSUSP_MATRICULA());
        //Log.e(null, "FECHA DE CARGA: " + suspension.getSUSP_FECHA_CARGA());

        //Creamos un ArrayAdapter para el Spinner de estado del sello serial
        ArrayAdapter<String> arrayAdapterSello = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, SPNR_ESTADO_SELLO);
        spnrEstadoSello.setAdapter(arrayAdapterSello);

        IniciarServicioGPS();
        procesarSuspension(context);//--------------------- SOLO CUANDO ESTA HABILITADO EL BOTON DE PROCESAR -----------------------------------

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //PROCESAMOS FLOATACTIONBUTTON PARA LAS FOTOS
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        floatingActionButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    VerificarPermisosCamara();
            }
        });

    }

    private void AbrirCamara() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    //Sobreescribimos el metodo de la camara para poder


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            Bundle extra = data.getExtras();

            bmp = (Bitmap) extra.get("data");

            //asignamos la imagen capturada al ImageView
            asignarImagen(bmp);

            //PASAMOS LA IMAGEN A STRING
            String encoded  = DbBitmapUtility.encodeBitmapToString(bmp);


            //LA AGREGAMOS AL ARRAYLIST STRING GLOBAL
            fotos.add(encoded);

            //VALIDAMOS SI SE ESTAN ALMACENANDO LAS FOTOS EN EL ARRAYLIST<STRING> FOTOS
          for(String temp : fotos){
                Log.e("ImageBase64:  ", temp);
            }





           // Log.i("ImageBase64:  ", encoded);
            //Log.i("tamaño: ", String.valueOf(encoded.length()));

        }
    }

    public void asignarImagen(Bitmap bmp){

        switch (numFoto){
            case 0: imgFoto1.setImageBitmap(bmp); break;
            case 1: imgFoto2.setImageBitmap(bmp); break;
            case 2: imgFoto3.setImageBitmap(bmp); break;
            case 3: imgFoto4.setImageBitmap(bmp); break;
            case 4: imgFoto5.setImageBitmap(bmp); break;
            case 5: imgFoto6.setImageBitmap(bmp); break;
            case 6: imgFoto7.setImageBitmap(bmp); break;
            case 7: imgFoto8.setImageBitmap(bmp); break;
            case 8: imgFoto9.setImageBitmap(bmp); break;
            case 9: imgFoto10.setImageBitmap(bmp); break;
            case 10: imgFoto11.setImageBitmap(bmp); break;
            case 11: imgFoto12.setImageBitmap(bmp); break;
        }

        numFoto++;
    }


    private void VerificarPermisosCamara() {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                //Toast.makeText(this, "Esta es una version de android inferior al api 23" + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
            } else {

                int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CAMERA);
                int hasWriteStoragePermission = checkSelfPermission(Manifest.permission_group.STORAGE);

                if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED && hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CODE_ASK_PERMISSIONS);
                    requestPermissions(new String[] {Manifest.permission_group.STORAGE},REQUEST_CODE_ASK_PERMISSIONS);
                    Toast.makeText(this, "Requesting permissions", Toast.LENGTH_LONG).show();
                }else if (hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED){
                    //Toast.makeText(this, "The permissions are already granted ", Toast.LENGTH_LONG).show();
                    AbrirCamara();
                }
            }
            return;
        }


    private void procesarSuspension(final Context context) {
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorSuspensiones constructorSuspensiones =  new ConstructorSuspensiones(view.getContext());
                if (validar(suspension)){
                    try {
                        suspension.setFotos(fotos);  //aqui debe estar pero temporalmente lo voy a poner en el boton registrar
                        constructorSuspensiones.procesarSuspension(suspension);
                        constructorSuspensiones.procesarFotosSuspensionSQLite(suspension);
                        Toast.makeText(context, "Suspension procesada exitosamente ! ", Toast.LENGTH_SHORT).show();
                        startActivity(intent);//Vamos al menu prncipal

                    }catch (java.lang.NullPointerException e){
                        Log.i("Excepcion Nula", e.toString());
                    }
                }else{
                    Toast.makeText(context, "Formulario incompleto", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Metodo que valida todos los campos obligatorios del formulario de p_suspension.
    public boolean validar(Suspension p_suspension) {
        boolean validaformulario = false;
        int contador = 0;
        IniciarServicioGPS();


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
        if (itemSeleccionadoEstadoSello.equals("")) {
            estadoSelloSpnrError = getString(R.string.rgbopcionesError);
            error_Opciones_estado_sello.setText(estadoSelloSpnrError);
            error_Opciones_estado_sello.setVisibility(View.VISIBLE);

        } else {
            error_Opciones_estado_sello.setVisibility(View.GONE);
            p_suspension.setSUSP_SELLOSERIAL_ESTADO(itemSeleccionadoEstadoSello);
            contador ++;
        }


        /**
         * Validamos si el RadioGroup ha sido seleccionado: en case de que no
         * que muestre el un textview con el mensaje de error en caso contrario
         * que almacene el valor selecionado en el objeto p_suspension
         */
        if (estadoEstickerSelected == -1) {
            stickerRbgError = getString(R.string.rgbopcionesError);
            error_estado_sticker.setText(stickerRbgError);
            error_estado_sticker.setVisibility(View.VISIBLE);
        } else {
            error_estado_sticker.setVisibility(View.GONE);
            validaformulario = true;

            if (rbtn_estado_roto.isChecked()) {
                p_suspension.setSUSP_ESTADO_STICKER("Roto");
            }
            if (rbtn_estado_No_instal.isChecked()) {
                p_suspension.setSUSP_ESTADO_STICKER("No instalado");
            }
            if (rbtn_estado_sin_diligen.isChecked()) {
                p_suspension.setSUSP_ESTADO_STICKER("Sin diligenciar");
            }
            contador ++;
        }

        if (matriculaMedidorSelected == -1) {
            matriculaMedidorRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_matricula_medidor.setText(matriculaMedidorRbgError);
            error_Opciones_matricula_medidor.setVisibility(View.VISIBLE);
        } else {
            error_Opciones_matricula_medidor.setVisibility(View.GONE);
            validaformulario = true;

            if (rbtn_si_matr_med.isChecked()) {
                p_suspension.setSUSP_COINC_MAT_MEDI("Si");
            }
            if (rbtn_no_matr_med.isChecked()) {
                p_suspension.setSUSP_COINC_MAT_MEDI("No");
            }
            if (rbtn_no_aplica_matr_med.isChecked()) {
                p_suspension.setSUSP_COINC_MAT_MEDI("No aplica");
            }
            contador ++;
        }

        if (matriculaPagoSelected == -1) {
            matriculaPagoRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_matricula_pago.setText(matriculaPagoRbgError);
            error_Opciones_matricula_pago.setVisibility(View.VISIBLE);
        } else {
            error_Opciones_matricula_pago.setVisibility(View.GONE);
            validaformulario = true;

            if (rbtn_mcp_si.isChecked()) {
                p_suspension.setSUSP_CON_PAGO("Si");
            }
            if (rbtn_mcp_no.isChecked()) {
                p_suspension.setSUSP_CON_PAGO("No");
            }
            if (rbtn_mcp_no_aplica.isChecked()) {
                p_suspension.setSUSP_CON_PAGO("No aplica");
            }
            contador ++;
        }

        if (energiaSelected == -1) {
            energiaRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_tiene_luz.setText(energiaRbgError);
            error_Opciones_tiene_luz.setVisibility(View.VISIBLE);
        } else {
            error_Opciones_tiene_luz.setVisibility(View.GONE);
            validaformulario = true;

            if (rbtn_luz_si.isChecked()) {
                p_suspension.setSUSP_TIENE_ENERGIA("Si");
            }
            if (rbtn_luz_no.isChecked()) {
                p_suspension.setSUSP_TIENE_ENERGIA("No");
            }
            if (rbtn_luz_no_aplica.isChecked()) {
                p_suspension.setSUSP_TIENE_ENERGIA("No aplica");
            }
            contador ++;
        }

        if (rechazoSelected == -1) {
            rechazoRbgError = getString(R.string.rgbopcionesError);
            error_Opciones_rechazo.setText(rechazoRbgError);
            error_Opciones_rechazo.setVisibility(View.VISIBLE);
        } else {
            error_Opciones_rechazo.setVisibility(View.GONE);
            validaformulario = true;

            if (rbtn_rechazo_si.isChecked()) {
                p_suspension.setSUSP_RECHAZADO("Si");
            }
            if (rbtn_rechazo_no.isChecked()) {
                p_suspension.setSUSP_RECHAZADO("No");
            }
            contador ++;
        }

        /**-----------------------------------------------------------------------------------
         * validamos si los InputEditText estan vacios para visualizar mensaje de error
         * en caso contrario almacenamos el valor en el objeto p_suspension
         */

        if (TextUtils.isEmpty(txtSticker.getText())) {
            stickerError = getString(R.string.obligatorio);

        } else {
            p_suspension.setSUSP_NUM_STICKER(txtSticker.getText().toString());
            contador ++;
        }

        if (TextUtils.isEmpty(txtSelloSerial.getText())) {
            selloSerialError = getString(R.string.obligatorio);

        } else {
            p_suspension.setSUSP_SELLOSERIAL(txtSelloSerial.getText().toString());
            contador ++;
        }

        if (TextUtils.isEmpty(txtLectura.getText())) {
            lecturaError = getString(R.string.obligatorio);

        } else {
            p_suspension.setSUSP_LECTURA(txtLectura.getText().toString());
            contador ++;
        }

        if (TextUtils.isEmpty(txtNom_contacto.getText())) {
            contactoError = getString(R.string.obligatorio);

        } else {
            p_suspension.setSUSP_NOM_CONTACTO(txtNom_contacto.getText().toString());
            contador ++;
        }

        if (TextUtils.isEmpty(txtTel_celular.getText())) {
            TelCelularError = getString(R.string.obligatorio);

        } else {
            p_suspension.setSUSP_NUM_CONTACTO(txtTel_celular.getText().toString());
            contador ++;
        }

        if (TextUtils.isEmpty(txtObservaciones.getText())) {
            observacionesError = getString(R.string.obligatorio);

        } else {
            p_suspension.setSUSP_OBSERVACIONES(txtObservaciones.getText().toString());
            contador ++;
        }/**
         * FIN DE LA VALIDACION DE OBJETOS DE SOLO LECTURA PARA FORMULARIOS
         * PROCESADOS Y SUBIDOS
         * -----------------------------------------------------------------------------------
         */

        //asignamos el error a cada TextImputLayout para que se pueda visualizar cuando se presenten las validaciones
        toggleTextInputLayoutError(til_sticker, stickerError);
        toggleTextInputLayoutError(til_sello_serial, selloSerialError);
        toggleTextInputLayoutError(til_lectura, lecturaError);
        toggleTextInputLayoutError(til_nom_contacto, contactoError);
        toggleTextInputLayoutError(til_tel_celular, TelCelularError);
        toggleTextInputLayoutError(til_Observacion, observacionesError);

        IniciarServicioGPS();
        muestraUbicacionActual();


        /**
         * este contador fue creado para controlar la validacion del formulario,
         * por cada campo diligenciado se incrementa en uno hasta llegar a 12
         * si no ha llegado a la cantidad de campos que deben ser diligenciados
         * retornara un false  no dejara procesar la suspension.
         */
        if (contador == 12){
            validaformulario = true;
        }else{
            validaformulario = false;
        }

        //visualizarInformacion(); //muestra en un Toast todos los datos capturados en el formulario
        return validaformulario;

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

    public void visualizarInformacion() {
        Toast toast = Toast.makeText(getBaseContext(),
                "MATRICULA: " + suspension.getSUSP_MATRICULA() + "\n" +
                        "SUSCRIPTOR: " + suspension.getSUSP_SUSCRIPTOR() + "\n" +
                        "STICKER: " + suspension.getSUSP_NUM_STICKER() + "\n" +
                        "ESTADO DEL STICKER: " + suspension.getSUSP_ESTADO_STICKER() + "\n" +
                        "SELLO SERIAL: " + suspension.getSUSP_SELLOSERIAL() + "\n" +
                        "ESTADO DEL SELLO: " + suspension.getSUSP_SELLOSERIAL_ESTADO() + "\n" +
                        "COINC MATRICULA Y MEDIDOR: " + suspension.getSUSP_COINC_MAT_MEDI() + "\n" +
                        "MATRICULA CON PAGO: " + suspension.getSUSP_CON_PAGO() + "\n" +
                        "TIENE ENERGIA: " + suspension.getSUSP_TIENE_ENERGIA() + "\n" +
                        "LECTURA: " + suspension.getSUSP_LECTURA() + "\n" +
                        "NOMBRE DE CONTACTO: " + suspension.getSUSP_NOM_CONTACTO() + "\n" +
                        "CELULAR: " + suspension.getSUSP_NUM_CONTACTO() + "\n" +
                        "OBSERVACIONES: " + suspension.getSUSP_OBSERVACIONES() + "\n" +
                        "RECHAZADO: " + suspension.getSUSP_RECHAZADO() + "\n" +
                        "LATITUD: " + suspension.getSUSP_LATITUD() + "\n" +
                        "LONGITUD: " + suspension.getSUSP_LONGITUD() + "\n" +
                        "EJECUCION: " + suspension.getSUSP_FECHA_EJECUCION() + "\n" +
                        "CARGA: " + suspension.getSUSP_FECHA_CARGA() + "\n"

                , Toast.LENGTH_LONG);
        toast.show();
    }


    public void IniciarServicioGPS() {

        handle = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria c = new Criteria();
        c.setAccuracy(Criteria.ACCURACY_FINE);
        provider = handle.getBestProvider(c, true);
        txtProveedorGPS.setText("Localización: " + provider);
        //aqui hay que solicitar al usuario el servicio
        if (ActivityCompat.checkSelfPermission(form_suspensiones_Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(form_suspensiones_Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(form_suspensiones_Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(form_suspensiones_Activity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MI_PERMISO_ACCESS_COARSE_LOCATION);
            }
        } else {
            handle.requestLocationUpdates(provider, 10000, 1, this);
        }

    }




    public void muestraUbicacionActual() {
        //aqui hay que solicitar al usuario el servicio
        if (ActivityCompat.checkSelfPermission(form_suspensiones_Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(form_suspensiones_Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(form_suspensiones_Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(form_suspensiones_Activity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MI_PERMISO_ACCESS_COARSE_LOCATION);
            }
        } else {
            Location location = handle.getLastKnownLocation(provider);
            if (location == null){
                txtLatitudGPS.setText("Desconocido");
                txtLongitudGPS.setText("Desconocido");
            }else{
                txtLatitudGPS.setText   (String.valueOf(location.getLatitude()));
                txtLongitudGPS.setText  (String.valueOf(location.getLongitude()));
                suspension.setSUSP_LATITUD(txtLatitudGPS.getText().toString());
                suspension.setSUSP_LONGITUD(txtLongitudGPS.getText().toString());
            }
        }
    }



    public void visualizarSoloLectura(Suspension suspension){
        txtSticker.setText(suspension.getSUSP_NUM_STICKER());


        String estadoSticker = suspension.getSUSP_ESTADO_STICKER();
        switch (estadoSticker){
            case "Sin diligenciar"  : rbtn_estado_sin_diligen.setEnabled(true); rbtn_estado_sin_diligen.setChecked(true); break;
            case "No instalado"     : rbtn_estado_No_instal.setEnabled(true); rbtn_estado_No_instal.setChecked(true); break;
            case "Roto"             : rbtn_estado_roto.setEnabled(true); rbtn_estado_roto.setChecked(true); break;
        }

        txtSelloSerial.setText(suspension.getSUSP_SELLOSERIAL());

        String estadoSello = suspension.getSUSP_SELLOSERIAL_ESTADO();

        switch (estadoSello){
            case "Roto"             : spnrEstadoSello.setText("Roto"); break;
            case "No instalado"     : spnrEstadoSello.setText("No instalado"); break;
            case "Sin diligenciar"  : spnrEstadoSello.setText("Sin diligenciar"); break;
            case "No reportado"     : spnrEstadoSello.setText("No reportado"); break;
            case "Conforme"         : spnrEstadoSello.setText("Conforme"); break;
        }

        String matriMedi = suspension.getSUSP_COINC_MAT_MEDI();
        switch (matriMedi){
            case "Si" : rbtn_si_matr_med.setChecked(true); rbtn_si_matr_med.setEnabled(true); break;
            case "No" : rbtn_no_matr_med.setChecked(true); rbtn_no_matr_med.setEnabled(true); break;
        }

        String matriPago = suspension.getSUSP_CON_PAGO();
        switch (matriPago){
            case "Si" : rbtn_mcp_si.setChecked(true); rbtn_mcp_si.setEnabled(true); break;
            case "No" : rbtn_mcp_no.setChecked(true); rbtn_mcp_no.setEnabled(true); break;
        }

        String energia = suspension.getSUSP_TIENE_ENERGIA();
        switch (energia){
            case "Si" : rbtn_luz_si.setChecked(true); rbtn_luz_si.setEnabled(true); break;
            case "No" : rbtn_luz_no.setChecked(true); rbtn_luz_no.setEnabled(true); break;
        }

        txtLectura.setText(suspension.getSUSP_LECTURA());
        txtNom_contacto.setText(suspension.getSUSP_NOM_CONTACTO());
        txtTel_celular.setText(suspension.getSUSP_NUM_CONTACTO());
        txtObservaciones.setText(suspension.getSUSP_OBSERVACIONES());

        String rechazo = suspension.getSUSP_RECHAZADO();
        switch (rechazo){
            case "Si" : rbtn_rechazo_si.setChecked(true); rbtn_rechazo_si.setEnabled(true); break;
            case "No" : rbtn_rechazo_no.setChecked(true); rbtn_rechazo_no.setEnabled(true); break;
        }


        txtLatitudGPS.setText(suspension.getSUSP_LATITUD());
        txtLongitudGPS.setText(suspension.getSUSP_LONGITUD());


        numFoto = 0;

        for (String foto: suspension.getFotos()){

            try {

                Bitmap foto_bitmap = DbBitmapUtility.decodeStringToBitmap(foto);
                asignarImagen(foto_bitmap);
                numFoto++;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}