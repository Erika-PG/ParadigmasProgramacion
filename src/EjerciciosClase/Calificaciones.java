package EjerciciosClase;

import java.util.ArrayList;
import java.util.List;

public class Calificaciones {
    public static void main(String[] args) {
        Double[] calificaciones = {9.5, 8.6, 9.1, 7.7, 8.9, 6.9, 8.0, 9.3, 7.4, 9.6};
        List<Double> listaCalificaciones = new ArrayList<>();
        System.out.println("ArrayList: ");
        for(double calificacion: calificaciones){
            listaCalificaciones.add(calificacion);
        }
        for(int i=0; i < listaCalificaciones.size(); i++){
            System.out.println(listaCalificaciones.get(i));
        }
    }
}
