package co.macrosystem.cobranzasmoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class form_suspensiones_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private Suspension suspension;
    private TextView txtProceso;
    private TextView txtMedidor;
    private TextView txtSuscriptor;
    private TextView txtCiclo;
    private TextView txtMunicipio;
    private TextView txtDireccion;
    private TextView txtfecha_actividad;
    private TextView txtTipoActividad;
    private TextView txtDescAccion;
    private TextView txtGlosa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_suspensiones);
        suspension = getIntent().getParcelableExtra("objSuspension");
        Toolbar toolbarCard = (Toolbar) findViewById(R.id.toolbarCardFormSuspensiones);
        toolbarCard.setTitle("Matricula: " + suspension.getMatricula());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SUSPENSIONES");
        setSupportActionBar(toolbar);
        txtProceso = (TextView) findViewById(R.id.txtProceso);
        txtMedidor = (TextView) findViewById(R.id.txtMedidor);
        txtSuscriptor = (TextView) findViewById(R.id.txtSuscriptor);
        txtCiclo = (TextView) findViewById(R.id.txtCiclo);
        txtMunicipio = (TextView) findViewById(R.id.txtMunicipio);
        txtDireccion = (TextView) findViewById(R.id.txtDireccion);
        txtfecha_actividad = (TextView) findViewById(R.id.txtfecha_actividad);
        txtTipoActividad = (TextView) findViewById(R.id.txtTipoActividad);
        txtDescAccion = (TextView) findViewById(R.id.txtDescAccion);
        txtGlosa = (TextView) findViewById(R.id.txtGlosa);

        txtProceso.setText(suspension.getProceso());
        txtMedidor.setText(suspension.getMedidor());
        txtSuscriptor.setText(suspension.getSuscriptor());
        txtCiclo.setText(suspension.getCiclo());
        txtMunicipio.setText(suspension.getMunicipio());
        txtDireccion.setText(suspension.getDireccion());
        txtfecha_actividad.setText(suspension.getFecha_actividad());
        txtTipoActividad.setText(suspension.getTipo_actividad());
        txtDescAccion.setText(suspension.getDesc_accion());
        txtGlosa.setText(suspension.getGlosa());


        //Toast.makeText(this, suspension.getDireccion(), Toast.LENGTH_SHORT).show();

    }
}
