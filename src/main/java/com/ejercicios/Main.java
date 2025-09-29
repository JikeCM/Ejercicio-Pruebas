package com.ejercicios;

import com.ejercicios.controlador.AlumnoControlador;
import com.ejercicios.modelo.GestionAlumno;
import com.ejercicios.vista.AlumnoVista;

public class Main {
    public static void main(String[] args) {
        GestionAlumno modelo = new GestionAlumno();
        AlumnoVista vista = new AlumnoVista();
        AlumnoControlador controlador = new AlumnoControlador(modelo, vista);

        controlador.ejecutarAplicación();
    }
}