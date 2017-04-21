package co.macrosystem.cobranzasmoviles.db;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.DbBitmapUtility;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.vista.MenuPrincipal;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public class ConstructorSuspensiones {

    private Context context;
    public static String estado = "";

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        ConstructorSuspensiones.estado = estado;
    }

    public ConstructorSuspensiones(Context context) {
        this.context = context;
    }


    public ArrayList<Suspension> obtenerDatos(String estado, String usuario){
        ArrayList<Suspension> suspensiones = new ArrayList<Suspension>();
        //Consultamos en SQLite
        BaseDatos db = new BaseDatos(context);

        /**
         * temporal porque este metodo es solo para obtener datos del SQLite
         */
        //obtenerSuspensionesWS(db);

        // LUEGO PODREMOS AUTOMATIZAR CON LOS WEB SERVICES
        suspensiones = db.obtenerSuspensionesSQLite(estado, usuario);

        return suspensiones;
    }

    /**
     * En este metodo ya tenemos el Conexto gracias al constructor de esta clase
     * por lo tanto podemos mostrar informacion en un Toast si queremos
     * @return cantidad de suspensiones cargadas por usuario y fecha
     */
    public int ObtenerCantSuspensionesCargadasSQLite(String usuario){
        int cantidad = 0;
        String user = usuario;
        String fechaCarga = "13/04/2017";
        BaseDatos db = new BaseDatos(context);
        cantidad = db.obtenerCantSuspensionesBD(user, fechaCarga);
        return cantidad;
    }

    /**
     *
     * @param suspension objeto de tipo Suspension llega con la informacion cargada proveniente del web service
     * @param
     */
    public void insertarSuspensionSQLite(Suspension suspension){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MATRICULA, suspension.getSUSP_MATRICULA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_PROCESO, suspension.getSUSP_NUM_PROCESO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_MEDIDOR, suspension.getSUSP_NUM_MEDIDOR());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SUSCRIPTOR, suspension.getSUSP_SUSCRIPTOR());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_DIRECCION, suspension.getSUSP_DIRECCION());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_CICLO, suspension.getSUSP_CICLO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MUNICIPIO, suspension.getSUSP_MUNICIPIO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_ACTIVIDAD, suspension.getSUSP_FECHA_ACTI());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_TIPO_ACTIVIDAD, suspension.getSUSP_TIPO_ACTI());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_ACCION, suspension.getSUSP_COD_ACCION());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_DESCR_ACCION, suspension.getSUSP_DESCR_ACCION());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_TECNICO, suspension.getSUSP_COD_TECNICO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_GLOSA, suspension.getSUSP_GLOSA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_PROVEEDOR, suspension.getSUSP_PROVEEDOR());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA, suspension.getSUSP_FECHA_CARGA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_USUARIO, suspension.getSUSP_USUARIO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO, suspension.getSUSP_ESTADO());
        //metoto que permite insertar una suspension

        db.InsertarSuspensionSQLite(contentValues);


    }

    //Enviamos la suspension a la capa de datos para ser insertada en SQLite
    //FULL YA ESTA LISTA
    public void procesarSuspension(Suspension suspension){

        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MATRICULA, suspension.getSUSP_MATRICULA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_STICKER, suspension.getSUSP_NUM_STICKER());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO_STICKER, suspension.getSUSP_ESTADO_STICKER());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SELLOSERIAL, suspension.getSUSP_SELLOSERIAL());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SELLOSERIAL_ESTA, suspension.getSUSP_SELLOSERIAL_ESTADO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COINC_MAT_MEDI, suspension.getSUSP_COINC_MAT_MEDI());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_CON_PAGO, suspension.getSUSP_CON_PAGO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_TIENE_ENERGIA, suspension.getSUSP_TIENE_ENERGIA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_LECTURA, suspension.getSUSP_LECTURA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NOM_CONTACTO, suspension.getSUSP_NOM_CONTACTO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_CONTACTO, suspension.getSUSP_NUM_CONTACTO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_OBSERVACIONES, suspension.getSUSP_OBSERVACIONES());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_RECHAZADO, suspension.getSUSP_RECHAZADO());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FOTO, "Pendiente por procesar");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_LATITUD, suspension.getSUSP_LATITUD());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_LONGITUD, suspension.getSUSP_LONGITUD());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_EJECU, suspension.getSUSP_FECHA_EJECUCION());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA, suspension.getSUSP_FECHA_CARGA());
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO, "procesadas");

        db.RegistrarSuspensionProcesada(contentValues);

    }



    public void procesarFotosSuspensionSQLite(Suspension suspension){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        for (String foto : suspension.getFotos()){

            Bitmap image = DbBitmapUtility.decodeStringToBitmap(foto);
            byte[] imageByte = DbBitmapUtility.encodeBitmapToBytes(image);

            contentValues.put(ConstantesBaseDatos.TABLE_FOTOS_FOTOBLOB, imageByte);
            contentValues.put(ConstantesBaseDatos.TABLE_FOTOS_SUSP_MATRICULA, suspension.getSUSP_MATRICULA());
            contentValues.put(ConstantesBaseDatos.TABLE_FOTOS_FECHA_CARGA, suspension.getSUSP_FECHA_CARGA());

            db.RegistrarSuspensionFotosMatricula(contentValues);

        }



    }

    public int obtenerSuspensionesRestantesEstado(String estado, String usuario){
        int total = 0;
        BaseDatos db = new BaseDatos(context);

        total = db.obtenerCantSuspensionesEstadoSQLite(estado, usuario);

        return  total;
    }






}
