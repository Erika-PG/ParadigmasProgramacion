package Empleados_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import static java.util.stream.DoubleStream.of;

public class ProcesarEmpleados {
    public static void main(String[] args) {
        Empleado[] empleados = {
                new Empleado("José", "García", 5000, "TI"),
                new Empleado("Rosario", "Vázquez", 7600, "TI"),
                new Empleado("Luis", "Prieto", 10000, "TI"),
                new Empleado("Luis", "Vázquez", 4500, "Ventas"),
                new Empleado("Gabriela", "Prieto", 6000, "Ventas"),
                new Empleado("Vianney", "Rodriguez", 65000, "Marketing"),
                new Empleado("Francisco", "Vázquez", 50000, "Marketing"),
                new Empleado("Irma", "Dominguez", 7500, "Ventas"),
                new Empleado("Rosario", "Prieto", 100000, "Marketing")
        };
        List<Empleado> listaEmpleados = Arrays.asList(empleados);
        // Muestra a todos los empleados
        System.out.println("Lista completa de empleados");
        imprimirEncabezado();
        listaEmpleados.stream().forEach(System.out::println);
        imprimirRenglon();

         //Mostrar empleados cuyo apellido sea Vazquez
        List<Empleado> VazquezEmpleados = listaEmpleados.stream()
                .filter(empleado -> empleado.getApellidoPaterno().equalsIgnoreCase("Vázquez"))
                .collect(Collectors.toList());
        System.out.println("Lista de empleados Vázquez");
        VazquezEmpleados.forEach(System.out::println);
        imprimirRenglon();

        // Suma todos los salarios de los empleados con el metodo sum
        double TotalSalarios =
                listaEmpleados.stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
        System.out.printf("Suma total: %.2f", TotalSalarios);
        imprimirRenglon();


        //Suma de todos los salarios cuyo salario sea mayor o igual a $10,000(con el metodo reduce)
        double totalSalarios10K = listaEmpleados.stream()
                .filter(empleado -> empleado.getSalario() >=10000)
                .mapToDouble(Empleado::getSalario)
                .reduce(0, Double::sum);
        System.out.println("La suma de los salarios de los empleadoscon salario mayor o igual a 10000 es: "
                + totalSalarios10K);
        imprimirRenglon();


        // mostar nombre y apellido de los del departamento de marketing
        System.out.println("Lista empleados del departamento de Marketing");
        listaEmpleados.stream()
                .filter(empleado -> empleado.getDepartamento().equalsIgnoreCase("Marketing"))
                .map(empleado -> empleado.getPrimerNombre()+ " "+ empleado.getApellidoPaterno())
                .forEach(System.out::println);
        imprimirRenglon();

        // salario mas alto de los de TI
        double salarioMaximoTI = listaEmpleados.stream()
                .filter(empleado -> empleado.getDepartamento().equalsIgnoreCase("TI"))
                .mapToDouble(empleado -> empleado.getSalario())
                .max().getAsDouble();
        System.out.printf("¿Cual es el salario más alto en los empleados de TI? %.2f", salarioMaximoTI);
        imprimirRenglon();

        //¿Cuántos empleados hay en ventas?
        long cantidadEmpleadosVentas = Arrays.stream(empleados)
                .filter(empleado -> empleado.getDepartamento().equals("Ventas")).count();
        System.out.println("Número de empleados de ventas: " + cantidadEmpleadosVentas);
        imprimirRenglon();

    }


    public static void imprimirRenglon() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public static void imprimirEncabezado() {
        System.out.printf("%12s %12s %12s %12s%n", "Nombre", "Apellidos", "Salario", "Departamento");
        System.out.println("-----------------------------------------------------");
    }
}



