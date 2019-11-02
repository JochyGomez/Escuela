package com.itla.escuela;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.escuela.adaptadores.EstudianteAdaptador;
import com.itla.escuela.entidades.Estudiante;
import com.itla.escuela.repositorio.EstudianteRepositorioDbImpl;

import java.util.ArrayList;

public class ListaEstudiantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

        EstudianteRepositorioDbImpl estudianteRepositorioDb = new EstudianteRepositorioDbImpl(this);
        ArrayList<Estudiante> estudianteArrayList = estudianteRepositorioDb.buscar_todos();

        RecyclerView recyclerView = findViewById(R.id.rclista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        EstudianteAdaptador estudianteAdaptador = new EstudianteAdaptador(estudianteArrayList);
        recyclerView.setAdapter(estudianteAdaptador);

        Button btnnuevo = findViewById(R.id.btnnuevoestudiante);

        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
