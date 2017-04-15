package co.macrosystem.cobranzasmoviles.presentador;

import android.content.Context;

import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.vista.iMenuPrincipalView;

/**
 * Created by Diego Velez on 28/03/2017.
 */

public class MenuPrincipalPresentador implements iMenuPrincipalPresentador{

    private iMenuPrincipalView iMenuPrincipalView;
    private Context context;
    private ConstructorSuspensiones constructorSuspensiones;
    private int cant = 0;

    public MenuPrincipalPresentador(iMenuPrincipalView iMenuPrincipalView, Context context)  {
        this.iMenuPrincipalView = iMenuPrincipalView;
        this.context = context;
    }

    @Override
    public int obtenerCantSuspensionesEstado(String estado, String usuario) {
        constructorSuspensiones = new ConstructorSuspensiones(context);
        cant = constructorSuspensiones.obtenerSuspensionesRestantesEstado(estado, usuario);
        return cant;
    }
}
