package co.macrosystem.cobranzasmoviles.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.adapter.SuspensionAdaptador;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.presentador.RvSuspensionesPresentador;
import co.macrosystem.cobranzasmoviles.presentador.iRvSuspensionesPresentador;

public class SuspensionesActivityRestantes extends AppCompatActivity implements iSuspensionesActivityRestantesView {

    //ArrayList<Suspension> suspensiones = null;
    private RecyclerView rvListaSuspensionesRestantes;
    private iRvSuspensionesPresentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspensiones_restantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        //toolbar.setLogo(R.drawable.logo_cobranzas_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //capturamos el RecyclerView que se esta utilizand en la actividad
        rvListaSuspensionesRestantes = (RecyclerView) findViewById(R.id.rvSuspensiones);

        /**
         * instanciamos el iRvSuspensionesPresentador llamado presentador --> ver la interface iRvSuspensionesPresentador
         * el el package presentador enviando como parametros this que es la interface iSuspensionesActivityRestantesView
         * y el contexto.
          */
        presentador = new RvSuspensionesPresentador(this, getBaseContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaSuspensionesRestantes.setLayoutManager(llm);
    }

    @Override
    public SuspensionAdaptador crearAdaptador(ArrayList<Suspension> suspensiones) {
        SuspensionAdaptador adaptador = new SuspensionAdaptador(suspensiones, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(SuspensionAdaptador adaptador) {
        rvListaSuspensionesRestantes.setAdapter(adaptador);
    }


}