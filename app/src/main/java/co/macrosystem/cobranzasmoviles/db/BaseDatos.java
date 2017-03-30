package co.macrosystem.cobranzasmoviles.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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

    /**
     * método que permite insertar en SQLite las suspensiones que vendran de la base de datos remota
     * a través de un Web Service.
     */
    public void InsertarSuspensionSQLite(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_SUSPENSIONES, null, contentValues);
        db.close();
    }




    //Metodo full, se obtienen todas las ordenes de suspension que se encuentra en SQLite
    public ArrayList<Suspension> obtenerSuspensionesSQLite(){
        ArrayList<Suspension> supensiones = new ArrayList<>();
        String query = "SELECT SUSP_MATRICULA,  SUSP_NUM_PROCESO, SUSP_NUM_MEDIDOR, SUSP_SUSCRIPTOR, SUSP_CICLO, SUSP_MUNICIPIO, SUSP_DIRECCION, " +
                        "SUSP_FECHA_ACTI, SUSP_TIPO_ACTI, SUSP_COD_ACCION, SUSP_DESCR_ACCION, SUSP_COD_TECNICO, SUSP_GLOSA, SUSP_PROVEEDOR, SUSP_FECHA_CARGA, SUSP_USUARIO " +
                "FROM " + ConstantesBaseDatos.TABLE_SUSPENSIONES +
                " WHERE SUSP_ESTADO like '" + "restantes" + "'" ;
//                " AND " + ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA + " = '" + fechaCarga + "'";
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
            suspensionActual.setSUSP_FECHA_CARGA(registros.getString(14));
            suspensionActual.setSUSP_USUARIO(registros.getString(15));
            supensiones.add(suspensionActual);
        }

        db.close();

        return supensiones;
    }
    //implementada para mostrar la cantidad de Suspensiones cargadas en SQLite segun usuario y fecha
    public int totalSuspensionesCargadasDia(String user, String fechaCarga){
        int total = 0;
        String query = "SELECT count(*) FROM " + ConstantesBaseDatos.TABLE_SUSPENSIONES +
                " WHERE " + ConstantesBaseDatos.TABLE_SUSPENSIONES_USUARIO + " = '" + user + "'" +
                " AND " + ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_CARGA + " = '" + fechaCarga + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        registros.moveToFirst();
        total = registros.getInt(0);
        registros.close();
        db.close();
        return total;
    }

    //Procesar suspension y almacenarla en SQLite
    public void RegistrarSuspensionProcesada(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_SUSPENSIONES, null, contentValues);
        db.close();
    }

    public int obtenerCantSuspensionesEstadoSQLite(String estado){
        int total = 0;
        String query = "SELECT count(*) FROM SUSPENSIONES WHERE SUSP_ESTADO like '"+ estado + "' ";
        //Toast.makeText(context, query + total, Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        registros.moveToFirst();
        total = registros.getInt(0);
        //Toast.makeText(context, "TOTAL ------> " + total, Toast.LENGTH_SHORT).show();
        registros.close();
        db.close();
        db.close();

        return total;
    }
}




