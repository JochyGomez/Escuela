package com.itla.escuela.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.escuela.R;
import com.itla.escuela.entidades.Carrera;

import java.util.ArrayList;

public class CarreraAdaptador extends RecyclerView.Adapter {
    ArrayList<Carrera>carreras;
   static  TextView tvcarrera, tvmateria;

    public CarreraAdaptador(ArrayList<Carrera>carreras) {
        this.carreras=carreras;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvcarrera = itemView.findViewById(R.id.tvitemestcarrera);
            tvmateria = itemView.findViewById(R.id.tvitemestmatricula);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_carreras,parent ,false);

        CarreraAdaptador.MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Carrera carrera = carreras.get(position);
        tvcarrera.setText(carrera.getCarrera());
        tvmateria.setText(carrera.getMateria());

    }

    @Override
    public int getItemCount() {
        return carreras.size();
    }
}
