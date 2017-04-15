package co.macrosystem.cobranzasmoviles.vista;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import co.macrosystem.cobranzasmoviles.ExpandAndCollapseViewUtil;
import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.db.BaseDatos;
import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import static co.macrosystem.cobranzasmoviles.db.ConstantesBaseDatos.Metodo;
import static co.macrosystem.cobranzasmoviles.db.ConstantesBaseDatos.accionSoap;
import static co.macrosystem.cobranzasmoviles.db.ConstantesBaseDatos.namespace;
import static co.macrosystem.cobranzasmoviles.db.ConstantesBaseDatos.url;

public class MenuPrincipal extends AppCompatActivity implements iMenuPrincipalView {

    private Context context;
    private ArrayList<Suspension> suspensiones = null;
    private ConstructorSuspensiones constructorSuspensiones;

    private boolean boolres=false;
    private ArrayList<Suspension> suspensionesWS;
    private ArrayAdapter<Suspension> adapter;
    private SharedPreferences datos_compartidos;
    private String usuarioShare;

    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private TextView numSuspensionesCargadas;
    private TextView numSuspensionesSubidas;
    private TextView numSuspensionesProcesadas;
    private TextView numSuspensionesRestantes;

    private Toolbar toolbarCard;
    Toolbar toolbar;
    private Intent intent;
    private static final int DURATION = 250;
    private boolean internet = false;
    private int consecutivoHilo = 0; //VARIABLE QUE SE UTILIZARA PARA CONTROLAR LA CANTIDAD DE PROCESOS EN EL AsyncTask Y PODER ACTUALIZAR EL MENSAJE DEL ProgressBar
    private int numSuspensiones = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        context = this.getBaseContext();

        //Ejemplo de como Recuperar datos de un SharePrefereces
        datos_compartidos = getSharedPreferences("usuarioCompartido", 0);
        usuarioShare = datos_compartidos.getString("usuario", "");
        Toast.makeText(this, "usuario: " + usuarioShare , Toast.LENGTH_SHORT).show();

        numSuspensionesCargadas = (TextView) findViewById(R.id.txtSuspCargadas);
        numSuspensionesRestantes = (TextView) findViewById(R.id.lblCantRestantes);
        numSuspensionesSubidas = (TextView) findViewById(R.id.lblCantSubidas);
        numSuspensionesProcesadas = (TextView) findViewById(R.id.lblCantProcesadas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageViewExpand = (ImageView) findViewById(R.id.imageViewExpand);
        linearLayoutDetails = (ViewGroup) findViewById(R.id.linearLayoutDetails);
        toolbarCard = (Toolbar) findViewById(R.id.toolbarCardSuspensiones);

        inicializarToolBarPrincipal();
        inializararToolBarCV(context);
        //validarInternet(context); por ahora no vamos a validar internet al inicio


        obternetSuspensionesAlmacenadasServer();
        mostrarCantidades(context);
        numSuspensiones = constructorSuspensiones.ObtenerCantSuspensionesCargadasSQLite(usuarioShare);

    }

    public void mostrarCantidades(Context context){
        numSuspensionesRestantes.setText(String.valueOf(constructorSuspensiones.obtenerSuspensionesRestantesEstado("restantes", usuarioShare)));
        numSuspensionesSubidas.setText(String.valueOf(constructorSuspensiones.obtenerSuspensionesRestantesEstado("subidas", usuarioShare)));
        numSuspensionesProcesadas.setText(String.valueOf(constructorSuspensiones.obtenerSuspensionesRestantesEstado("procesadas", usuarioShare)));
    }

