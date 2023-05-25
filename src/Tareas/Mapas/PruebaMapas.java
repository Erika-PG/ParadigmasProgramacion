package Tareas.Mapas;

import java.util.*;

public class PruebaMapas {
    public static void main(String[] args) {
        HashMap<String, Integer> calificaciones = new HashMap<>();
        calificaciones.put("Carlos", 100);
        calificaciones.put("Roberto", 90);
        calificaciones.put("Carolina", 80);
        imprimirMapa(calificaciones);

        //Actualizar calificacion del usuario Carlos
        calificaciones.put("Carlos", 60);
        imprimirMapa(calificaciones);

        //Borrar registro de Carlos
        calificaciones.remove("Carlos");
        imprimirMapa(calificaciones);

        //¿cual es la calificación de carolina?
        System.out.println("Calificacion de Carolina: "+ calificaciones.get("Carolina"));

        //¿existe una persona en el mapa?
        if( calificaciones.containsKey("Carolina")){
            System.out.println("Carolina existe");
        } else {
            System.out.println("No existe Carolina");
        }
        boolean encontrado1 = encontrar(calificaciones, "Carolina");
        System.out.println(encontrado1);
        boolean encontrado2 = encontrar(calificaciones, "Maria");
        System.out.println(encontrado2);
        calificaciones.remove("Maria");

    }
    private static boolean encontrar(HashMap<String, Integer> calificaciones, String nombre){
        return calificaciones.containsKey(nombre);
    }

    public static void imprimirMapa(HashMap<String, Integer> tabla){
        //mostrar los datos
        tabla.forEach(
                (nombre, calificacion)->{
                    System.out.println(nombre + " "+ calificacion);
                }
        );
                System.out.println("-----------------------------------------------");
    }

}
