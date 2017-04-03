package co.macrosystem.cobranzasmoviles.presentador;

import android.content.Context;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.vista.SuspensionesActivity;
import co.macrosystem.cobranzasmoviles.vista.iSuspensionesActivityView;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public class RvSuspensionesPresentador implements iRvSuspensionesPresentador {

    private iSuspensionesActivityView iSuspensionesActivityView;
    private Context context;

    private ArrayList<Suspension> suspensiones;
    private ConstructorSuspensiones constructorSuspensiones;

    public RvSuspensionesPresentador(SuspensionesActivity iSuspensionesActivityView, Context context, String estado) {
        this.iSuspensionesActivityView = iSuspensionesActivityView;
        this.context = context;
        obternerSuspensiones(estado);
    }

    @Override
    public void obternerSuspensiones(String estado) {
        constructorSuspensiones = new ConstructorSuspensiones(context);
        suspensiones = constructorSuspensiones.obtenerDatos(estado);
        mostrarSuspensionesRV();
    }

    @Override
    public void mostrarSuspensionesRV() {
        iSuspensionesActivityView.inicializarAdaptadorRV(iSuspensionesActivityView.crearAdaptador(suspensiones));
        iSuspensionesActivityView.generarLinearLayoutVertical();
    }

    @Override
    public void procesarSuspension(Suspension suspension) {
        //terminar de implementar el modelo vista presentador
    }

}
