package com.itla.escuela.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.escuela.R;
import com.itla.escuela.entidades.Estudiante;

import java.util.ArrayList;

public class EstudianteAdaptador extends RecyclerView.Adapter {
    ArrayList<Estudiante>estudiantes;
   static  TextView tvnombre, tvcarrera, tvmatricula ;

    public EstudianteAdaptador(ArrayList<Estudiante>estudiantes) {
        this.estudiantes=estudiantes;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvnombre = itemView.findViewById(R.id.tvitemestnombre);
            tvcarrera = itemView.findViewById(R.id.tvitemestcarrera);
            tvmatricula = itemView.findViewById(R.id.tvitemestmatricula);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_estudiantes,parent ,false);

        EstudianteAdaptador.MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Estudiante estudiante = estudiantes.get(position);
        tvcarrera.setText("Carrera");
        tvnombre.setText(estudiante.getNombre());
        tvmatricula.setText(estudiante.getMatricula());

    }

    @Override
    public int getItemCount() {
        return estudiantes.size();
    }
}
