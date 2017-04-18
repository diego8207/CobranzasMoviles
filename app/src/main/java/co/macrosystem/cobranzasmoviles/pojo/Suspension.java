package co.macrosystem.cobranzasmoviles.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by Diego Velez on 08/02/2017.
 */
//se implementa Parceable para poder pasar este objeto como parametro entre una activity a otra
public class Suspension implements Parcelable, KvmSerializable{

    private String SUSP_MATRICULA;
    private String SUSP_NUM_PROCESO;
    private String SUSP_NUM_MEDIDOR;
    private String SUSP_SUSCRIPTOR;
    private String SUSP_DIRECCION;
    private String SUSP_FECHA_ACTI;
    private String SUSP_TIPO_ACTI;
    private String SUSP_COD_ACCION;
    private String SUSP_DESCR_ACCION;
    private String SUSP_COD_TECNICO;
    private String SUSP_CICLO;
    private String SUSP_MUNICIPIO;
    private String SUSP_GLOSA;
    private String SUSP_USUARIO;
    private String SUSP_ESTADO;
    private String SUSP_NUM_STICKER = "";
    private String SUSP_ESTADO_STICKER = "";
    private String SUSP_SELLOSERIAL = "";
    private String SUSP_SELLOSERIAL_ESTADO = "";
    private String SUSP_COINC_MAT_MEDI = "";
    private String SUSP_CON_PAGO = "";
    private String SUSP_TIENE_ENERGIA= "";
    private String SUSP_LECTURA = "";
    private String SUSP_NOM_CONTACTO = "";
    private String SUSP_NUM_CONTACTO = "";
    private String SUSP_OBSERVACIONES = "";
    private String SUSP_RECHAZADO = "";
    private String SUSP_FOTO = "";
    private String SUSP_LATITUD = "";
    private String SUSP_LONGITUD = "";
    private String SUSP_PROVEEDOR = "";
    private String SUSP_FECHA_CARGA = "";
    private String SUSP_FECHA_EJECUCION = "";

    public Suspension() {
    }

    public Suspension(String SUSP_MATRICULA, String SUSP_NUM_PROCESO, String SUSP_NUM_MEDIDOR, String SUSP_SUSCRIPTOR, String SUSP_CICLO, String SUSP_MUNICIPIO, String SUSP_DIRECCION, String SUSP_FECHA_ACTI, String SUSP_TIPO_ACTI, String SUSP_COD_ACCION, String SUSP_DESCR_ACCION, String SUSP_COD_TECNICO, String SUSP_GLOSA, String SUSP_PROVEEDOR, String SUSP_USUARIO, String SUSP_ESTADO, String SUSP_FECHA_CARGA) {
        this.SUSP_MATRICULA = SUSP_MATRICULA;
        this.SUSP_NUM_PROCESO = SUSP_NUM_PROCESO;
        this.SUSP_NUM_MEDIDOR = SUSP_NUM_MEDIDOR;
        this.SUSP_SUSCRIPTOR = SUSP_SUSCRIPTOR;
        this.SUSP_DIRECCION = SUSP_DIRECCION;
        this.SUSP_FECHA_ACTI = SUSP_FECHA_ACTI;
        this.SUSP_TIPO_ACTI = SUSP_TIPO_ACTI;
        this.SUSP_COD_ACCION = SUSP_COD_ACCION;
        this.SUSP_DESCR_ACCION = SUSP_DESCR_ACCION;
        this.SUSP_COD_TECNICO = SUSP_COD_TECNICO;
        this.SUSP_CICLO = SUSP_CICLO;
        this.SUSP_MUNICIPIO = SUSP_MUNICIPIO;
        this.SUSP_GLOSA = SUSP_GLOSA;
        this.SUSP_USUARIO = SUSP_USUARIO;
        this.SUSP_ESTADO = SUSP_ESTADO;
        this.SUSP_PROVEEDOR = SUSP_PROVEEDOR;
        this.SUSP_FECHA_CARGA = SUSP_FECHA_CARGA;

    }

