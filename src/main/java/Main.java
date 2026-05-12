
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.control_lstUsuarios;
import model.Archivo;
import model.Usuario;
import model.rasgoPersonalidad;





/**
 * Clase principal del programa.
 * Aquí se inicializa el arreglo de rasgos, se leen archivos y se prueba el controlador de usuarios.
 */
public class Main {

    /**
     * Lista global de rasgos de personalidad que se puede usar en todas las partes del programa.
     */
    public static ArrayList<rasgoPersonalidad> rasgos;

    public static void main(String[] args) {

        // separarle memoria al arreglo
        // Se inicializa la lista ArrayList para almacenar objetos rasgoPersonalidad
        rasgos = new ArrayList<>();

        // Se crea una instancia del objeto Archivo para leer y procesar los archivos de texto
        Archivo obj_archivo = new Archivo();
        
        // Se llama a mostrar_archivo() que lee rasgos_personalidad.txt
        // El método retorna un String con todo el contenido del archivo
        String rasgosContenido = obj_archivo.mostrar_archivo();
        
        // Se muestra el contenido completo de los rasgos en una ventana emergente (JOptionPane)
        // Esto permite al usuario visualizar todos los 40 rasgos de personalidad
        JOptionPane.showMessageDialog(null, "RASGOS DE PERSONALIDAD:\n" + rasgosContenido);
        
        // mostrar el arreglo en consola
        // Actualmente muestra [] porque el método mostrar_archivo() no llena la lista rasgos
        System.out.println(rasgos);

        //------------------------------------
        // SECCIÓN DE GESTIÓN DE USUARIOS
        //------------------------------------
        
        // Se crea el controlador de usuarios que administra la lista de objetos Usuario
        control_lstUsuarios mis_usu = new control_lstUsuarios();
        
        // Se agregan 5 usuarios de ejemplo a la lista del controlador
        // Formato: new Usuario(correo, nombre, edad, genero)
        mis_usu.getUsuarios_j().add(new Usuario("ju@ju", "jota", 13, 'M'));
        mis_usu.getUsuarios_j().add(new Usuario("pe@ju", "pepe", 20, 'O'));
        mis_usu.getUsuarios_j().add(new Usuario("juli@ju", "liana", 23, 'F'));
        mis_usu.getUsuarios_j().add(new Usuario("ZU@ju", "ZULU", 13, 'M'));
        mis_usu.getUsuarios_j().add(new Usuario("Mar@ju", "marcela", 20, 'F'));

        // Se busca un usuario por su correo electrónico
        // CORRECCIÓN: El correo es "ZU@ju" (no "ZUL@ju" como estaba antes)
        // Esto permite encontrar al usuario "ZULU" en la posición 3 de la lista
        int pos = mis_usu.buscarUsuario("ZU@ju");
        
        // Se muestra la posición encontrada en una ventana emergente
        // Si pos = -1, el usuario no fue encontrado
        // Si pos >= 0, es la posición en el ArrayList donde se encuentra el usuario
        JOptionPane.showMessageDialog(null, "posicion es : " + pos);
        
        // Si el usuario fue encontrado (pos != -1)
        if (pos != -1) {
            // Se muestra los datos del usuario encontrado en una ventana emergente
            // Muestra: Usuario{e_mail=ZU@ju, nombre=ZULU, edad=13, genero=M, activo=true}
            JOptionPane.showMessageDialog(null, mis_usu.getUsuarios_j().get(pos));
            
            // Se cambia el estado del usuario de activo (true) a inactivo (false)
            // Este método invierte el valor del atributo activo
            mis_usu.borrarUsuario(pos);
            
            // Se muestra nuevamente el usuario para verificar que su estado cambió a inactivo
            // Ahora debe mostrar: activo=false
            JOptionPane.showMessageDialog(null, mis_usu.getUsuarios_j().get(pos));
        }

        //------------------------------------
        // SECCIÓN DE LECTURA DE ARTEFACTOS
        //------------------------------------
        
        // Se llama a mostrar_artefacto() que lee artefactos_2.txt
        // El método procesa cada línea y retorna un String formateado con toda la información
        String artefactosContenido = obj_archivo.mostrar_artefacto();
        
        // Se muestra el contenido de los artefactos en una ventana emergente
        // Incluye cada artefacto con sus características y opciones formateadas
        JOptionPane.showMessageDialog(null, "ARTEFACTOS:\n" + artefactosContenido);

    }// fin método main
}// fin clase Main