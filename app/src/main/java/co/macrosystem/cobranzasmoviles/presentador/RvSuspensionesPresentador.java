package co.macrosystem.cobranzasmoviles.presentador;

import android.content.Context;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.adapter.SuspensionAdaptador;
import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.vista.iSuspensionesActivityView;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public class RvSuspensionesPresentador implements iRvSuspensionesPresentador {

    private iSuspensionesActivityView iSuspensionesActivityView;
    private Context context;
    private ArrayList<Suspension> suspensiones;
    private ConstructorSuspensiones constructorSuspensiones;

    public RvSuspensionesPresentador(iSuspensionesActivityView iSuspensionesActivityView, Context context) {
        this.iSuspensionesActivityView = iSuspensionesActivityView;
        this.context = context;
        obternetSuspensiones();
    }

    @Override
    public void obternetSuspensiones() {
        constructorSuspensiones = new ConstructorSuspensiones(context);
        suspensiones = constructorSuspensiones.obtenerDatos();
        mostrarSuspensionesRV();
    }

    @Override
    public void mostrarSuspensionesRV() {
        iSuspensionesActivityView.inicializarAdaptadorRV(iSuspensionesActivityView.crearAdaptador(suspensiones));
    }
}
