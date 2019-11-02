package com.itla.escuela.repositorio;

import com.itla.escuela.entidades.Estudiante;

import java.util.ArrayList;

public interface EstudianteRepositorio {

   void crear(Estudiante estudiante);
   void actulizar(Estudiante estudiante);
   void borrar(Estudiante estudiante);
   Estudiante buscar(int id);
   ArrayList<Estudiante> buscar_todos();

}
