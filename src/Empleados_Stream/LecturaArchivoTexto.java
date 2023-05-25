package Empleados_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivoTexto {


    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("Empleado.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                String primerNombre = valores[0];
                String apellidoPaterno = valores[1];
                double salario = Double.parseDouble(valores[2]);
                String departamento = valores[3];
                Empleado empleado = new Empleado(primerNombre, apellidoPaterno, salario, departamento);

                // Aquí puedes hacer lo que necesites con el objeto empleado,
                // como guardarlo en un ArrayList o en una base de datos.
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();

        }
        }
    }

