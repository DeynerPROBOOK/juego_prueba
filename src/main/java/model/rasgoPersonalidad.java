package model;

public class rasgoPersonalidad {

    // Atributos de la clase rasgoPersonalidad
    String id_rasgo;
    String nombre_rasgo;
    String descripcion_rasgo;

// Constructor vacío para crear un objeto rasgoPersonalidad sin inicializar sus atributos
    public rasgoPersonalidad() {
    }

// Constructor con parámetros para inicializar los atributos de la clase rasgoPersonalidad
    public rasgoPersonalidad(String descripcion_rasgo, String id_rasgo, String nombre_rasgo) {
        this.descripcion_rasgo = descripcion_rasgo;
        this.id_rasgo = id_rasgo;
        this.nombre_rasgo = nombre_rasgo;
    }

// Getters y Setters de la clase rasgoPersonalidad
    public String getId_rasgo() {
        return id_rasgo;
    }

    public void setId_rasgo(String id_rasgo) {
        this.id_rasgo = id_rasgo;
    }

    public String getNombre_rasgo() {
        return nombre_rasgo;
    }

    public void setNombre_rasgo(String nombre_rasgo) {
        this.nombre_rasgo = nombre_rasgo;
    }

    public String getDescripcion_rasgo() {
        return descripcion_rasgo;
    }

    public void setDescripcion_rasgo(String descripcion_rasgo) {
        this.descripcion_rasgo = descripcion_rasgo;
    }

// Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("rasgoPersonalidad{");
        sb.append("id_rasgo=").append(id_rasgo);
        sb.append(", nombre_rasgo=").append(nombre_rasgo);
        sb.append(", descripcion_rasgo=").append(descripcion_rasgo);
        sb.append('}');
        return sb.toString();
    }

}
