package com.itla.escuela.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itla.escuela.entidades.Estudiante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EstudianteRepositorioDbImpl implements EstudianteRepositorio{

    private DbConexion dbConexion;

    public EstudianteRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void crear(Estudiante estudiante) {
        ContentValues cv= new ContentValues();
        cv.put("nombre", estudiante.getNombre());
        cv.put("matricula", estudiante.getMatricula());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
       long id= db.insert( "estudiante", null, cv);

       if(id<= 0){
           Log.i("EstudianteRepositorio", "Ocurrio un error al salvar o guardar estudiante");
       } else {
           Log.d("INFX", "el estudiante se a creado id="+id);
       }
    }

    @Override
    public void actulizar(Estudiante estudiante) {

    }

    @Override
    public void borrar(Estudiante estudiante) {

    }

    @Override
    public Estudiante buscar(int id) {
        return null;
    }

    @Override
    public ArrayList<Estudiante> buscar_todos(){
        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        Cursor cursor = db.query("estudiante", null, null, null, null, null, null);

        ArrayList<Estudiante>  estudiantes=new ArrayList<>();

        while (cursor.moveToNext()){
            Estudiante est = new Estudiante();
            est.setId(cursor.getInt(cursor.getColumnIndex("id")));
            est.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            est.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));

            estudiantes.add(est);
        }
        cursor.close();
        db.close();
        return estudiantes;
    }

}