    public String getSUSP_MATRICULA() {
        return SUSP_MATRICULA;
    }

    public void setSUSP_MATRICULA(String SUSP_MATRICULA) {
        this.SUSP_MATRICULA = SUSP_MATRICULA;
    }

    public String getSUSP_NUM_PROCESO() {
        return SUSP_NUM_PROCESO;
    }

    public void setSUSP_NUM_PROCESO(String SUSP_NUM_PROCESO) {
        this.SUSP_NUM_PROCESO = SUSP_NUM_PROCESO;
    }

    public String getSUSP_NUM_MEDIDOR() {
        return SUSP_NUM_MEDIDOR;
    }

    public void setSUSP_NUM_MEDIDOR(String SUSP_NUM_MEDIDOR) {
        this.SUSP_NUM_MEDIDOR = SUSP_NUM_MEDIDOR;
    }

    public String getSUSP_OBSERVACIONES() {
        return SUSP_OBSERVACIONES;
    }

    public void setSUSP_OBSERVACIONES(String SUSP_OBSERVACIONES) {
        this.SUSP_OBSERVACIONES = SUSP_OBSERVACIONES;
    }

    public String getSUSP_SUSCRIPTOR() {
        return SUSP_SUSCRIPTOR;
    }

    public void setSUSP_SUSCRIPTOR(String SUSP_SUSCRIPTOR) {
        this.SUSP_SUSCRIPTOR = SUSP_SUSCRIPTOR;
    }

    public String getSUSP_DIRECCION() {
        return SUSP_DIRECCION;
    }

    public void setSUSP_DIRECCION(String SUSP_DIRECCION) {
        this.SUSP_DIRECCION = SUSP_DIRECCION;
    }

    public String getSUSP_FECHA_ACTI() {
        return SUSP_FECHA_ACTI;
    }

    public void setSUSP_FECHA_ACTI(String SUSP_FECHA_ACTI) {
        this.SUSP_FECHA_ACTI = SUSP_FECHA_ACTI;
    }

    public String getSUSP_TIPO_ACTI() {
        return SUSP_TIPO_ACTI;
    }

    public void setSUSP_TIPO_ACTI(String SUSP_TIPO_ACTI) {
        this.SUSP_TIPO_ACTI = SUSP_TIPO_ACTI;
    }

    public String getSUSP_COD_ACCION() {
        return SUSP_COD_ACCION;
    }

    public void setSUSP_COD_ACCION(String SUSP_COD_ACCION) {
        this.SUSP_COD_ACCION = SUSP_COD_ACCION;
    }

    public String getSUSP_DESCR_ACCION() {
        return SUSP_DESCR_ACCION;
    }

    public void setSUSP_DESCR_ACCION(String SUSP_DESCR_ACCION) {
        this.SUSP_DESCR_ACCION = SUSP_DESCR_ACCION;
    }

    public String getSUSP_COD_TECNICO() {
        return SUSP_COD_TECNICO;
    }

    public void setSUSP_COD_TECNICO(String SUSP_COD_TECNICO) {
        this.SUSP_COD_TECNICO = SUSP_COD_TECNICO;
    }

    public String getSUSP_CICLO() {
        return SUSP_CICLO;
    }

    public void setSUSP_CICLO(String SUSP_CICLO) {
        this.SUSP_CICLO = SUSP_CICLO;
    }

    public String getSUSP_MUNICIPIO() {
        return SUSP_MUNICIPIO;
    }

    public void setSUSP_MUNICIPIO(String SUSP_MUNICIPIO) {
        this.SUSP_MUNICIPIO = SUSP_MUNICIPIO;
    }

    public String getSUSP_GLOSA() {
        return SUSP_GLOSA;
    }

