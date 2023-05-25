package ComparadorPersonal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean  salir = false;
        int opcion;
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Jeon", "Jungkook", 26));
        listaPersonas.add(new Persona("Kim", "Taehyung", 28));
        listaPersonas.add(new Persona("Kim", "Seokjin", 31));
        listaPersonas.add(new Persona("Jung", "Hoseok", 29));
        listaPersonas.add(new Persona("Park", "Jimin", 28));
        listaPersonas.add(new Persona("Min", "Yoongi", 30));
        listaPersonas.add(new Persona("Kim", "Namjoon", 29));

        System.out.println("Elementos desordenados: ");
        listaPersonas.forEach(persona -> System.out.println(persona));
        System.out.println();

        do {
            menu();
            System.out.println("Elige la opción: ");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    Collections.sort(listaPersonas, new ComparadorNombre());
                    System.out.println("Elementos de la lista ordenados por nombre: ");
                    listaPersonas.forEach(persona -> System.out.println(persona));
                    System.out.println();
                    break;
                case 2:
                    Collections.sort(listaPersonas, new ComparadorApellido());
                    System.out.println("Elementos de la lista ordenados por apellido: ");
                    listaPersonas.forEach(persona -> System.out.println(persona));
                    System.out.println();
                    break;
                case 3:
                    Collections.sort(listaPersonas, new ComparadorEdad());
                    System.out.println("Elementos de la lista ordenados por edad: ");
                    listaPersonas.forEach(persona -> System.out.println(persona));
                    System.out.println();
                    break;
                case 4:
                    Collections.sort(listaPersonas, new ComparadorEdadNombre());
                    System.out.println("Elementos de la lista ordenados por edad y nombre: ");
                    listaPersonas.forEach(persona -> System.out.println(persona));
                    System.out.println();
                    break;
                case 5:
                    Collections.sort(listaPersonas, new ComparadorNombreEdad());
                    System.out.println("Elementos de la lista ordenados por nombre y edad: ");
                    listaPersonas.forEach(persona -> System.out.println(persona));
                    System.out.println();
                    break;
            }
        } while (opcion != 6);

    }
    public static void menu() {
        System.out.println("\nMENU");
        System.out.println("1)Ordenar por nombre");
        System.out.println("2)Ordenar por apellido");
        System.out.println("3)Ordenar por edad");
        System.out.println("4)Ordenar por edad y nombre");
        System.out.println("5)Ordenar por nombre y edad");
        System.out.println("6)Salir");
        }

    }

