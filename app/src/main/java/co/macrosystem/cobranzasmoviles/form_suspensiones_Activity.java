package co.macrosystem.cobranzasmoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class form_suspensiones_Activity extends AppCompatActivity {

    private Suspension suspension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_suspensiones);

        suspension = getIntent().getParcelableExtra("objSuspension");
        Toast.makeText(this, suspension.getDireccion(), Toast.LENGTH_SHORT).show();

    }
}