    public void setSUSP_GLOSA(String SUSP_GLOSA) {
        this.SUSP_GLOSA = SUSP_GLOSA;
    }

    public String getSUSP_USUARIO() {
        return SUSP_USUARIO;
    }

    public void setSUSP_USUARIO(String SUSP_USUARIO) {
        this.SUSP_USUARIO = SUSP_USUARIO;
    }

    public String getSUSP_ESTADO() {
        return SUSP_ESTADO;
    }

    public void setSUSP_ESTADO(String SUSP_ESTADO) {
        this.SUSP_ESTADO = SUSP_ESTADO;
    }

    public String getSUSP_NUM_STICKER() {
        return SUSP_NUM_STICKER;
    }

    public void setSUSP_NUM_STICKER(String SUSP_NUM_STICKER) {
        this.SUSP_NUM_STICKER = SUSP_NUM_STICKER;
    }

    public String getSUSP_ESTADO_STICKER() {
        return SUSP_ESTADO_STICKER;
    }

    public void setSUSP_ESTADO_STICKER(String SUSP_ESTADO_STICKER) {
        this.SUSP_ESTADO_STICKER = SUSP_ESTADO_STICKER;
    }

    public String getSUSP_SELLOSERIAL() {
        return SUSP_SELLOSERIAL;
    }

    public void setSUSP_SELLOSERIAL(String SUSP_SELLOSERIAL) {
        this.SUSP_SELLOSERIAL = SUSP_SELLOSERIAL;
    }

    public String getSUSP_SELLOSERIAL_ESTADO() {
        return SUSP_SELLOSERIAL_ESTADO;
    }

    public void setSUSP_SELLOSERIAL_ESTADO(String SUSP_SELLOSERIAL_ESTADO) {
        this.SUSP_SELLOSERIAL_ESTADO = SUSP_SELLOSERIAL_ESTADO;
    }

    public String getSUSP_COINC_MAT_MEDI() {
        return SUSP_COINC_MAT_MEDI;
    }

    public void setSUSP_COINC_MAT_MEDI(String SUSP_COINC_MAT_MEDI) {
        this.SUSP_COINC_MAT_MEDI = SUSP_COINC_MAT_MEDI;
    }

    public String getSUSP_CON_PAGO() {
        return SUSP_CON_PAGO;
    }

    public void setSUSP_CON_PAGO(String SUSP_CON_PAGO) {
        this.SUSP_CON_PAGO = SUSP_CON_PAGO;
    }

    public String getSUSP_TIENE_ENERGIA() {
        return SUSP_TIENE_ENERGIA;
    }

    public void setSUSP_TIENE_ENERGIA(String SUSP_TIENE_ENERGIA) {
        this.SUSP_TIENE_ENERGIA = SUSP_TIENE_ENERGIA;
    }

    public String getSUSP_LECTURA() {
        return SUSP_LECTURA;
    }

    public void setSUSP_LECTURA(String SUSP_LECTURA) {
        this.SUSP_LECTURA = SUSP_LECTURA;
    }

    public String getSUSP_NOM_CONTACTO() {
        return SUSP_NOM_CONTACTO;
    }

    public void setSUSP_NOM_CONTACTO(String SUSP_NOM_CONTACTO) {
        this.SUSP_NOM_CONTACTO = SUSP_NOM_CONTACTO;
    }

    public String getSUSP_NUM_CONTACTO() {
        return SUSP_NUM_CONTACTO;
    }

    public void setSUSP_NUM_CONTACTO(String SUSP_NUM_CONTACTO) {
        this.SUSP_NUM_CONTACTO = SUSP_NUM_CONTACTO;
    }

    public String getSUSP_RECHAZADO() {
        return SUSP_RECHAZADO;
    }

    public void setSUSP_RECHAZADO(String SUSP_RECHAZADO) {
        this.SUSP_RECHAZADO = SUSP_RECHAZADO;
    }

    public String getSUSP_FOTO() {
        return SUSP_FOTO;
    }

