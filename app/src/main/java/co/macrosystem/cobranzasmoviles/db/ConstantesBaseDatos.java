package co.macrosystem.cobranzasmoviles.db;

/**
 * Created by Diego Velez on 26/02/2017.
 */

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME                        = "formulario_suspensiones";
    public static final int DATABASE_VERSION                        = 1;

    public static final String TABLE_PERSONA                        = "persona";
    public static final String TABLE_PERSONA_IDENTIFICACION         = "PER_IDENTIFICACION";
    public static final String TABLE_PERSONA_TIPODOC                = "PER_TIPODOC";
    public static final String TABLE_PERSONA_NOMBRES                = "PER_NOMBRES";
    public static final String TABLE_PERSONA_APELLIDOS              = "PER_APELLIDOS";
    public static final String TABLE_PERSONA_SEXO                   = "PER_SEXO";
    public static final String TABLE_PERSONA_FECHANACIMIENTO        = "PER_FECHANACIMIENTO";
    public static final String TABLE_PERSONA_TELEFONO               = "PER_TELEFONO";
    public static final String TABLE_PERSONA_EMAIL                  = "PER_EMAIL";
    public static final String TABLE_PERSONA_DIRECCION              = "PER_DIRECCION";


    public static final String TABLE_USUARIO                        = "usuario";
    public static final String TABLE_USUARIO_USUARIO                = "USUA_USUARIO";
    public static final String TABLE_USUARIO_IDENTIFICACION         = "PER_IDENTIFICACION";
    public static final String TABLE_USUARIO_PASSWORD               = "USUA_PASSWORD";
    public static final String TABLE_USUARIO_FECHAINI               = "USUA_FECHAINI";
    public static final String TABLE_USUARIO_FECHAFIN               = "USUA_FECHAFIN";
    public static final String TABLE_USUARIO_ESTADO                 = "USUA_ESTADO";


    public static final String TABLE_SUSPENSIONES                   = "suspensiones";
    public static final String TABLE_SUSPENSIONES_MATRICULA         = "SUSP_MATRICULA";
    public static final String TABLE_SUSPENSIONES_NUM_PROCESO       = "SUSP_NUM_PROCESO";
    public static final String TABLE_SUSPENSIONES_NUM_MEDIDOR       = "SUSP_NUM_MEDIDOR";
    public static final String TABLE_SUSPENSIONES_SUSCRIPTOR        = "SUSP_SUSCRIPTOR";
    public static final String TABLE_SUSPENSIONES_CICLO             = "SUSP_CICLO";
    public static final String TABLE_SUSPENSIONES_MUNICIPIO         = "SUSP_MUNICIPIO";
    public static final String TABLE_SUSPENSIONES_DIRECCION         = "SUSP_DIRECCION";
    public static final String TABLE_SUSPENSIONES_FECHA_ACTIVIDAD   = "SUSP_FECHA_ACTI";
    public static final String TABLE_SUSPENSIONES_TIPO_ACTIVIDAD    = "SUSP_TIPO_ACTI";
    public static final String TABLE_SUSPENSIONES_COD_ACCION        = "SUSP_COD_ACCION";
    public static final String TABLE_SUSPENSIONES_DESCR_ACCION      = "SUSP_DESCR_ACCION";
    public static final String TABLE_SUSPENSIONES_COD_TECNICO       = "SUSP_COD_TECNICO";
    public static final String TABLE_SUSPENSIONES_GLOSA             = "SUSP_GLOSA";
    public static final String TABLE_SUSPENSIONES_PROVEEDOR         = "SUSP_PROVEEDOR";
    public static final String TABLE_SUSPENSIONES_USUARIO           = "SUSP_USUARIO";
    public static final String TABLE_SUSPENSIONES_ESTADO            = "SUSP_ESTADO";
    public static final String TABLE_SUSPENSIONES_NUM_STICKER       = "SUSP_NUM_STICKER";
    public static final String TABLE_SUSPENSIONES_ESTADO_STICKER    = "SUSP_ESTADO_STICKER";
    public static final String TABLE_SUSPENSIONES_SELLOSERIAL       = "SUSP_SELLOSERIAL";
    public static final String TABLE_SUSPENSIONES_SELLOSERIAL_ESTA  = "SUSP_SELLOSERIAL_ESTADO";
    public static final String TABLE_SUSPENSIONES_COINC_MAT_MEDI    = "SUSP_COINC_MAT_MEDI";
    public static final String TABLE_SUSPENSIONES_CON_PAGO          = "SUSP_CON_PAGO";
    public static final String TABLE_SUSPENSIONES_TIENE_ENERGIA     = "SUSP_TIENE_ENERGIA";
    public static final String TABLE_SUSPENSIONES_LECTURA           = "SUSP_LECTURA";
    public static final String TABLE_SUSPENSIONES_NOM_CONTACTO      = "SUSP_NOM_CONTACTO";
    public static final String TABLE_SUSPENSIONES_NUM_CONTACTO      = "SUSP_NUM_CONTACTO";
    public static final String TABLE_SUSPENSIONES_OBSERVACIONES      = "SUSP_OBSERVACIONES";
    public static final String TABLE_SUSPENSIONES_RECHAZADO         = "SUSP_RECHAZADO";
    public static final String TABLE_SUSPENSIONES_FOTO              = "SUSP_FOTO";
    public static final String TABLE_SUSPENSIONES_LATITUD           = "SUSP_LATITUD";
    public static final String TABLE_SUSPENSIONES_LONGITUD          = "SUSP_LONGITUD";
    public static final String TABLE_SUSPENSIONES_FECHA_EJECU       = "SUSP_FECHA_EJECU";
    public static final String TABLE_SUSPENSIONES_FECHA_CARGA       = "SUSP_FECHA_CARGA";

    public static final String TABLE_FOTOS                          = "fotos";
    public static final String TABLE_FOTOS_ID                       = "fotos_id";
    public static final String TABLE_FOTOS_SUSP_MATRICULA           = "fotos_id_matricula";
    public static final String TABLE_FOTOS_FOTOBLOB                 = "fotos_fotoblob";
    public static final String TABLE_FOTOS_FECHA_CARGA              = "fotos_fecha_carga";


    public static final String FOTO                                 = "Foto";

    // Método que queremos ejecutar en el servicio web
    public static final String MetodoDownload = "SuspensionesUser";

    // Método que queremos ejecutar en el servicio web
    public static final String MetodoUpload = "SuspensionUpdate";

    // Namespace definido en el servicio web
    public static final String namespace = "http://webservices/";
    // namespace + metodo
    public static final String accionSoap = "http://webservices/SuspensionesUser";
    // Fichero de definicion del servcio web
    public static final String url = "http://192.168.1.6:8090/WS_FORMULARIOS/WSSuspensiones?wsdl";

    public static final String urlServer = "192.168.1.6";

}
