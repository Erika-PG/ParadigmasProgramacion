package Empleados_Stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo_texto {

    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();

        try {
            FileWriter fw = new FileWriter("Empleado.txt");
            for (Empleado empleado : listaEmpleados) {
                fw.write(empleado.getPrimerNombre() + "," + empleado.getApellidoPaterno() + ","
                        + empleado.getSalario() + empleado.getDepartamento() + "\n");
            }
            System.out.println("Se ha creado el archivo correctamente");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }
    }
}