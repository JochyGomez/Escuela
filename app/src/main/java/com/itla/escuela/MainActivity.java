package com.itla.escuela;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itla.escuela.entidades.Estudiante;
import com.itla.escuela.repositorio.EstudianteRepositorio;
import com.itla.escuela.repositorio.EstudianteRepositorioDbImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EstudianteRepositorio estudianteRepositorio;
    EditText nom,mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         nom = findViewById(R.id.nombre_carrera);
         mat = findViewById(R.id.matricula_estudiante);
        Button guarda = findViewById(R.id.btnguardar);

        guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estudianteRepositorio = new EstudianteRepositorioDbImpl(getApplicationContext());
                Estudiante estl = new Estudiante();
                estl.setNombre(nom.getText().toString());
                estl.setMatricula(mat.getText().toString());

                estudianteRepositorio.crear(estl);
                nom.setText("");
                mat.setText("");
                nom.requestFocus();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Estudiante Registrado Satisfactoriamente", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER,0 ,0 );

                toast1.show();


                ArrayList<Estudiante> estudiantes=estudianteRepositorio.buscar_todos();
                for (Estudiante e:estudiantes) {
                    Log.d("result", e.toString());
                }
            }
        });

        Button btnnuevo = findViewById(R.id.btnnuevacarrera);

        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListaCarrera.class);
                startActivity(intent);
            }
        });

    }
}
