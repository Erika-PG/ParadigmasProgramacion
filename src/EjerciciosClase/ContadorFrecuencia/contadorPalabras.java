package EjerciciosClase.ContadorFrecuencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class contadorPalabras {


        public static void main(String[] args) {

            String nombreArchivo = "C:Users//Erika//ParadigmasProgramacion//src//EjerciciosClase//ContadorFrecuencia//03.1 melville-moby_dick.txt";
            String linea;
            HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

                while ((linea = br.readLine()) != null) {
                    String[] palabras = linea.split("[//W//d]+"); // separa por caracteres no alfanuméricos ni números
                    for (String palabra : palabras) {
                        palabra = palabra.toLowerCase(); // convierte la palabra a minúsculas
                        if (frecuenciaPalabras.containsKey(palabra)) {
                            frecuenciaPalabras.put(palabra, frecuenciaPalabras.get(palabra) + 1);
                        } else {
                            frecuenciaPalabras.put(palabra, 1);
                        }
                    }
                }

                // imprime el diccionario con la frecuencia de cada palabra
                for (String palabra : frecuenciaPalabras.keySet()) {
                    System.out.println(palabra + ": " + frecuenciaPalabras.get(palabra));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


