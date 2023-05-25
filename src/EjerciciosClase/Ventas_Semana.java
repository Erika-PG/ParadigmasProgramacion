package EjerciciosClase;


import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.util.stream.DoubleStream.of;

public class Ventas_Semana {
    public static void main(String[] args) {
        double[] Ventas = {31.0,9999.456, 1000.345, 7000.234, 3400.6789, 9600.2322, 4500.8025};
        System.out.print("Ventas de la semana: ");
        DoubleStream.of(Ventas)
                .forEach(ventas -> System.out.printf("%1f ", ventas));
        imprimirLinea();
        System.out.print("Ventas que superaron los 1000 pesos: ");
        DoubleStream.of(Ventas)
                .filter(venta -> venta > 1000.00)
                .forEach(venta -> System.out.printf("%1f ", venta));
        System.out.println();
        System.out.printf("Número de ventas que superaron los 1000 pesos: " +
                DoubleStream.of(Ventas).filter(venta -> venta > 1000.00).count() );
        imprimirLinea();
        System.out.printf("Total de ventas: " + DoubleStream.of(Ventas).sum() );
        imprimirLinea();
        System.out.println("Venta máxima del rango de 1000 a 2000: " +
                DoubleStream.of(Ventas).filter(venta -> 1000 <= venta && venta <= 2000 ).max().getAsDouble());
        imprimirLinea();
        System.out.println("Venta minima del rango de 0 a 5000: " +
                DoubleStream.of(Ventas).filter(venta -> 0 <= venta && venta <= 5000 ).min().getAsDouble());
        imprimirLinea();
        System.out.print("Promedio de ventas: " + DoubleStream.of(Ventas).average().getAsDouble());
    }
    public static void imprimirLinea() {
        System.out.println();
        System.out.println("-------------------------------------------------------");
    }

}
