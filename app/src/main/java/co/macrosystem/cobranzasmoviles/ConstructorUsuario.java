package co.macrosystem.cobranzasmoviles;

import android.content.Context;

import co.macrosystem.cobranzasmoviles.db.BaseDatos;

/**
 * Created by Diego Velez on 26/02/2017.
 */

public class ConstructorUsuario {
    private Context context;

    public ConstructorUsuario(Context context) {
        this.context = context;
    }



    public Usuario obtenerDatos(String usuario, String password){
        Usuario u = new Usuario();
        BaseDatos db = new BaseDatos(context);
        return db.ValidarUsuario(usuario, password);
    }


}
