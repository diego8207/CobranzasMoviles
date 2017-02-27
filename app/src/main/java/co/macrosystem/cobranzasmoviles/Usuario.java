package co.macrosystem.cobranzasmoviles;

public class Usuario {

    private int usua_id;
    private String usua_usuario;
    private String usua_password;
    private String usua_estado;
    private String rol_nombre;
    private String nomape;

    public Usuario() {
    }

    public Usuario(int usua_id, String usua_usuario, String usua_password, String usua_estado, String rol_nombre, String nomape) {
        this.usua_id = usua_id;
        this.usua_usuario = usua_usuario;
        this.usua_password = usua_password;
        this.usua_estado = usua_estado;
        this.rol_nombre = rol_nombre;
        this.nomape = nomape;
    }

    public int getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(int usua_id) {
        this.usua_id = usua_id;
    }

    public String getUsua_usuario() {
        return usua_usuario;
    }

    public void setUsua_usuario(String usua_usuario) {
        this.usua_usuario = usua_usuario;
    }

    public String getUsua_password() {
        return usua_password;
    }

    public void setUsua_password(String usua_password) {
        this.usua_password = usua_password;
    }

    public String getUsua_estado() {
        return usua_estado;
    }

    public void setUsua_estado(String usua_estado) {
        this.usua_estado = usua_estado;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getNomape() {
        return nomape;
    }

    public void setNomape(String nomape) {
        this.nomape = nomape;
    }
}
