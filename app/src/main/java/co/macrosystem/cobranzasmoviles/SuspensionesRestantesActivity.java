package co.macrosystem.cobranzasmoviles;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static co.macrosystem.cobranzasmoviles.R.drawable.suspension;

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
        suspensiones.add(new Suspension("394700", "70506190", "9001700", "Palomino Maldonado Cielo", "12 - Ibagué 12", "1 - IBAGUE", "MZ 4 CS 8 COMFENALCO ET 4", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "SE DEJA AL USUARIO SUSPENDIDO SELLO INSTALADO PSY110800 LECTURA 8661"));
        suspensiones.add(new Suspension("356573", "70506190", "9001700", "COMFENALCO TOLIMA", "12 - Ibagué 12", "1 - IBAGUE", "MZ 4 CS 2 COMFENALCO ET 2", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "SE DEJA AL USUARIO SUSPENDIDO SELLO INSTALADO PSY110800 LECTURA 8661"));
        suspensiones.add(new Suspension("356680", "70506190", "9001700", "COMFENALCO TOLIMA", "12 - Ibagué 12", "1 - IBAGUE", "MZ 7 CS 4 COMFENALCO ET 1", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "EL USUARIO QUEDA CON SERVICIO LECTURA 8661"));
        suspensiones.add(new Suspension("243916", "70506190", "9001700", "Murillo Hermiro", "12 - Ibagué 12", "1 - IBAGUE", "MZ 6 CS 20 COMFENALCO ET 3", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "NO SE ENCUENTRAN EN EL PREDIO LECTURA 8661"));
        suspensiones.add(new Suspension("58235", "70506190", "9001700", "Ducuara Fonseca Ana Rosmira", "12 - Ibagué 12", "1 - IBAGUE", "MZ D CS 5 URBANIZACION SANTA RITA ETAPA 3 DIAGONAL 6 SUR ", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "NO QUIERE ATENDER LECTURA 8661"));
        suspensiones.add(new Suspension("356680", "70506190", "9001700", "COMFENALCO TOLIMA", "12 - Ibagué 12", "1 - IBAGUE", "MZ 7 CS 4 COMFENALCO ET 2", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "SE DEJA AL USUARIO SUSPENDIDO SELLO INSTALADO PSY110800 LECTURA 8661"));
        suspensiones.add(new Suspension("243916", "70506190", "9001700", "Murillo Hermiro", "12 - Ibagué 12", "1 - IBAGUE", "MZ 6 CS 20 COMFENALCO ET 1", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "SE DEJA AL USUARIO SUSPENDIDO SELLO INSTALADO PSY110800 LECTURA 8661"));
        suspensiones.add(new Suspension("58235", "70506190", "9001700", "Ducuara Fonseca Ana Rosmira", "12 - Ibagué 12", "1 - IBAGUE", "MZ D CS 5 SANTA RITA", "1/15/17", "11 - SUSPENSION", "Susver BT Bornera", "SE DEJA AL USUARIO SUSPENDIDO SELLO INSTALADO PSY110800 LECTURA 8661"));
    }

    public void inicializarAdaptador(){
        SuspensionAdaptador adaptador = new SuspensionAdaptador(suspensiones, this);
        listaSuspensiones.setAdapter(adaptador);
    }

}
