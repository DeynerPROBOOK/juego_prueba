
package controller;

import java.util.ArrayList;

import model.Usuario;

public class control_lstUsuarios {
    ArrayList<Usuario> usuarios_j;

    public control_lstUsuarios() {
        // siempre SIEMPRE siempre 
        // separar memoria a todos los arreglos
        usuarios_j = new ArrayList<>();        
    }

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
    
    // METODO Delete - Sea inhabilitar
    // 
    
    public void borrarUsuario(int pos){
        boolean valorActivo = this.usuarios_j.get(pos).isActivo();
        this.usuarios_j.get(pos).setActivo(!valorActivo);
    }
    
    public int buscarUsuario(String correo_b){
        if (this.usuarios_j.isEmpty()) {
            return -1; 
        } else {
            int cont = 0;
            while ( (cont < this.usuarios_j.size()) && 
                    (!this.usuarios_j.get(cont).getE_mail().equals(correo_b)) ) {                
                  cont++;
            }
            if (cont>=this.usuarios_j.size()) {
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
