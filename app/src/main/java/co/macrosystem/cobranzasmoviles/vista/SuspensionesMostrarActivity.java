package co.macrosystem.cobranzasmoviles.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import co.macrosystem.cobranzasmoviles.R;
import co.macrosystem.cobranzasmoviles.pojo.Suspension;

public class SuspensionesMostrarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Suspension suspension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspensiones_detalle);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name + "Mostrar");
        toolbar.setLogo(R.drawable.logo_cobranzas_title);
        setSupportActionBar(toolbar);
    }
}
