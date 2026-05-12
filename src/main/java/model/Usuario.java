
package model;

public class Usuario {

//Atributos de la clase Usuario 
    String e_mail;
    String nombre;
    int edad;
    char genero;
    //----------------
    boolean activo;
    //-----------------

// Constructor vacío para crear un objeto Usuario sin inicializar sus atributos
    public Usuario() {
    }

// Constructor con parámetros para inicializar los atributos de la clase Usuario
    public Usuario(boolean activo, String e_mail, int edad, char genero, String nombre) {
        this.activo = activo;
        this.e_mail = e_mail;
        this.edad = edad;
        this.genero = genero;
        this.nombre = nombre;
    }

// Getters y Setters de la clase Usuario
    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

// Método toString para representar el objeto Usuario como una cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("e_mail=").append(e_mail);
        sb.append(", nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", genero=").append(genero);
        sb.append(", activo=").append(activo);
        sb.append('}');
        return sb.toString();
    }

}//fin clase Usuario
