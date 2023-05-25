package AgrupacionEverest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    private String nombreArchivo;

    public Archivo(String nombreA) {
        this.nombreArchivo = nombreA;
    }


    public ArrayList<Monte> leerDeArchivo() {
        ArrayList<Monte> listaMuertes = new ArrayList<>();

        try {
            // Abrir el archivo
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);
            leerArchivo.nextLine();
            // Leer el archivo

            while (leerArchivo.hasNext()) {
                String linea = leerArchivo.nextLine();
                String[] datos = linea.split("\\|");
                String nombre = datos[0];
                String fecha = datos[1];
                double edad = Double.parseDouble(datos[2]);
                String expedicion = datos[3];
                String nacionalidad = datos[4];
                String causaMuerte = datos[5];
                String ubicacion = datos[6];



                Monte MuertosAux = new Monte(nombre, fecha, edad, expedicion, nacionalidad, causaMuerte, ubicacion);
                listaMuertes.add(MuertosAux);


            }

            // Cerrar el archivo
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaMuertes;
    }

}