    public void setSUSP_FOTO(String SUSP_FOTO) {
        this.SUSP_FOTO = SUSP_FOTO;
    }

    public String getSUSP_LATITUD() {
        return SUSP_LATITUD;
    }

    public void setSUSP_LATITUD(String SUSP_LATITUD) {
        this.SUSP_LATITUD = SUSP_LATITUD;
    }

    public String getSUSP_LONGITUD() {
        return SUSP_LONGITUD;
    }

    public void setSUSP_LONGITUD(String SUSP_LONGITUD) {
        this.SUSP_LONGITUD = SUSP_LONGITUD;
    }

    public String getSUSP_PROVEEDOR() {
        return SUSP_PROVEEDOR;
    }

    public void setSUSP_PROVEEDOR(String SUSP_PROVEEDOR) {
        this.SUSP_PROVEEDOR = SUSP_PROVEEDOR;
    }

    public String getSUSP_FECHA_CARGA() {
        return SUSP_FECHA_CARGA;
    }

    public void setSUSP_FECHA_CARGA(String SUSP_FECHA_CARGA) {
        this.SUSP_FECHA_CARGA = SUSP_FECHA_CARGA;
    }

    public String getSUSP_FECHA_EJECUCION() {
        return fechaDeHoy();
    }

    public void setSUSP_FECHA_EJECUCION(String SUSP_FECHA_EJECUCION) {
        this.SUSP_FECHA_EJECUCION = SUSP_FECHA_EJECUCION;
    }

    public static Creator<Suspension> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(SUSP_MATRICULA);
        dest.writeString(SUSP_NUM_PROCESO);
        dest.writeString(SUSP_NUM_MEDIDOR);
        dest.writeString(SUSP_SUSCRIPTOR);
        dest.writeString(SUSP_DIRECCION);
        dest.writeString(SUSP_FECHA_ACTI);
        dest.writeString(SUSP_TIPO_ACTI);
        dest.writeString(SUSP_COD_ACCION);
        dest.writeString(SUSP_DESCR_ACCION);
        dest.writeString(SUSP_COD_TECNICO);
        dest.writeString(SUSP_CICLO);
        dest.writeString(SUSP_MUNICIPIO);
        dest.writeString(SUSP_GLOSA);
        dest.writeString(SUSP_USUARIO);
        dest.writeString(SUSP_ESTADO);
        dest.writeString(SUSP_PROVEEDOR);
        dest.writeString(SUSP_FECHA_CARGA);

