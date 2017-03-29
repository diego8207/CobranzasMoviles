package co.macrosystem.cobranzasmoviles.presentador;

import android.content.Context;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.vista.iSuspensionesActivityRestantesView;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public class RvSuspensionesPresentador implements iRvSuspensionesPresentador {

    private iSuspensionesActivityRestantesView iSuspensionesActivityRestantesView;
    private Context context;
    private ArrayList<Suspension> suspensiones;
    private ConstructorSuspensiones constructorSuspensiones;

    public RvSuspensionesPresentador(iSuspensionesActivityRestantesView iSuspensionesActivityRestantesView, Context context) {
        this.iSuspensionesActivityRestantesView = iSuspensionesActivityRestantesView;
        this.context = context;
        obternerSuspensiones();
    }

    @Override
    public void obternerSuspensiones() {
        constructorSuspensiones = new ConstructorSuspensiones(context);
        suspensiones = constructorSuspensiones.obtenerDatos();
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
