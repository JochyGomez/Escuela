package com.itla.escuela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.escuela.adaptadores.CarreraAdaptador;
import com.itla.escuela.entidades.Carrera;
import com.itla.escuela.repositorio.CarreraRepositorioDbImpl;

import java.util.ArrayList;

public class ListaCarrera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carreras);

        CarreraRepositorioDbImpl carreraRepositorioDb = new CarreraRepositorioDbImpl(this);
        ArrayList<Carrera> carreraArrayList = carreraRepositorioDb.buscar_todos();

        RecyclerView recyclerView = findViewById(R.id.rclistacarrera);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        CarreraAdaptador carreraAdaptador = new CarreraAdaptador(carreraArrayList);
        recyclerView.setAdapter(carreraAdaptador);

        Button btnnuevo = findViewById(R.id.btnnuevacarrera);

        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
