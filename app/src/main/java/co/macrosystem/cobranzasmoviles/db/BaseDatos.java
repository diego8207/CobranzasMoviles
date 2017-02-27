package co.macrosystem.cobranzasmoviles.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import co.macrosystem.cobranzasmoviles.Usuario;
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
        String queryCrearTablaUsuario = "CREATE TABLE "                 + ConstantesBaseDatos.TABLE_USUARIO + "(" +
                ConstantesBaseDatos.TABLE_USUARIO_ID                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_USUARIO_USUARIO               + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_PASSWORD              + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_ESTADO                + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_ROL                   + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_NOMAPE                + " TEXT"   +
                ")";

        String queryCrearTablaSuspension = "CREATE TABLE " + ConstantesBaseDatos.TABLE_SUSPENSIONES + "(" +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_MATRICULA        + " TEXT PRIMARY KEY, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_PROCESO      + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_NUM_MEDIDOR      + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_SUSCRIPTOR       + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_CICLO            + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_MUNICIPIO        + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_DIRECCION        + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_FECHA_REVIS      + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_REVISION_DESCRIP + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_ACCION           + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_GLOSA            + " TEXT, " +
                ConstantesBaseDatos.TABLE_SUSPENSIONES_PROVEEDOR        + " TEXT "  +
                ")";

        db.execSQL(queryCrearTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_USUARIO);
        onCreate(db);
    }

    public void InsertarUsuario(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_USUARIO, null, contentValues);
        db.close();
    }

    //Agregar la gestion del Web Service para obtener el usuario desde la database remota de Gestion Renovadora
    public void ActualizarDbUsuario(BaseDatos db){
        Usuario usuario = new Usuario();
        //consultar mediante web service y llenar un objeto Usuario

        //insertar en sqlite
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_USUARIO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_ESTADO, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_ROL, /*a continuacion el valor obtenido del WS */ "");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_NOMAPE, /*a continuacion el valor obtenido del WS */ "");
        InsertarUsuario(contentValues);
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


}
