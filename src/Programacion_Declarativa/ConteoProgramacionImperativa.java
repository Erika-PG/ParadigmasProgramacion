package Programacion_Declarativa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Este programa dado un conjunto de elementos quiere saber
//cuantos numero son mayores a 60

public class ConteoProgramacionImperativa {
    public static void main(String[] args) {
        Double[] numeros = {2.4, 55.6, 90.12, 26.6, 100.0};
        Set<Double> conjuntoNumeros = new HashSet<>(Arrays.asList(numeros));
        int conteo = 0;
        for (double numero:conjuntoNumeros){
            if (numero > 60){
                conteo++;
            }
        }
        System.out.printf("Total de valores mayor a 60: %d", conteo);
    }
}
