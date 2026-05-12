package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {

    // Esta clase se puede utilizar para manejar archivos relacionados con el juego, como guardar y cargar datos de usuarios, rasgos de personalidad, etc.
    // Por ahora, está vacía y se puede implementar según las necesidades del proyecto.
    String nombre;

// Constructor vacío para crear un objeto Archivo sin inicializar sus atributos
    public Archivo() {

    }

// Constructor con parámetros para inicializar los atributos de la clase Archivo
    public Archivo(String nombre) {
        this.nombre = nombre;
    }

// Getters y Setters de la clase Archivo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar_archivo() {
//C:\\Users\\Deyner\\OneDrive - Universidad de Manizales\\Escritorio\\rasgos_personalidad.txt
// Asignar la ruta del archivo que se desea mostrar
        this.setNombre("C:\\Users\\Deyner\\OneDrive - Universidad de Manizales\\Escritorio\\rasgos_personalidad.txt");
        // Crear un objeto File con la ruta del archivo
        File arch = new File(this.getNombre());

        try {
            //determinar para que quiero el archivo
            FileReader lectura = new FileReader(arch);
            //leer el archivo
            BufferedReader b_leer = new BufferedReader(lectura);
            String linea = b_leer.readLine();
            // Utilizar un bucle para leer cada línea del archivo hasta que se alcance el final (cuando linea sea null)
            while (linea != null) {
                System.out.println(linea);
                linea = b_leer.readLine();
            }
            lectura.close();
        }// Si el archivo no se encuentra, se lanzará una excepción FileNotFoundException, que se maneja en el bloque catch correspondiente.
        catch (FileNotFoundException ex) {
            System.getLogger(Archivo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }// Si el archivo no se encuentra, se lanzará una excepción FileNotFoundException, que se maneja en el bloque catch correspondiente.
        catch (IOException ex) {
            System.getLogger(Archivo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }// Si el archivo no se encuentra, se lanzará una excepción FileNotFoundException, que se maneja en el bloque catch correspondiente.

    }// fin método mostrar_archivo

}//fin clase Archivo
