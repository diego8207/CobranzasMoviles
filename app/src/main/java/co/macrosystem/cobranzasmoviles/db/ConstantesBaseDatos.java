package co.macrosystem.cobranzasmoviles.db;

/**
 * Created by Diego Velez on 26/02/2017.
 */

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME                        = "formularios";
    public static final int DATABASE_VERSION                        = 1;

    public static final String TABLE_USUARIO                        = "usuario";
    public static final String TABLE_USUARIO_ID                     = "USUA_ID";
    public static final String TABLE_USUARIO_USUARIO                = "USUA_USUARIO";
    public static final String TABLE_USUARIO_PASSWORD               = "USUA_PASSWORD";
    public static final String TABLE_USUARIO_ESTADO                 = "USUA_ESTADO";
    public static final String TABLE_USUARIO_ROL                    = "ROL_NOMBRE";
    public static final String TABLE_USUARIO_NOMAPE                 = "NOMAPE";

    public static final String TABLE_SUSPENSIONES                   = "suspensiones";
    public static final String TABLE_SUSPENSIONES_MATRICULA         = "SUSP_MATRICULA";
    public static final String TABLE_SUSPENSIONES_NUM_PROCESO       = "NUM_PROCESO";
    public static final String TABLE_SUSPENSIONES_NUM_MEDIDOR       = "NUM_MEDIDOR";
    public static final String TABLE_SUSPENSIONES_SUSCRIPTOR        = "SUSCRIPTOR";
    public static final String TABLE_SUSPENSIONES_CICLO             = "CICLO";
    public static final String TABLE_SUSPENSIONES_MUNICIPIO         = "MUNICIPIO";
    public static final String TABLE_SUSPENSIONES_DIRECCION         = "DIRECCION";
    public static final String TABLE_SUSPENSIONES_FECHA_REVIS       = "FECHA_REVIS";
    public static final String TABLE_SUSPENSIONES_REVISION_DESCRIP  = "REVISION_DESCRIP";
    public static final String TABLE_SUSPENSIONES_ACCION            = "ACCION";
    public static final String TABLE_SUSPENSIONES_GLOSA             = "GLOSA";
    public static final String TABLE_SUSPENSIONES_PROVEEDOR         = "PROVEEDOR";
    //faltan los demas campos continuar ...
}
