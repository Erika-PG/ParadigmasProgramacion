package ComparadorPersonal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparadorPersona {
    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Jeon", "Jungkook", 26));
        listaPersonas.add(new Persona("Kim", "Taehyung", 28));
        listaPersonas.add(new Persona("Kim", "Seokjin", 31));
        listaPersonas.add(new Persona("Jung", "Hoseok", 29));
        listaPersonas.add(new Persona("Park", "Jimin", 28));
        listaPersonas.add(new Persona("Min", "Yoongi", 30));
        listaPersonas.add(new Persona("Kim", "Namjoon", 29));

        // imprime los elementos del objeto list
        System.out.println("Elementos desordenados: ");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();

        //Ordenamos por edad
        Collections.sort(listaPersonas, new ComparadorEdad());
        System.out.println("Elementos de la lista ordenados por edad: ");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();

        //Ordenamos por Nombre
        Collections.sort(listaPersonas, new ComparadorNombre());
        System.out.println("Elementos de la lista ordenados por Nombre: ");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();

        //implementar ordenamiento por apellidos. Crear menu
        Collections.sort(listaPersonas, new ComparadorApellido());
        System.out.println("Elementos de la lista ordenados por Apellido: ");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();
        // 1. ordenar por nombre
        // 2. ordenar por apellido
        // 3. ordenar por edad
        // 4. salir

    }
}
