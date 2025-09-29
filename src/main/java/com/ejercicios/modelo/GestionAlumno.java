package com.ejercicios.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestionAlumno implements AlumnoMInterfaz{
    private List<Alumno> listaAlumnos = new ArrayList<>();

    @Override
    public void insertarAlumno(Alumno alumno){
        listaAlumnos.add(alumno);
    }
    
    @Override
    public List<Alumno> getListaAlumnos(){
        return listaAlumnos;
    }
}
