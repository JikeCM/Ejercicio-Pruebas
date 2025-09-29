package com.ejercicios.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ejercicios.modelo.Alumno;
import com.ejercicios.modelo.AlumnoMInterfaz;
import com.ejercicios.vista.AlumnoVInterfaz;
import com.ejercicios.vista.AlumnoVista;

public class AlumnoControlador {
    private final String SALIR_APLICACION = "Salimos de la aplicación alumnado";
    private final String MENSAJE_ERROR = "ERROR opción no válida";
    private AlumnoMInterfaz modelo;
    private AlumnoVInterfaz vista;
    private List<String> datosAlumno = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int opcion;

    public AlumnoControlador(AlumnoMInterfaz modelo, AlumnoVInterfaz vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void ejecutarAplicación(){
        boolean abierto = true;
        while (abierto) {
            System.out.println(vista.menu());
            try{
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case AlumnoVista.OPCION_INSERTAR_ALUMNO:
                    datosAlumno.clear();
                    System.out.println(vista.preguntarNombre());
                    datosAlumno.add(sc.nextLine());
                    System.out.println(vista.preguntarApellido());
                    datosAlumno.add(sc.nextLine());
                    System.out.println(vista.preguntarEdad());
                    datosAlumno.add(sc.nextLine());
                    if(Integer.parseInt(datosAlumno.get(2))>-1){
                    Alumno alumno = new Alumno(datosAlumno.get(0),datosAlumno.get(1),Integer.parseInt(datosAlumno.get(2)));
                    modelo.insertarAlumno(alumno);
                    }
                    else{
                        System.out.println("Tiene que ser un número positivo");
                    }
                    break;
                case AlumnoVista.OPCION_MOSTRAR_ALUMNO:
                    System.out.println(vista.getListaAlumnos(modelo.getListaAlumnos()));
                    break;
                case AlumnoVista.OPCION_SALIR:
                    abierto = false;
                    System.out.println(SALIR_APLICACION);
                    break;
                default:
                    System.out.println(MENSAJE_ERROR);
            }
            } catch(NumberFormatException nfe){
                 System.out.println("Solo se permiten números");
            } 
        }
    }
}
