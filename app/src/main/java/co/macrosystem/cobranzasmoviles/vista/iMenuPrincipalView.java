package co.macrosystem.cobranzasmoviles.vista;

import android.content.Context;
import android.view.View;

/**
 * Created by Diego Velez on 25/03/2017.
 */

public interface iMenuPrincipalView {

    public void inicializarToolBarPrincipal();

    public void toggleDetailsSuspensiones(View view);

    public void rotateSuspensiones(float angle);

    public void inializararToolBarCV(Context context);

}
