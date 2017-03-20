package co.macrosystem.cobranzasmoviles.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.pojo.Usuario;
import static co.macrosystem.cobranzasmoviles.db.ConstantesBaseDatos.DATABASE_NAME;
import static co.macrosystem.cobranzasmoviles.db.ConstantesBaseDatos.DATABASE_VERSION;

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaPersona = "CREATE TABLE "                 + ConstantesBaseDatos.TABLE_PERSONA + "(" +
                ConstantesBaseDatos.TABLE_PERSONA_IDENTIFICACION        + " TEXT PRIMARY KEY, " +
                ConstantesBaseDatos.TABLE_PERSONA_TIPODOC               + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_NOMBRES               + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_APELLIDOS             + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_SEXO                  + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_FECHANACIMIENTO       + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_TELEFONO              + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_EMAIL                 + " TEXT, " +
                ConstantesBaseDatos.TABLE_PERSONA_DIRECCION             + " TEXT  " +
                ")";

        String queryCrearTablaUsuario = "CREATE TABLE "                 + ConstantesBaseDatos.TABLE_USUARIO + "(" +
                ConstantesBaseDatos.TABLE_USUARIO_USUARIO               + " TEXT PRIMARY KEY, " +
                ConstantesBaseDatos.TABLE_USUARIO_IDENTIFICACION        + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_PASSWORD              + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_FECHAINI              + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_FECHAFIN              + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_ESTADO                + " TEXT, " +
                "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_USUARIO_IDENTIFICACION + ") REFERENCES " +
                    ConstantesBaseDatos.TABLE_PERSONA + "(" + ConstantesBaseDatos.TABLE_PERSONA_IDENTIFICACION + "))";


        String queryCrearTablaSuspension = "CREATE TABLE " + ConstantesBaseDatos.TABLE_SUSPENSIONES + "(" +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_MATRICULA        + " TEXT PRIMARY KEY, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_PROCESO      + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_MEDIDOR      + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_SUSCRIPTOR       + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_CICLO            + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_MUNICIPIO        + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_DIRECCION        + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_ACTIVIDAD  + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_TIPO_ACTIVIDAD   + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_ACCION       + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_DESCR_ACCION     + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_TECNICO      + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_GLOSA            + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_PROVEEDOR        + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_USUARIO          + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO           + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_STICKER      + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO_STICKER   + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_SELLOSERIAL      + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_SELLOSERIAL_ESTA + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_COINC_MAT_MEDI   + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_CON_PAGO         + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_TIENE_ENERGIA    + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_LECTURA          + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NOM_CONTACTO     + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_CONTACTO     + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_OBSERVACIONES    + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_RECHAZADO        + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_FOTO             + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_LATITUD          + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_LONGITUD         + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_EJECU      + " TEXT, "  +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA      + " TEXT, "  +
                "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_SUSPENSIONES_USUARIO + ") REFERENCES " +
                ConstantesBaseDatos.TABLE_USUARIO + "("+ConstantesBaseDatos.TABLE_USUARIO_USUARIO + "))";

        db.execSQL(queryCrearTablaPersona);
        db.execSQL(queryCrearTablaUsuario);
        db.execSQL(queryCrearTablaSuspension);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_SUSPENSIONES);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PERSONA);
        onCreate(db);
    }



    //un ejemplo con ContentValues
    public void InsertarSuspensionSQLite(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_SUSPENSIONES, null, contentValues);
        db.close();
    }


    //Agregar la gestion del Web Service para obtener el usuario desde la database remota de Gestion Renovadora
    //ESTA SIN TERMINAR
    public void ConsultarSuspensionesPorUser(BaseDatos db){
        Suspension suspension = new Suspension();
        ArrayList<Suspension> suspensions = new ArrayList<>();

        //consultar medntValueiante web service y llenar un objeto Suspension

        //insertar en sqlite
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MATRICULA, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_PROCESO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_MEDIDOR, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SUSCRIPTOR, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_CICLO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_MUNICIPIO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_DIRECCION, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_ACTIVIDAD, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_TIPO_ACTIVIDAD, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_ACCION, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_DESCR_ACCION, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COD_TECNICO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_GLOSA, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_PROVEEDOR, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_USUARIO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_STICKER, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_ESTADO_STICKER, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SELLOSERIAL, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_SELLOSERIAL_ESTA, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_COINC_MAT_MEDI, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_CON_PAGO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_TIENE_ENERGIA, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_LECTURA, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NOM_CONTACTO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_CONTACTO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_RECHAZADO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FOTO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_LATITUD, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_LONGITUD, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_EJECU, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA, /*a continuacion el valor obtenido del WS */ "");
        InsertarSuspensionSQLite(contentValues);
    }



    public Usuario ValidarUsuario(String usuario, String password){
        Usuario u = null;
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_USUARIO +
                " WHERE " + ConstantesBaseDatos.TABLE_USUARIO_USUARIO + " = " + usuario +
                " AND " + ConstantesBaseDatos.TABLE_USUARIO_PASSWORD + " = " + password;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            u = new Usuario();
            u.setUsua_usuario(registros.getString(1));
            u.setUsua_estado(registros.getString(3));
            u.setRol_nombre(registros.getString(4));
            u.setNomape(registros.getString(5));
        }
        db.close();
        return u;
    }

    //Metodo full, se obtienen todas las ordenes de suspension que se encuentra en SQLite
    public ArrayList<Suspension> obtenerSuspensionesSQLite(){
        ArrayList<Suspension> supensiones = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_SUSPENSIONES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Suspension suspensionActual = new Suspension();
            suspensionActual.setSUSP_MATRICULA(registros.getString(0));
            suspensionActual.setSUSP_NUM_PROCESO(registros.getString(1));
            suspensionActual.setSUSP_NUM_MEDIDOR(registros.getString(2));
            suspensionActual.setSUSP_SUSCRIPTOR(registros.getString(3));
            suspensionActual.setSUSP_CICLO(registros.getString(4));
            suspensionActual.setSUSP_MUNICIPIO(registros.getString(5));
            suspensionActual.setSUSP_DIRECCION(registros.getString(6));
            suspensionActual.setSUSP_FECHA_ACTI(registros.getString(7));
            suspensionActual.setSUSP_TIPO_ACTI(registros.getString(8));
            suspensionActual.setSUSP_COD_ACCION(registros.getString(9));
            suspensionActual.setSUSP_DESCR_ACCION(registros.getString(10));
            suspensionActual.setSUSP_COD_TECNICO(registros.getString(11));
            suspensionActual.setSUSP_GLOSA(registros.getString(12));
            suspensionActual.setSUSP_PROVEEDOR(registros.getString(13));
            supensiones.add(suspensionActual);
        }

        db.close();

        return supensiones;
    }

    public void RegistrarSuspensionProcesada(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_SUSPENSIONES, null, contentValues);
        db.close();

    }



}
