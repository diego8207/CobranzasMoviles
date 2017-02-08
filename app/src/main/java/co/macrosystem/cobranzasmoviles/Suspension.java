package co.macrosystem.cobranzasmoviles;

/**
 * Created by Diego Velez on 08/02/2017.
 */

public class Suspension {

    public Suspension() {
    }

    public Suspension(String matricula, String proceso, String medidor, String suscriptor, String ciclo, String municipio, String direccion, String fecha_actividad, String tipo_actividad, String desc_accion, String glosa) {
        this.matricula = matricula;
        this.proceso = proceso;
        this.medidor = medidor;
        this.suscriptor = suscriptor;
        this.ciclo = ciclo;
        this.municipio = municipio;
        this.direccion = direccion;
        this.fecha_actividad = fecha_actividad;
        this.tipo_actividad = tipo_actividad;
        this.desc_accion = desc_accion;
        this.glosa = glosa;
    }

    private String matricula;
    private String proceso;
    private String medidor;
    private String suscriptor;
    private String ciclo;
    private String municipio;
    private String direccion;
    private String fecha_actividad;
    private String tipo_actividad;
    private String desc_accion;
    private String glosa;
    private String Num_sticker;
    private String estado_sticker;
    private String sello_serial;
    private String estado_sello;
    private String coinciden_matric_medidor;
    private String matricula_pago;
    private String tiene_energia;
    private String lectura;
    private String contacto;
    private String tel_fijo;
    private String tel_cel;
    private String observacion;
    private String rechazo;
    private String proveedor;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getMedidor() {
        return medidor;
    }

    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }

    public String getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(String suscriptor) {
        this.suscriptor = suscriptor;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_actividad() {
        return fecha_actividad;
    }

    public void setFecha_actividad(String fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public String getDesc_accion() {
        return desc_accion;
    }

    public void setDesc_accion(String desc_accion) {
        this.desc_accion = desc_accion;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getNum_sticker() {
        return Num_sticker;
    }

    public void setNum_sticker(String num_sticker) {
        Num_sticker = num_sticker;
    }

    public String getEstado_sticker() {
        return estado_sticker;
    }

    public void setEstado_sticker(String estado_sticker) {
        this.estado_sticker = estado_sticker;
    }

    public String getSello_serial() {
        return sello_serial;
    }

    public void setSello_serial(String sello_serial) {
        this.sello_serial = sello_serial;
    }

    public String getEstado_sello() {
        return estado_sello;
    }

    public void setEstado_sello(String estado_sello) {
        this.estado_sello = estado_sello;
    }

    public String getCoinciden_matric_medidor() {
        return coinciden_matric_medidor;
    }

    public void setCoinciden_matric_medidor(String coinciden_matric_medidor) {
        this.coinciden_matric_medidor = coinciden_matric_medidor;
    }

    public String getMatricula_pago() {
        return matricula_pago;
    }

    public void setMatricula_pago(String matricula_pago) {
        this.matricula_pago = matricula_pago;
    }

    public String getTiene_energia() {
        return tiene_energia;
    }

    public void setTiene_energia(String tiene_energia) {
        this.tiene_energia = tiene_energia;
    }

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(String tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public String getTel_cel() {
        return tel_cel;
    }

    public void setTel_cel(String tel_cel) {
        this.tel_cel = tel_cel;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRechazo() {
        return rechazo;
    }

    public void setRechazo(String rechazo) {
        this.rechazo = rechazo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return matricula + '/' + direccion;
    }
}
