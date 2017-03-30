package co.macrosystem.cobranzasmoviles.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.adapter.SuspensionAdaptador;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.presentador.RvSuspensionesPresentador;
import co.macrosystem.cobranzasmoviles.presentador.iRvSuspensionesPresentador;

public class SuspensionesActivitySubidas extends AppCompatActivity implements iSuspensionesActivitySubidasView{

    private RecyclerView rvListaSuspensionesSubidas;
    private iRvSuspensionesPresentador presentador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspensiones_subidas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        //toolbar.setLogo(R.drawable.logo_cobranzas_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //capturamos el RecyclerView que se esta utilizand en la actividad
        rvListaSuspensionesSubidas = (RecyclerView) findViewById(R.id.rvSuspensionesSubidas);


    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaSuspensionesSubidas.setLayoutManager(llm);
    }

    @Override
    public SuspensionAdaptador crearAdaptador(ArrayList<Suspension> suspensiones) {
        SuspensionAdaptador adaptador = new SuspensionAdaptador(suspensiones, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(SuspensionAdaptador adaptador) {
        rvListaSuspensionesSubidas.setAdapter(adaptador);
    }
}
