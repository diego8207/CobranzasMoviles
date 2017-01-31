package co.macrosystem.cobranzasmoviles;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SuspensionesRestantesActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspensiones_restantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cobranzas Moviles versión 1.0");
        setSupportActionBar(toolbar);

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        /*Lista de planetas a mostrar*/
        String [] DireccionesEjemplo = getResources().getStringArray(R.array.DireccionesEjemplo);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, DireccionesEjemplo));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void refrescandoContenido(){
        /*aqui podemos consultar el web service*/
        String [] DireccionesEjemplo = getResources().getStringArray(R.array.DireccionesEjemplo);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, DireccionesEjemplo));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }


}
