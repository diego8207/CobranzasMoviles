package co.macrosystem.cobranzasmoviles.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.pojo.Suspension;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public class ConstructorSuspensiones {

    private Context context;


    public ConstructorSuspensiones(Context context) {
        this.context = context;
    }


    public ArrayList<Suspension> obtenerDatos(String estado){
        ArrayList<Suspension> suspensiones = new ArrayList<Suspension>();
        //Consultamos en SQLite
        BaseDatos db = new BaseDatos(context);

        /**
         * temporal porque este metodo es solo para obtener datos del SQLite
         */
        //registrarSuspensionesSQLite(db);

        // LUEGO PODREMOS AUTOMATIZAR CON LOS WEB SERVICES
        suspensiones = db.obtenerSuspensionesSQLite(estado);

        return suspensiones;
    }

    public ArrayList<Suspension> obtenerSuspensionesWebService(){
        /**
         * Aqui estamos insertando en SQLite datos Dummy pero pronto se implementara info de un web service
         */
        ArrayList<Suspension> suspensiones = new ArrayList<Suspension>();
        //vamos a poner informacion de fortma Dummy pero este ArrayList se debe llenar a ártir de un consumo de web service
        suspensiones.add(new Suspension("86403","70753452","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904","Susver BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        suspensiones.add(new Suspension("34018","70768685","8113426","GUTIERREZ TRILLERAS ARGENIS","9 - Ibague 9","1 - IBAGUE","MNZ 4 CS.23 ETP.1 SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Rec BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        suspensiones.add(new Suspension("23986","70769782","9346859","BOTERO SERNA ROSA AYDEE","9 - Ibague 9","1 - IBAGUE","MNZ 5 CS.30 1ET.C.S.BOLIVAR","27/02/2017" ,"11 - Suspension","904","Susver BT Bornera","875", "se realiza suspension","80","Dvargas","procesadas", "27/02/2017"));
        suspensiones.add(new Suspension("90123","70769307","6677006099","LUZ MARINA SOTO","9 - Ibague 9","1 - IBAGUE","APT 13 CS.9 2ETAPA C.S.BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Rec BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        suspensiones.add(new Suspension("43210","70771747","60405036","VASQUEZ PRIETO GILMA MARIA","9 - Ibague 9","1 - IBAGUE","MNZ 17 CS 10 2DA ET SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904","Susver BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        suspensiones.add(new Suspension("230705","70754192","20111010710","COFLES DE REYES MARIA LUISA","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904","Susver BT Bornera","875", "se realiza suspension","80","Dvargas","subidas", "27/02/2017"));
        suspensiones.add(new Suspension("227007","70769793","6677140376","AMINTA MARTINEZ","9 - Ibague 9","1 - IBAGUE","MNZ 4 CS.23 ETP.1 SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Rec BT Bornera","875", "se realiza suspension","80","Dvargas","subidas", "27/02/2017"));
        suspensiones.add(new Suspension("215354","70768662","6677138873","ACOSTA ROJAS REINA ISABEL","9 - Ibague 9","1 - IBAGUE","MNZ 5 CS.30 1ET.C.S.BOLIVAR","27/02/2017" ,"11 - Suspension","904","Susver BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        suspensiones.add(new Suspension("215367","6677138865","6677006099","CASTRO BUITRAGO CARMENZA","9 - Ibague 9","1 - IBAGUE","APT 13 CS.9 2ETAPA C.S.BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Rec BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        suspensiones.add(new Suspension("428350","70753805","20101006357","ARIAS BEDOYA OMAIRA","9 - Ibague 9","1 - IBAGUE","MNZ 17 CS 10 2DA ET SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904","Susver BT Bornera","875", "se realiza suspension","80","Dvargas","restantes", "27/02/2017"));
        return suspensiones;
    }

    public boolean registrarSuspensionesSQLite(BaseDatos db){
        ArrayList<Suspension> suspensiones = new ArrayList<Suspension>();
        suspensiones = obtenerSuspensionesWebService();
        //Toast.makeText(context, "Usuario: " + suspensiones.get(0).getSUSP_FECHA_CARGA(), Toast.LENGTH_SHORT).show();
        for (Suspension suspension: suspensiones) {
            insertarSuspension(suspension, db);
        }
        return true;
    }

    /**
     * En este metodo ya tenemos el Conexto gracias al constructor de esta clase
     * por lo tanto podemos mostrar informacion en un Toast si queremos
     * @return cantidad de suspensiones cargadas por usuario y fecha
     */
    public int ObtenerTotalSuspensionesCargadas(){
        int cantidad = 0;
        String user = "Dvargas";
        String fechaCarga = "27/02/2017";
        BaseDatos db = new BaseDatos(context);
        cantidad = db.totalSuspensionesCargadasDia(user, fechaCarga);
        return cantidad;
    }

    /**
     *
     * @param suspension objeto de tipo Suspension llega con la informacion cargada proveniente del web service
     * @param db
     */
    public void insertarSuspension(Suspension suspension, BaseDatos db){
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

        db.RegistrarSuspensionProcesada(contentValues);

    }

    public int obtenerSuspensionesRestantesEstado(String estado){
        int total = 0;
        BaseDatos db = new BaseDatos(context);
        total = db.obtenerCantSuspensionesEstadoSQLite(estado);
        return  total;
    }

}
