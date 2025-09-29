package com.ejercicios.vista;

import java.util.List;

import com.ejercicios.modelo.Alumno;

public class AlumnoVista implements AlumnoVInterfaz{
    public final static int  OPCION_INSERTAR_ALUMNO = 1;
    public final static int  OPCION_MOSTRAR_ALUMNO = 2;
    public final static int  OPCION_SALIR = 3;
    public final String TEXTO_INSERTAR = "Dime %s del alumno a insertar";
    public final String TEXTO_INSERTAR_NOMBRE = String.format(TEXTO_INSERTAR, "el nombre");
    public final String TEXTO_INSERTAR_APELLIDO = String.format(TEXTO_INSERTAR, "el apellido");
    public final String TEXTO_INSERTAR_EDAD = String.format(TEXTO_INSERTAR, "la edad");

    @Override
    public String menu(){
        String menu = String.format("""
                                    --------Menú--------
                                    %d. Insertar Alumnos.
                                    %d. Mostrar Alumnos.
                                    %d. Salir.
                                    --------------------
                                    """,OPCION_INSERTAR_ALUMNO,OPCION_MOSTRAR_ALUMNO,OPCION_SALIR);
        return menu;
        }
    
    @Override
    public String preguntarNombre() {
        return TEXTO_INSERTAR_NOMBRE;
    }
    
    @Override
    public String preguntarApellido(){
        return TEXTO_INSERTAR_APELLIDO;
    }

    @Override
    public String preguntarEdad(){
        return TEXTO_INSERTAR_EDAD;
    }

    @Override
    public String getListaAlumnos(List<Alumno> alumnos){
        if (alumnos.isEmpty()) {
            return "No hay alumnos dados de alta";        
        }
        String lista = "";
        for(Alumno alumno : alumnos){
        lista += String.format("""
                        --------Lista--------
                        -Nombre: %s
                        -Apellido: %s
                        -Edad: %d
                        """,alumno.getNombre(),
                        alumno.getApellidos(),
                        alumno.getEdad()); 
        }
    return lista;
    }
}