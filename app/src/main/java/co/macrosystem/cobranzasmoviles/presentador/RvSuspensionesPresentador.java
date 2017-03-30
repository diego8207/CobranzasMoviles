package co.macrosystem.cobranzasmoviles.presentador;

import android.content.Context;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.vista.SuspensionesActivityRestantes;
import co.macrosystem.cobranzasmoviles.vista.SuspensionesActivitySubidas;
import co.macrosystem.cobranzasmoviles.vista.iSuspensionesActivityRestantesView;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public class RvSuspensionesPresentador implements iRvSuspensionesPresentador {

    private iSuspensionesActivityRestantesView iSuspensionesActivityRestantesView;
    private Context context;

    private ArrayList<Suspension> suspensiones;
    private ConstructorSuspensiones constructorSuspensiones;

    public RvSuspensionesPresentador(SuspensionesActivityRestantes iSuspensionesActivityRestantesView, Context context, String estado) {
        this.iSuspensionesActivityRestantesView = iSuspensionesActivityRestantesView;
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
        iSuspensionesActivityRestantesView.inicializarAdaptadorRV(iSuspensionesActivityRestantesView.crearAdaptador(suspensiones));
        iSuspensionesActivityRestantesView.generarLinearLayoutVertical();
    }

    @Override
    public void procesarSuspension(Suspension suspension) {
        //terminar de implementar el modelo vista presentador
    }

}
