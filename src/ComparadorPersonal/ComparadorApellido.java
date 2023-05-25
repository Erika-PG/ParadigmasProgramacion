package ComparadorPersonal;

import java.util.Comparator;

public class ComparadorApellido implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2){
        return persona1.getApellido().compareTo(persona2.getApellido());

    }
}
