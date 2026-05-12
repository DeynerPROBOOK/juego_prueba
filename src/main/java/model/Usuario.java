
package model;

/**
 * Representa un usuario del juego con datos básicos como correo, nombre, edad y género.
 */
public class Usuario {

    // Atributos de la clase Usuario.
    String e_mail;
    String nombre;
    int edad;
    char genero;
    boolean activo;

    /**
     * Constructor vacío: crea un usuario activo sin valores definidos.
     */
    public Usuario() {
        activo = true; // Por defecto, el usuario se considera activo al ser creado.
    }

    /**
     * Constructor con todos los parámetros para inicializar el usuario.
     */
    public Usuario(boolean activo, String e_mail, int edad, char genero, String nombre) {
        this.activo = activo;
        this.e_mail = e_mail;
        this.edad = edad;
        this.genero = genero;
        this.nombre = nombre;
    }

    /**
     * Constructor más sencillo usado en Main.java.
     * El usuario se crea como activo de forma predeterminada.
     */
    public Usuario(String e_mail, String nombre, int edad, char genero) {
        this.activo = true;
        this.e_mail = e_mail;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    // Getters y setters para acceder y modificar los atributos.
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

    /**
     * Devuelve una representación en texto del usuario.
     */
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
