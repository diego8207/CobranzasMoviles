package co.macrosystem.cobranzasmoviles;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego Velez on 08/02/2017.
 */

public class SuspensionAdaptador extends RecyclerView.Adapter<SuspensionAdaptador.SuspensionViewHolder>{

    ArrayList<Suspension> suspensiones;

    //constructor de la clase recibe el array de objetos
    public SuspensionAdaptador(ArrayList<Suspension> suspensiones){
        this.suspensiones = suspensiones;
    }

    //Inflar el Layout y lo pasara al viewholder para que obtenga los views
    @Override
    public SuspensionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //infla o da vida al Layout CardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_suspensiones, parent, false);
        return new SuspensionViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(SuspensionViewHolder suspensionViewHolder, int position) { // se asigna los valores a los objetos que estaran en la cardview
        Suspension suspension = suspensiones.get(position); //recuperamos de la lista el objeto uno a uno
        suspensionViewHolder.tvMatricula.setText(suspension.getMatricula());
        suspensionViewHolder.tvDireccion.setText(suspension.getDireccion());
    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return suspensiones.size();
    }

    public static class  SuspensionViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMatricula;
        private TextView tvDireccion;

        public SuspensionViewHolder(View itemView) {
            super(itemView);
            tvMatricula = (TextView) itemView.findViewById(R.id.tvMatricula);
            tvDireccion = (TextView) itemView.findViewById(R.id.tvDireccion);
        }


    }

}
