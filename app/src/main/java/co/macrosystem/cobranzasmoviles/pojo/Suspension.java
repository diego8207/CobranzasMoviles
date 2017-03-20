package co.macrosystem.cobranzasmoviles.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Diego Velez on 08/02/2017.
 */
//se implementa Parceable para poder pasar este objeto como parametro entre una activity a otra
public class Suspension implements Parcelable {

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
    private String SUSP_NUM_STICKER;
    private String SUSP_ESTADO_STICKER;
    private String SUSP_SELLOSERIAL;
    private String SUSP_SELLOSERIAL_ESTADO;
    private String SUSP_COINC_MAT_MEDI;
    private String SUSP_CON_PAGO;
    private String SUSP_TIENE_ENERGIA;
    private String SUSP_LECTURA;
    private String SUSP_NOM_CONTACTO;
    private String SUSP_NUM_CONTACTO;
    private String SUSP_OBSERVACIONES;
    private String SUSP_RECHAZADO;
    private String SUSP_FOTO;
    private String SUSP_LATITUD;
    private String SUSP_LONGITUD;
    private String SUSP_FECHA_EJECU;
    private String SUSP_PROVEEDOR;
    private String SUSP_FECHA_CARGA;
    private String SUSP_FECHA_EJECUCION;

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

    public String getSUSP_FECHA_EJECU() {
        return SUSP_FECHA_EJECU;
    }

    public void setSUSP_FECHA_EJECU(String SUSP_FECHA_EJECU) {
        this.SUSP_FECHA_EJECU = SUSP_FECHA_EJECU;
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
        return SUSP_FECHA_EJECUCION;
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


}