        dest.writeString(SUSP_NUM_STICKER);
        dest.writeString(SUSP_ESTADO_STICKER);
        dest.writeString(SUSP_SELLOSERIAL);
        dest.writeString(SUSP_SELLOSERIAL_ESTADO);
        dest.writeString(SUSP_COINC_MAT_MEDI);
        dest.writeString(SUSP_CON_PAGO);
        dest.writeString(SUSP_TIENE_ENERGIA);
        dest.writeString(SUSP_LECTURA);
        dest.writeString(SUSP_NOM_CONTACTO);
        dest.writeString(SUSP_NUM_CONTACTO);
        dest.writeString(SUSP_OBSERVACIONES);
        dest.writeString(SUSP_RECHAZADO);
        dest.writeString(SUSP_FOTO);
        dest.writeString(SUSP_LATITUD);
        dest.writeString(SUSP_LONGITUD);
        dest.writeString(SUSP_FECHA_CARGA);
        dest.writeString(SUSP_FECHA_EJECUCION);

    }

    private void readFromParcel(Parcel in) {
        SUSP_MATRICULA = in.readString();
        SUSP_NUM_PROCESO = in.readString();
        SUSP_NUM_MEDIDOR = in.readString();
        SUSP_SUSCRIPTOR = in.readString();
        SUSP_DIRECCION = in.readString();
        SUSP_FECHA_ACTI = in.readString();
        SUSP_TIPO_ACTI = in.readString();
        SUSP_COD_ACCION = in.readString();
        SUSP_DESCR_ACCION = in.readString();
        SUSP_COD_TECNICO = in.readString();
        SUSP_CICLO = in.readString();
        SUSP_MUNICIPIO = in.readString();
        SUSP_GLOSA = in.readString();
        SUSP_USUARIO = in.readString();
        SUSP_ESTADO = in.readString();
        SUSP_PROVEEDOR = in.readString();
        SUSP_FECHA_CARGA = in.readString();

        SUSP_NUM_STICKER = in.readString();
        SUSP_ESTADO_STICKER = in.readString();
        SUSP_SELLOSERIAL = in.readString();
        SUSP_SELLOSERIAL_ESTADO = in.readString();
        SUSP_COINC_MAT_MEDI = in.readString();
        SUSP_CON_PAGO = in.readString();
        SUSP_TIENE_ENERGIA = in.readString();
        SUSP_LECTURA = in.readString();
        SUSP_NOM_CONTACTO = in.readString();
        SUSP_NUM_CONTACTO = in.readString();
        SUSP_OBSERVACIONES = in.readString();
        SUSP_RECHAZADO = in.readString();
        SUSP_FOTO = in.readString();
        SUSP_LATITUD = in.readString();
        SUSP_LONGITUD = in.readString();
        SUSP_FECHA_CARGA = in.readString();
        SUSP_FECHA_EJECUCION = in.readString();
    }

    public Suspension(Parcel in) {
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Suspension> CREATOR
            = new Parcelable.Creator<Suspension>() {
        public Suspension createFromParcel(Parcel in) {
            return new Suspension(in);
        }

        @Override
        public Suspension[] newArray(int size) {
            return new Suspension[size];
        }


    };

    public String fechaDeHoy(){
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaActual);
    }


    @Override
    public Object getProperty(int i) {

        switch (i){
            case 0: return getSUSP_MATRICULA();
            case 1: return getSUSP_NUM_PROCESO();
            case 2: return getSUSP_NUM_MEDIDOR();
            case 3: return getSUSP_SUSCRIPTOR();
            case 4: return getSUSP_DIRECCION();
            case 5: return getSUSP_FECHA_ACTI();
            case 6: return getSUSP_TIPO_ACTI();
            case 7: return getSUSP_COD_ACCION();
            case 8: return getSUSP_DESCR_ACCION();
            case 9: return getSUSP_COD_TECNICO();
            case 10: return getSUSP_CICLO();
            case 11: return getSUSP_MUNICIPIO();
            case 12: return getSUSP_GLOSA();
            case 13: return getSUSP_USUARIO();
            case 14: return getSUSP_ESTADO();
            case 15: return getSUSP_NUM_STICKER();
            case 16: return getSUSP_ESTADO_STICKER();
            case 17: return getSUSP_SELLOSERIAL();
            case 18: return getSUSP_SELLOSERIAL_ESTADO();
            case 19: return getSUSP_COINC_MAT_MEDI();
            case 20: return getSUSP_CON_PAGO();
            case 21: return getSUSP_TIENE_ENERGIA();
            case 22: return getSUSP_LECTURA();
            case 23: return getSUSP_NOM_CONTACTO();
            case 24: return getSUSP_NUM_CONTACTO();
            case 25: return getSUSP_OBSERVACIONES();
            case 26: return getSUSP_RECHAZADO();
            case 27: return getSUSP_FOTO();
            case 28: return getSUSP_LATITUD();
            case 29: return getSUSP_LONGITUD();
            case 30: return getSUSP_PROVEEDOR();
            case 31: return getSUSP_FECHA_CARGA();
            case 32: return getSUSP_FECHA_EJECUCION();
        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 33;
    }

    @Override
    public void setProperty(int index, Object value) {
        switch (index){
            case 0: SUSP_MATRICULA = value.toString();
            case 1: SUSP_NUM_PROCESO = value.toString();
            case 2: SUSP_NUM_MEDIDOR = value.toString();
            case 3: SUSP_SUSCRIPTOR = value.toString();
            case 4: SUSP_DIRECCION = value.toString();
            case 5: SUSP_FECHA_ACTI = value.toString();
            case 6: SUSP_TIPO_ACTI = value.toString();
            case 7: SUSP_COD_ACCION = value.toString();
            case 8: SUSP_DESCR_ACCION = value.toString();
            case 9: SUSP_COD_TECNICO = value.toString();
            case 10: SUSP_CICLO = value.toString();
            case 11: SUSP_MUNICIPIO = value.toString();
            case 12: SUSP_GLOSA = value.toString();
            case 13: SUSP_USUARIO = value.toString();
            case 14: SUSP_ESTADO = value.toString();
            case 15: SUSP_NUM_STICKER = value.toString();
            case 16: SUSP_ESTADO_STICKER = value.toString();
            case 17: SUSP_SELLOSERIAL = value.toString();
            case 18: SUSP_SELLOSERIAL_ESTADO = value.toString();
            case 19: SUSP_COINC_MAT_MEDI = value.toString();
            case 20: SUSP_CON_PAGO = value.toString();
            case 21: SUSP_TIENE_ENERGIA = value.toString();
            case 22: SUSP_LECTURA = value.toString();
            case 23: SUSP_NOM_CONTACTO = value.toString();
            case 24: SUSP_NUM_CONTACTO = value.toString();
            case 25: SUSP_OBSERVACIONES = value.toString();
            case 26: SUSP_RECHAZADO = value.toString();
            case 27: SUSP_FOTO = value.toString();
            case 28: SUSP_LATITUD = value.toString();
            case 29: SUSP_LONGITUD = value.toString();
            case 30: SUSP_PROVEEDOR = value.toString();
            case 31: SUSP_FECHA_CARGA = value.toString();
            case 32: SUSP_FECHA_EJECUCION = value.toString();
            default: break;
        }
    }

    @Override
    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo Info) {
        switch (index){
            case 0: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_MATRICULA"; break;
            case 1: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_NUM_PROCESO"; break;
            case 2: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_NUM_MEDIDOR"; break;
            case 3: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_SUSCRIPTOR"; break;
            case 4: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_DIRECCION"; break;
            case 5: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_FECHA_ACTI"; break;
            case 6: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_TIPO_ACTI"; break;
            case 7: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_COD_ACCION"; break;
            case 8: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_DESCR_ACCION"; break;
            case 9: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_COD_TECNICO"; break;
            case 10: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_CICLO"; break;
            case 11: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_MUNICIPIO"; break;
            case 12: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_GLOSA"; break;
            case 13: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_USUARIO"; break;
            case 14: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_ESTADO"; break;
            case 15: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_NUM_STICKER"; break;
            case 16: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_ESTADO_STICKER"; break;
            case 17: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_SELLOSERIAL"; break;
            case 18: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_SELLOSERIAL_ESTADO"; break;
            case 19: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_COINC_MAT_MEDI"; break;
            case 20: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_CON_PAGO"; break;
            case 21: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_TIENE_ENERGIA"; break;
            case 22: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_LECTURA"; break;
            case 23: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_NOM_CONTACTO"; break;
            case 24: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_NUM_CONTACTO"; break;
            case 25: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_OBSERVACIONES"; break;
            case 26: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_RECHAZADO"; break;
            case 27: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_FOTO"; break;
            case 28: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_LATITUD"; break;
            case 29: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_LONGITUD"; break;
            case 30: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_PROVEEDOR"; break;
            case 31: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_FECHA_CARGA"; break;
            case 32: Info.type = PropertyInfo.STRING_CLASS; Info.name = "SUSP_FECHA_EJECUCION"; break;
        }

    }
}