package com.itla.escuela.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.escuela.entidades.Carrera;

import java.util.ArrayList;

public class CarreraRepositorioDbImpl implements CarreraRepositorio{

    private DbConexion dbConexion;

    public CarreraRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void crear(Carrera carrera) {
        ContentValues cv= new ContentValues();
        cv.put("carrera", carrera.getCarrera());
        cv.put("materia", carrera.getMateria());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
       long id= db.insert( "carrera", null, cv);

       if(id<= 0){
           Log.i("CarreraRepositorio", "Ocurrio un error al salvar o guardar carrera");
       } else {
           Log.d("INFX", "la carrera se a creado id="+id);
       }
    }

    @Override
    public void actulizar(Carrera carrera) {

    }

    @Override
    public void borrar(Carrera carrera) {

    }

    @Override
    public Carrera buscar(int id) {
        return null;
    }

    @Override
    public ArrayList<Carrera> buscar_todos(){
        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        Cursor cursor = db.query("carrera", null, null, null, null, null, null);

        ArrayList<Carrera>  carreras=new ArrayList<>();

        while (cursor.moveToNext()){
            Carrera est = new Carrera();
            est.setId(cursor.getInt(cursor.getColumnIndex("id")));
            est.setCarrera(cursor.getString(cursor.getColumnIndex("carrera")));
            est.setMateria(cursor.getString(cursor.getColumnIndex("materia")));

            carreras.add(est);
        }
        cursor.close();
        db.close();
        return carreras;
    }

}
