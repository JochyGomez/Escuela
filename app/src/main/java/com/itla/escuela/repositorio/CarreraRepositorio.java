package com.itla.escuela.repositorio;

import com.itla.escuela.entidades.Carrera;

import java.util.ArrayList;

public interface CarreraRepositorio {

   void crear(Carrera carrera);
   void actulizar(Carrera carrera);
   void borrar(Carrera carrera);
   Carrera buscar(int id);
   ArrayList<Carrera> buscar_todos();

}
