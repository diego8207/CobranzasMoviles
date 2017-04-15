package co.macrosystem.cobranzasmoviles.presentador;

import android.content.Context;

import co.macrosystem.cobranzasmoviles.pojo.Suspension;

/**
 * Created by Diego Velez on 16/03/2017.
 */

public interface iRvSuspensionesPresentador {

    public void obternerSuspensiones(String estado, String usuario);

    public void mostrarSuspensionesRV();

    public void procesarSuspension(Suspension suspension);

}
