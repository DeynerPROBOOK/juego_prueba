
package controller;

import java.util.ArrayList;

import model.Usuario;

/**
 * Controlador que administra una lista de objetos Usuario.
 * Permite agregar usuarios, buscar un usuario por correo y cambiar su estado.
 */
public class control_lstUsuarios {

    /** Lista de usuarios gestionada por el controlador. */
    ArrayList<Usuario> usuarios_j;

    /**
     * Constructor que inicializa la lista de usuarios.
     */
    public control_lstUsuarios() {
        usuarios_j = new ArrayList<>();
    }

    /**
     * Constructor que recibe una lista de usuarios existente.
     */
    public control_lstUsuarios(ArrayList<Usuario> usuarios_j) {
        this.usuarios_j = usuarios_j;
    }

    public ArrayList<Usuario> getUsuarios_j() {
        return usuarios_j;
    }

    public void setUsuarios_j(ArrayList<Usuario> usuarios_j) {
        this.usuarios_j = usuarios_j;
    }

    //----------------------------------------------
    //     CRUD-S
    //----------------------------------------------

    /**
     * Cambia el estado activo/inactivo de un usuario en la posición indicada.
     * Este método no elimina el usuario de la lista.
     */
    public void borrarUsuario(int pos) {
        boolean valorActivo = this.usuarios_j.get(pos).isActivo();
        this.usuarios_j.get(pos).setActivo(!valorActivo);
    }

    /**
     * Busca un usuario por su correo electrónico y devuelve su posición.
     * Devuelve -1 si el usuario no se encuentra.
     */
    public int buscarUsuario(String correo_b) {
        if (this.usuarios_j.isEmpty()) {
            return -1;
        } else {
            int cont = 0;
            while ((cont < this.usuarios_j.size()) &&
                    (!this.usuarios_j.get(cont).getE_mail().equals(correo_b))) {
                cont++;
            }
            if (cont >= this.usuarios_j.size()) {
                return -1;
            } else {
                return cont;
            }
        }
    }// fin de buscar usuario

    //-----------------------------------------------

    @Override
    public String toString() {
        return "control_lstUsuarios{" + "usuarios_j=" + usuarios_j + '}';
    }

}
