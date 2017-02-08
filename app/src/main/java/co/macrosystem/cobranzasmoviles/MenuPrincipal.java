package co.macrosystem.cobranzasmoviles;

import android.content.Intent;
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
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuPrincipal extends AppCompatActivity {

    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;

    private ViewGroup linearLayoutDetailsObserv_trabajo;
    private ImageView imageViewExpandObserv_trabajo;
    private ImageButton imgBtnSuspensionesRestantes;
    private Intent intent;
    private static final int DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = new Intent(this, SuspensionesRestantesActivity.class);

        linearLayoutDetailsObserv_trabajo = (ViewGroup) findViewById(R.id.linearLayoutDetailsObserv_trabajo);
        imageViewExpand = (ImageView) findViewById(R.id.imageViewExpand);

        linearLayoutDetails = (ViewGroup) findViewById(R.id.linearLayoutDetails);
        imageViewExpandObserv_trabajo = (ImageView) findViewById(R.id.imageViewExpandObserv_trabajo);

        imgBtnSuspensionesRestantes = (ImageButton) findViewById(R.id.imgBtnSuspensionesRestantes);

        imgBtnSuspensionesRestantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });



        Toolbar toolbarCard = (Toolbar) findViewById(R.id.toolbarCardSuspensiones);
        toolbarCard.setTitle(R.string.title_card_suspensiones);

        Toolbar toolbarCard2 = (Toolbar) findViewById(R.id.toolbarCardObserv_trabajo);
        toolbarCard2.setTitle(R.string.title_card_Observ_trabajo);

        //subtitulo de la barra de la tarjeta
        toolbarCard.setSubtitle("Fecha: "+ fechaDeHoy());
        toolbarCard2.setSubtitle("Fecha: "+ fechaDeHoy());

        toolbarCard.inflateMenu(R.menu.menu_card);
        toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_option1:
                        Toast.makeText(MenuPrincipal.this, R.string.option1, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_option2:
                        Toast.makeText(MenuPrincipal.this, R.string.option2, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_option3:
                        Toast.makeText(MenuPrincipal.this, R.string.option3, Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



    }

    public String fechaDeHoy(){
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaActual);
    }



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


    public  void toogleDetailsObserv_trabajo(View view){
        if (linearLayoutDetailsObserv_trabajo.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetailsObserv_trabajo, DURATION);
            imageViewExpandObserv_trabajo.setImageResource(R.mipmap.more);
            rotateObserv_trabajo(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetailsObserv_trabajo, DURATION);
            imageViewExpandObserv_trabajo.setImageResource(R.mipmap.less);
            rotateObserv_trabajo(180.0f);
        }
    }

    private void rotateSuspensiones(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }

    private void rotateObserv_trabajo(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpandObserv_trabajo.startAnimation(animation);
    }
}
