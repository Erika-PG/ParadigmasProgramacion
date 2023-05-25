package ComparadorPersonal;
import java.util.Comparator;

public class ComparadorEdadNombre implements Comparator<Persona> {

    @Override
    public int compare(Persona persona1, Persona persona2){
        // primero se compara la edad
        if(persona1.getEdad() > persona2.getEdad()){
    return 1;
        } else if(persona1.getEdad() < persona2.getEdad()){
            return -1;
        }
        // si las edades son iguales, entonces comparar el nombre
        return persona1.getNombre().compareTo(persona2.getNombre());
    }

}
