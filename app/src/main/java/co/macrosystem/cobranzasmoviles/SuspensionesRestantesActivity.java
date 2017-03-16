package co.macrosystem.cobranzasmoviles;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.macrosystem.cobranzasmoviles.adapter.SuspensionAdaptador;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;

public class SuspensionesRestantesActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    //ListView lstMiLista;
    ArrayList<Suspension> suspensiones = null;
    private RecyclerView listaSuspensiones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspensiones_restantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Suspensiones Restantes # 11");
        setSupportActionBar(toolbar);

        listaSuspensiones = (RecyclerView) findViewById(R.id.rvSuspensiones);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaSuspensiones.setLayoutManager(llm);

        inicializarListaSuspensiones();

        inicializarAdaptador();


        // comentariamos para no trabajar el antiguo ListView

        //sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        //lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        /*Lista de planetas a mostrar
        String [] DireccionesEjemplo = getResources().getStringArray(R.array.DireccionesEjemplo);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, DireccionesEjemplo));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void refrescandoContenido(){
        /*aqui podemos consultar el web service*/
        String [] DireccionesEjemplo = getResources().getStringArray(R.array.DireccionesEjemplo);
        //lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, DireccionesEjemplo));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void inicializarListaSuspensiones(){
        suspensiones = new ArrayList<Suspension>();
        //vamos a quemar la informacion pero este ArrayList se debe llenar a ártir de un consumo de web service
        suspensiones.add(new Suspension("86403","70506190","20101009828","NOEL TORRES RINCON","9 - Ibague 9","1 - IBAGUE","MNZ 3 CASA 10 1ET.SIMON BOLIVAR","27/02/2017" ,"11 - Suspension","904"," Susver BT Bornera","875", "se realiza suspension","80","Dvargas","Activo", "27/02/2017"));
    }

    public void inicializarAdaptador(){
        SuspensionAdaptador adaptador = new SuspensionAdaptador(suspensiones, this);
        listaSuspensiones.setAdapter(adaptador);
    }

}
