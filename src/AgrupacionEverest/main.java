package AgrupacionEverest;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class main {
    public static void main(String[] args) {


        Archivo archivox = new Archivo("muertes_everest.txt");
        List<Monte> listaMuertes = archivox.leerDeArchivo();
        imprimirEncabezado();
        listaMuertes.parallelStream().forEach(System.out::println);

        imprimirRenglon();


        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║ Pesonas por Nacionalidad           ║");
        System.out.println("╚════════════════════════════════════╝");

        Map<String, List<Monte>> agruparPorNacionalidad =
                listaMuertes.stream()
                        .collect(Collectors.groupingBy(Monte::getNacionalidad));

        agruparPorNacionalidad.forEach(
                (nacionalidad, listaMuertesNacionalidad) -> {
                    System.out.println(nacionalidad + ":");
                    for (Monte muerte : listaMuertesNacionalidad) {
                        System.out.printf("  %s (%.1f años) - %s, %s (%s)%n",
                                muerte.getNombre(), muerte.getEdad(), muerte.getCausaMuerte(),
                                muerte.getUbicacion(), muerte.getFecha());
                    }
                    System.out.println("-".repeat(140));
                });

        Map<String, List<Monte>> agruparPorCausa =
                listaMuertes.stream()
                        .collect(Collectors.groupingBy(Monte::getCausaMuerte));

        imprimirRenglon();




        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║ Pesonas por causa                  ║");
        System.out.println("║ de muerte                          ║");
        System.out.println("╚════════════════════════════════════╝");



        agruparPorCausa.forEach(
                (causa, listaMuertesCausa) -> {
                    System.out.println(causa + ":");
                    for (Monte muerte : listaMuertesCausa) {
                        System.out.printf("  %s (%.1f años) - %s, %s (%s)%n",
                                muerte.getNombre(), muerte.getEdad(), muerte.getNacionalidad(),
                                muerte.getUbicacion(), muerte.getFecha());
                    }
                    System.out.println("-".repeat(140));
                });

        imprimirRenglon();

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║ Pesonas por Ubicación              ║");
        System.out.println("╚════════════════════════════════════╝");


        Map<String, List<Monte>> agruparPorUbicacion =
                listaMuertes.stream()
                        .collect(Collectors.groupingBy(Monte::getUbicacion));

        agruparPorUbicacion.forEach(
                (ubicacion, listaMuertesUbicacion) -> {
                    System.out.println(ubicacion + ":");
                    for (Monte muerte : listaMuertesUbicacion) {
                        System.out.printf("  %s (%.1f años) - %s, %s (%s)%n",
                                muerte.getNombre(), muerte.getEdad(), muerte.getNacionalidad(),
                                muerte.getCausaMuerte(), muerte.getFecha());
                    }
                    System.out.println("-".repeat(140));
                });


    }

    public static void imprimirEncabezado(){
        System.out.printf("%-40s %-20s %-10s %-70s %-30s %-155s %-20s%n", "Nombre", "Fecha", "Edad", "Expedición", "Nacionalidad", "Causa de Muerte", "Ubicacion");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------------------------------------------");
    }


    public  static void imprimirRenglon(){
        System.out.println("\n" + "\n");
    }


}


