package com.itla.escuela.entidades;

public class Carrera {
    private Integer id;
    private String carrera;
    private String materia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", carrera='" + carrera + '\'' +
                ", materia='" + materia + '\'' +
                '}';
    }
}
