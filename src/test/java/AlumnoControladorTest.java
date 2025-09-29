
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejercicios.controlador.AlumnoControlador;
import com.ejercicios.modelo.Alumno;
import com.ejercicios.modelo.AlumnoMInterfaz;
import com.ejercicios.vista.AlumnoVInterfaz;
import com.ejercicios.vista.AlumnoVista;

@ExtendWith(MockitoExtension.class)
public class AlumnoControladorTest {
    @InjectMocks
    AlumnoControlador alumnoControlador;
    
    @Mock
    AlumnoMInterfaz alumnoMInterfaz;

    @Mock
    AlumnoVInterfaz alumnoVInterfaz;

    @Test
    public void insertarAlumnoTest(){
        Mockito.when(alumnoVInterfaz.preguntarNombre()).thenReturn(AlumnoVista.TEXTO_INSERTAR_NOMBRE);
        Mockito.when(alumnoVInterfaz.preguntarApellido()).thenReturn(AlumnoVista.TEXTO_INSERTAR_APELLIDO);
        Mockito.when(alumnoVInterfaz.preguntarEdad()).thenReturn(AlumnoVista.TEXTO_INSERTAR_EDAD);
        
        assertEquals("Dime el nombre del alumno a insertar", alumnoVInterfaz.preguntarNombre());
        assertEquals("Dime el apellido del alumno a insertar", alumnoVInterfaz.preguntarApellido());
        assertEquals("Dime la edad del alumno a insertar", alumnoVInterfaz.preguntarEdad());

        verify(alumnoVInterfaz, times(1)).preguntarNombre();
        verify(alumnoVInterfaz, times(1)).preguntarApellido();
        verify(alumnoVInterfaz, times(1)).preguntarEdad();
    }

    @Test
    public void getListaAlumnosTest(){
        List<Alumno> alumnosMock = new ArrayList<>();
        alumnosMock.add(new Alumno("JK","Z",27));
        alumnosMock.add(new Alumno("JJ","Z",12));
        String simulado = """
                --------Lista--------
                -Nombre: JK
                -Apellido: Z
                -Edad: 27
                --------Lista--------
                -Nombre: JJ
                -Apellido: Z
                -Edad: 12
                """;
        Mockito.when(alumnoVInterfaz.getListaAlumnos(alumnosMock)).thenReturn(simulado);

        assertEquals(alumnoVInterfaz.getListaAlumnos(alumnosMock), simulado);
        verify(alumnoVInterfaz,times(1)).getListaAlumnos(alumnosMock);

    }
}
