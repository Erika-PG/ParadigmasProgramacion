package AgrupacionEverest;

public class Monte {
    private String nombre;
    private String fecha;
    private Double edad;
    private String expedicion;
    private String nacionalidad;
    private String causaMuerte;
    private String ubicacion;

    public Monte(String nombre, String fecha, Double edad, String expedicion, String nacionalidad, String causaMuerte, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.edad = edad;
        this.expedicion = expedicion;
        this.nacionalidad = nacionalidad;
        this.causaMuerte = causaMuerte;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public String getExpedicion() {
        return expedicion;
    }

    public void setExpedicion(String expedicion) {
        this.expedicion = expedicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCausaMuerte() {
        return causaMuerte;
    }

    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte = causaMuerte;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return String.format("%-40s %-20s %-10s %-70s %-30s %-155s %-20s%n", nombre, fecha, edad, expedicion, nacionalidad, causaMuerte, ubicacion);

    }

    public String obtenernombreFechaCausaMuerte(){
        return String.format("%s %s %s" , nombre, fecha, causaMuerte);
    }



}

