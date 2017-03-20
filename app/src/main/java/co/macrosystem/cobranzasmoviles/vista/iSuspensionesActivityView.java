package co.macrosystem.cobranzasmoviles.vista;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.adapter.SuspensionAdaptador;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public interface iSuspensionesActivityView {

    public void generarLinearLayoutVertical();

    public SuspensionAdaptador crearAdaptador(ArrayList<Suspension> suspensiones);

    public void inicializarAdaptadorRV(SuspensionAdaptador adaptador);
}
