package Tareas.Mapas;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;


public class ConteoTipoPalabras {
    public static void main(String[] args) {
        Map<String, Integer> miMapa = new HashMap<>();
        crearMapa(miMapa);
        mostrarMapa(miMapa);
    }

    private static void crearMapa(Map<String, Integer> frecuencias){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe un enunciado: ");
        String enunciado = entrada.nextLine();

        // divide el enunciado en tokens
        String[] tokens = enunciado.split(" ");

        // procesamiento del texto de entrada
        for(String token : tokens) {
            String palabra = token.toLowerCase();
            // si el mapa de freciencias contiene la entrada
            if (frecuencias.containsKey(palabra)){
                int cuenta = frecuencias.get(palabra);
                frecuencias.put(palabra, cuenta +1);
            } else {
                frecuencias.put(palabra, 1);
            }
        }

    }
    // muestra el contenido del mapa
    public  static void mostrarMapa(Map<String, Integer> frecuencias){
        Set<String> claves = frecuencias.keySet();
        // ordena las llaves
        TreeSet<String> clavesOrdenadas = new TreeSet<>(claves);
        System.out.printf("%nEl mapa contiene: %nClave\t\tValor%n");
        for (String clave : clavesOrdenadas){
            System.out.printf("%-8s%8s%n", clave, frecuencias.get(clave));
        }
        System.out.printf("%nTamaño: %d%n¿Esta vacío el mapa?: %b%n", frecuencias.size(), frecuencias.isEmpty());
    }

}
