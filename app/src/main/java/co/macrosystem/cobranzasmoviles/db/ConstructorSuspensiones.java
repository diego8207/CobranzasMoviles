package co.macrosystem.cobranzasmoviles.db;

import android.content.ContentValues;
import android.content.Context;

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

    public ArrayList<Suspension> obtenerDatos(){
        ArrayList<Suspension> suspensiones = new ArrayList<Suspension>();
        //Consultamos en SQLite
        BaseDatos db = new BaseDatos(context);
        //insertarSuspensiones(db); //SOLO SE DEBE EJECUTAR POR AHORA MIENTRAS SE LLENA INICIALMENTE LA BASE DE DATOS
        // LUEGO PODREMOS AUTOMATIZAR CON LOS WEB SERVICES
        suspensiones = db.obtenerSuspensionesSQLite();


        /*
        //vamos a poner informacion de fortma Dummy pero este ArrayList se debe llenar a ártir de un consumo de web service
        suspensiones.add(new Suspension("86403","70506190","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Susver BT Bornera","875", "se realiza suspension","80","Dvargas","Activo", "27/02/2017"));
        suspensiones.add(new Suspension("34018","70506190","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Susver BT Bornera","875", "se realiza suspension","80","Dvargas","Activo", "27/02/2017"));
        suspensiones.add(new Suspension("23986","70506190","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Susver BT Bornera","875", "se realiza suspension","80","Dvargas","Activo", "27/02/2017"));
        suspensiones.add(new Suspension("90123","70506190","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Susver BT Bornera","875", "se realiza suspension","80","Dvargas","Activo", "27/02/2017"));
        suspensiones.add(new Suspension("43210","70506190","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Susver BT Bornera","875", "se realiza suspension","80","Dvargas","Activo", "27/02/2017"));
        */

        return suspensiones;
    }

    public void insertarSuspensiones(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MATRICULA, "86403");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_PROCESO, "70753452");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_MEDIDOR, "20101009828");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SUSCRIPTOR, "NOEL TORRES RINCON");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_DIRECCION, "MNZ 3 CASA 10 1ET.SIMON BOLIVAR");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_CICLO, "9 - Ibague 9");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MUNICIPIO, "1 - IBAGUE");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_ACTIVIDAD, "28/02/2017");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_TIPO_ACTIVIDAD, "11 - Suspension");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_ACCION, "904");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_DESCR_ACCION, " Susver BT Bornera");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_TECNICO, "875");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_GLOSA, "se realiza suspension");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_PROVEEDOR, "80");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA, "21/03/2017");

        db.InsertarSuspensionSQLite(contentValues);

    }

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

}
