package com.ejercicios.vista;

import java.util.List;

import com.ejercicios.modelo.Alumno;

public interface AlumnoVInterfaz {
    String menu();
    String preguntarNombre();
    String preguntarApellido();
    String preguntarEdad();
    String getListaAlumnos(List<Alumno>alumnos);
}