    public String fechaDeHoy(){
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaActual);
    }

    @Override
    public void toggleDetailsSuspensiones(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotateSuspensiones(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotateSuspensiones(180.0f);
        }
    }

    @Override
    public void rotateSuspensiones(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }

    //OJO HAY QUE PASAR COMO PARAMETROS EL USUARIO Y LA FECHA PARA QUE LA CONSULTA QUEDE DINAMICA ----------------------------------
    public void obternetSuspensionesAlmacenadasServer() {
        //Toast.makeText(context, "Entramos a obternetSuspensionesAlmacenadasServer", Toast.LENGTH_SHORT).show();

        constructorSuspensiones = new ConstructorSuspensiones(context);

        if (numSuspensiones == 0){
            ProgressDialog progress = new ProgressDialog(this);

                new SuspensionesAsyncTask(progress, this).execute();

            numSuspensionesCargadas.setText("No hay Suspensiones Cargadas: " + numSuspensiones);


        }else{

        }
    }


    @Override
    public void inializararToolBarCV(final Context context){
        toolbarCard.setTitle(R.string.title_card_suspensiones);
        //subtitulo de la barra de la tarjeta
        toolbarCard.setSubtitle("Fecha: "+ fechaDeHoy());
        toolbarCard.inflateMenu(R.menu.menu_card);

        toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mSincronizar:
                        BaseDatos db = new BaseDatos(context);

                        obternetSuspensionesAlmacenadasServer();


                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void inicializarToolBarPrincipal(){
        Context context = this.getBaseContext();
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.logo_cobranzas_title);
        setSupportActionBar(toolbar);
    }


    public void visualizarSuspensionesRestantes(View view){
        intent = new Intent(context, SuspensionesActivity.class);
        intent.putExtra("estado", "restantes");
        startActivity(intent);
    }

    public void visualizarSuspensionesSubidas(View view){
        intent = new Intent(context, SuspensionesActivity.class);
        intent.putExtra("estado", "subidas");
        startActivity(intent);
    }

    public void visualizarSuspensionesProcesadas(View view){
        intent = new Intent(context, SuspensionesActivity.class);
        intent.putExtra("estado", "procesadas");
        startActivity(intent);
    }



    private Boolean ValidarConexionInternet(){
        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com.co");
            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }





    private Suspension leerSoap(SoapObject soapObj){

        Suspension suspension = new Suspension();
        String SUSP_MATRICULA = soapObj.getProperty("SUSP_MATRICULA").toString();
        String SUSP_NUM_PROCESO = soapObj.getProperty("SUSP_NUM_PROCESO").toString();
        String SUSP_NUM_MEDIDOR = soapObj.getProperty("SUSP_NUM_MEDIDOR").toString();
        String SUSP_SUSCRIPTOR = soapObj.getProperty("SUSP_SUSCRIPTOR").toString();
        String SUSP_CICLO = soapObj.getProperty("SUSP_CICLO").toString();
        String SUSP_MUNICIPIO = soapObj.getProperty("SUSP_MUNICIPIO").toString();
        String SUSP_DIRECCION = soapObj.getProperty("SUSP_DIRECCION").toString();
        String SUSP_FECHA_ACTI = soapObj.getProperty("SUSP_FECHA_ACTI").toString();
        String SUSP_TIPO_ACTI = soapObj.getProperty("SUSP_TIPO_ACTI").toString();
        String SUSP_COD_ACCION = soapObj.getProperty("SUSP_COD_ACCION").toString();
        String SUSP_DESCR_ACCION = soapObj.getProperty("SUSP_DESCR_ACCION").toString();
        String SUSP_COD_TECNICO = soapObj.getProperty("SUSP_COD_TECNICO").toString();
        String SUSP_GLOSA = soapObj.getProperty("SUSP_GLOSA").toString();
        String SUSP_PROVEEDOR = soapObj.getProperty("SUSP_PROVEEDOR").toString();
        String SUSP_ESTADO = soapObj.getProperty("SUSP_ESTADO").toString();
        String SUSP_FECHA_CARGA = soapObj.getProperty("SUSP_FECHA_CARGA").toString();

        Log.i("MATRICULA: ", SUSP_MATRICULA + " - " + SUSP_SUSCRIPTOR + " - Estado: " + SUSP_ESTADO);

        suspension = new Suspension(SUSP_MATRICULA, SUSP_NUM_PROCESO, SUSP_NUM_MEDIDOR, SUSP_SUSCRIPTOR, SUSP_CICLO, SUSP_MUNICIPIO, SUSP_DIRECCION, SUSP_FECHA_ACTI, SUSP_TIPO_ACTI, SUSP_COD_ACCION, SUSP_DESCR_ACCION, SUSP_COD_TECNICO, SUSP_GLOSA, SUSP_PROVEEDOR, usuarioShare, "restantes", SUSP_FECHA_CARGA);

        return suspension;
    }



    /**
     * LOS PARAMETROS SON:
     * EL PRIMER Void ES EL MISMO Void DE doInBackground QUE ES EL TIPO DE DATOS DEL PARAMETRO SI RECIBE ESTE SEGUNDO HILO
     * EL SEGUNDO PARAMETRO Integer, ES EL TIPO DE DATOS CON EL QUE SE ACTUALIZA EL PROGRESO
     * EL TERCER PARAMETRO ES EL PARAMETRO DE SALIDA DE doInBackground Y ESTA SALIDA ES LO QUE TOMA COMO PARAMETRO DE ENTRADA EL METODO onPostExecute
     */
    public class SuspensionesAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        ProgressDialog progressBar;
        MenuPrincipal menuPrincipal;

        public SuspensionesAsyncTask(ProgressDialog progressBar, MenuPrincipal menuPrincipal) {
            this.progressBar = progressBar;
            this.menuPrincipal = menuPrincipal;
        }

        /**
         * ESTA FUNCION ES LA QUE SE EJECUTA EN EL HILO PRINCIPAL DE LA APP
         * AQUI SE DECLARAN E INICIAN VARIABLES, PREPARAR COMPONENTES
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            internet = ValidarConexionInternet();
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            if(internet){
                progressBar.setMessage("Consultando Suspensiones ... ");
                progressBar.show();
            }

        }

        /**
         * AQUI ES LO QUE SE HACE EN SEGUNDO PLANO, ES LA TAREA LARGA
         * PODEMOS INVOCAR AL METODO AUXILIAR publish progressBar que permite comunicarse con el hilo principal para informar el progreso del proceso
         *
         * @param voids
         * @return
         */
        @Override
        protected Boolean doInBackground(Void... voids) {
            if (internet){
                try {
                    SoapObject request = new SoapObject(namespace, Metodo);
                    request.addProperty("usuario", usuarioShare);//por ahora usamos usuario Dummy
                    SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope. VER11);
                    //sobre.dotNet = true;
                    sobre.setOutputSoapObject(request);
                    HttpTransportSE transporte = new HttpTransportSE(url);
                    transporte.call(accionSoap, sobre);    // Llamada
                    Vector<?> responseVector=null;
                    SoapObject soapObject=null;
                    suspensionesWS = new ArrayList<>();
                    if(sobre.getResponse() instanceof Vector)
                        responseVector = (Vector<?>) sobre.getResponse();//almacenar en vector
                    else
                        soapObject=(SoapObject)sobre.getResponse();
                    if(responseVector!=null){
                        int count=responseVector.size();

                        constructorSuspensiones = new ConstructorSuspensiones(context);
                        for (int i = 0; i <count; ++i) { //Cada registro encontrado
                            SoapObject test=(SoapObject)responseVector.get(i);
                            publishProgress(i*100/count);
                            //AQUI ES DONDE DEBEMOS INSERTAR EN SQLITE - YA ESTAN CARGADAS TODAS LAS SUSPENSIONES
                            Suspension suspension = leerSoap(test);
                            constructorSuspensiones.insertarSuspensionSQLite(suspension);
                            suspensionesWS.add(suspension);
                        }

                        numSuspensiones = suspensionesWS.size();


                    }else{
                        if(soapObject!=null)
                            suspensionesWS.add(leerSoap(soapObject));
                    }
                } catch (Exception e) {

                    Log.e("ERROR", "No se pudo establecer conexion con el Servidor. " + e.getMessage());
                }
            }

            return true;
        }

        /**
         * FUNCION QUE SE EJECUTA EN EL HILO PRINCIPAL CUANDO UNO EJECUTA UNA LLAMADA AL publish progressBar
         * SE PUEDE INFORMAR EL PORCENTAJE DE PROGRESO
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());

            //actulizamos el mensaje en la barra de progreso
            if (consecutivoHilo == 1){
                progressBar.setMessage("Descargando Suspensiones ... ");
            }
        }

        /**
         * SE EJECUTA DESPUES DEL doInBackground Y SE PUEDE MOSTRAR POR EJEMPLO LOS MENSAJES
         * DE FINALIZADO DEL PROCESO CON UN Toast.
         *
         * @param resultado
         */
        @Override
        protected void onPostExecute(Boolean resultado) {
            super.onPostExecute(resultado);
            progressBar.dismiss();
            consecutivoHilo = 0;
            mostrarCantidades(context);

            numSuspensionesCargadas.setText("Cargadas por analista: " + numSuspensiones);
            if (resultado) {
                if (internet){
                    Toast.makeText(menuPrincipal, "¡ Sincronizacion exitosa !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(menuPrincipal, "No hay conexion a Internet para sincronizar", Toast.LENGTH_SHORT).show();
                }

            }

        }

        /**
         * SI SE CORTA LA EJECUCION DEL SEGUNDO HILO SE EJECUTA ESTA FUNCION,
         * SE PUEDEN CERRAR CONEXIONES PARA LIBERAR LA MEMORIA
         */
        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(menuPrincipal, "Tarea Larga cancelada en AsyncTask", Toast.LENGTH_SHORT).show();
        }

        private void UnSegundo() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

    }

}
