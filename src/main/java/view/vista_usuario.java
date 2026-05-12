// Esta clase representa la vista para el usuario, donde se pueden mostrar opciones y recibir entradas del usuario

package view;

import model.Usuario;
import java.util.Scanner;

public class vista_usuario {

// Constructor vacío para crear un objeto vista_usuario sin inicializar sus atributos
    public vista_usuario() {
    }

    public String  leer_cadena(String mensaje) {

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc_leer = new Scanner(System.in);
        // Variable para almacenar la cadena leída del usuario
        String cad;
        // Mostrar el mensaje al usuario y leer la entrada
        System.out.println(mensaje);
        // Leer la cadena ingresada por el usuario
        cad = sc_leer.nextLine();
        // Devolver la cadena leída
        return cad;

    }// fin método leer_cadena

    public int leer_entero(String mensaje) {

        Scanner sc_leer = new Scanner(System.in);
        int num = 0;
// Utilizar un bucle para asegurarse de que se ingrese un número entero válido
        do { 
            // Intentar leer un número entero y manejar cualquier excepción que pueda ocurrir si el usuario ingresa algo que no es un número
            try {
                System.out.println(mensaje);
                num = sc_leer.nextInt();
                // Si se ingresa un número entero válido, salir del bucle
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                sc_leer.nextLine(); // Limpiar el buffer del scanner
            }
            // El bucle continuará hasta que se ingrese un número entero válido
        } while (num == 0); // Repetir hasta que se ingrese un número entero válido
        return num;

    }// fin método leer_entero

    public Usuario leer_usuario(){
            // defini el objeto que voy a leer 
        // se le tiene que separar memoria
        Usuario obj_usuario = new Usuario();
       
        // leer nombre, identificacion (String)
        // leer edad (int)
        String cad = leer_cadena("nombre ? ");         // capturar datos del teclado  
        obj_usuario.setNombre(cad);        // asignar datos en la variable  
        //  leer identificacion
        obj_usuario.setE_mail(leer_cadena(" correo ? "));
        // leer edad 
        obj_usuario.setEdad(leer_entero("edad ? "));
        // leer genero
        obj_usuario.setGenero(leer_cadena("genero M - F - O").charAt(0));
        // leer activo        obj_usuario.setActivo(leer_cadena("activo S - N").equalsIgnoreCase("S"));
        return obj_usuario;


    }

  

    
}// fin clase vista_usuario
