package co.macrosystem.cobranzasmoviles.vista;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.macrosystem.cobranzasmoviles.DialogoConfirmacion;
import co.macrosystem.cobranzasmoviles.ExpandAndCollapseViewUtil;
import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.db.BaseDatos;
import co.macrosystem.cobranzasmoviles.db.ConstructorSuspensiones;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;
import co.macrosystem.cobranzasmoviles.presentador.RvSuspensionesPresentador;
import co.macrosystem.cobranzasmoviles.presentador.iRvSuspensionesPresentador;

public class MenuPrincipal extends AppCompatActivity implements iMenuPrincipalView {

    private Context context;
    private ArrayList<Suspension> suspensiones = null;
    private ConstructorSuspensiones constructorSuspensiones;
    int numSuspensiones=0;

    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private TextView numSuspensionesCargadas;
    private ImageButton imgBtnSuspensionesRestantes;
    private Toolbar toolbarCard;
    Toolbar toolbar;
    private Intent intent;
    private static final int DURATION = 250;
    private boolean internet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        context = this.getBaseContext();

        numSuspensionesCargadas = (TextView) findViewById(R.id.txtSuspCargadas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageViewExpand = (ImageView) findViewById(R.id.imageViewExpand);
        linearLayoutDetails = (ViewGroup) findViewById(R.id.linearLayoutDetails);
        imgBtnSuspensionesRestantes = (ImageButton) findViewById(R.id.imgBtnSuspensionesRestantes);
        toolbarCard = (Toolbar) findViewById(R.id.toolbarCardSuspensiones);

        inicializarToolBarPrincipal();
        inializararToolBarCV(context);
        validarInternet(context);


        obternetSuspensionesCargadas();


    }

    public String fechaDeHoy(){
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaActual);
    }


    //si hace parte de la interfaz iMenuPrincipalView porque hay una interaccion directa con
    //el TextView numSuspensionesCargadas
    @Override
    public void toggleDetailsSuspensiones(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotateSuspensiones(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotateSuspensiones(180.0f);
        }
    }

    //si hace parte de la interfaz iMenuPrincipalView porque hay una interaccion directa con
    //el TextView numSuspensionesCargadas
    @Override
    public void rotateSuspensiones(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }

    public void obternetSuspensionesCargadas() {
        int numSuspensiones = 0;
        constructorSuspensiones = new ConstructorSuspensiones(context);
        //suspensiones = constructorSuspensiones.obtenerDatos();
        numSuspensiones = constructorSuspensiones.ObtenerTotalSuspensionesCargadas();
        //numSuspensiones = suspensiones.size();
        if (numSuspensiones != 0){
            numSuspensionesCargadas.setText("Cargadas por analista: " + numSuspensiones);
            Toast toast1 = Toast.makeText(getApplicationContext(), "Cargadas:" + numSuspensiones, Toast.LENGTH_SHORT);
            toast1.show();
        }else{
            numSuspensionesCargadas.setText("No hay Suspensiones Cargadas: " + numSuspensiones);
        }
    }

    //si hace parte de la interfaz iMenuPrincipalView porque hay una interaccion directa con
    //el TextView numSuspensionesCargadas

    @Override
    public void inializararToolBarCV(final Context context){
        toolbarCard.setTitle(R.string.title_card_suspensiones);
        //subtitulo de la barra de la tarjeta
        toolbarCard.setSubtitle("Fecha: "+ fechaDeHoy());
        toolbarCard.inflateMenu(R.menu.menu_card);

        toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mSincronizar:
                        BaseDatos db = new BaseDatos(context);
                        constructorSuspensiones.registrarSuspensionesSQLite(db);
                        obternetSuspensionesCargadas();
                        Toast.makeText(MenuPrincipal.this, "Sincronizando Suspensiones", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    //si hace parte de la interfaz iMenuPrincipalView porque hay una interaccion directa con
    //el TextView numSuspensionesCargadas
    @Override
    public void inicializarToolBarPrincipal(){
        Context context = this.getBaseContext();
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.logo_cobranzas_title);
        setSupportActionBar(toolbar);
    }

    //si hace parte de la interfaz iMenuPrincipalView porque hay una interaccion directa con
    //el TextView numSuspensionesCargadas

    public void validarInternet(Context context){
        //Validamos si hay conexion a internet
        internet = ValidarConexionInternet();
        if (internet){
            //Toast toast1 = Toast.makeText(getApplicationContext(), "Hay conexion", Toast.LENGTH_SHORT);
            // toast1.show();
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoConfirmacion confirmacion = new DialogoConfirmacion();
            confirmacion.show(fragmentManager, "confirmando");
        }else{

        }
    }

    //si hace parte de la interfaz iMenuPrincipalView porque hay una interaccion directa con
    //el TextView numSuspensionesCargadas
    public void visualizarSuspensionesRestantes(View view){
        intent = new Intent(context, SuspensionesActivityRestantes.class);
        startActivity(intent);
    }


    private Boolean ValidarConexionInternet(){
        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com.co");
            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
