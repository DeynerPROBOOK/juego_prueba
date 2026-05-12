package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa la gestión de archivos para el juego.
 * Se usa para leer datos de texto como rasgos de personalidad y artefactos.
 */
public class Archivo {

    /** Ruta o nombre del archivo a procesar. */
    String nombre;

    // Constructor vacío para crear un objeto Archivo sin inicializar sus atributos.
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

    /**
     * Lee el archivo de rasgos de personalidad y devuelve su contenido como String.
     * CAMBIO: Antes retornaba void e imprimía en consola.
     *         Ahora retorna String para mostrar en JOptionPane.
     */
    public String mostrar_archivo() {
        // Ruta del archivo de rasgos de personalidad
        // Este archivo contiene 40 rasgos separados por líneas
        this.setNombre("C:\\Users\\Deyner\\OneDrive - Universidad de Manizales\\Escritorio\\rasgos_personalidad.txt");
        
        // Se crea un objeto File para acceder al archivo en la ruta especificada
        File arch = new File(this.getNombre());
        
        // StringBuilder es eficiente para concatenar múltiples cadenas en un bucle
        // Almacena todo el contenido del archivo
        StringBuilder contenido = new StringBuilder();

        // try-with-resources: cierra automáticamente FileReader y BufferedReader al terminar
        // FileReader: abre el archivo para lectura
        // BufferedReader: lee línea por línea de forma eficiente
        try (FileReader lectura = new FileReader(arch);
             BufferedReader b_leer = new BufferedReader(lectura)) {
            
            // Se lee la primera línea del archivo
            String linea = b_leer.readLine();
            
            // Bucle que continúa mientras haya líneas que leer (linea != null)
            while (linea != null) {
                // Se agrega la línea leída al StringBuilder seguida de un salto de línea
                contenido.append(linea).append("\n");
                // Se lee la siguiente línea
                linea = b_leer.readLine();
            }
        } 
        // Si el archivo no existe, se captura la excepción FileNotFoundException
        catch (FileNotFoundException ex) {
            // Se registra el error en el log del sistema
            System.getLogger(Archivo.class.getName()).log(System.Logger.Level.ERROR, "Archivo no encontrado", ex);
            // Se retorna un mensaje de error
            return "Error: Archivo no encontrado.";
        } 
        // Si hay problemas en la lectura, se captura IOException
        catch (IOException ex) {
            // Se registra el error en el log del sistema
            System.getLogger(Archivo.class.getName()).log(System.Logger.Level.ERROR, "Error de E/S", ex);
            // Se retorna un mensaje de error
            return "Error: Problema de lectura.";
        }
        // Se retorna el contenido completo como String
        return contenido.toString();
    }// fin método mostrar_archivo

    /**
     * Procesa una línea del archivo de artefactos y devuelve información formateada.
     * CAMBIO: Antes retornaba void y no hacía nada.
     *         Ahora retorna String con la información del artefacto formateada.
     */
    public String crear_artefacto(String linea) {
        // Declara arrays para almacenar las partes separadas de la línea
        String[] partes_art;        // Las 4 partes principales del artefacto separadas por ";"
        String[] caracteristicas;   // Las características separadas por "#"
        String[] partes_carac;      // Cada característica dividida por "/"
        String[] opciones_carac;    // Las opciones de cada característica separadas por ":"
        
        // StringBuilder para construir la información formateada del artefacto
        StringBuilder info = new StringBuilder();

        // Se divide la línea por el delimitador ";"
        // Formato: ID;Nombre;Descripción;Características(separadas por #)
        partes_art = linea.split(";");
        
        // Se agrega el ID/nombre del artefacto a la información formateada
        info.append("Artefacto: ").append(partes_art[0]).append("\n");
        
        // Se valida si existe la segunda parte (Nombre del artefacto)
        // Se verifica que el array tenga al menos 2 elementos antes de acceder a partes_art[1]
        if (partes_art.length > 1) 
            info.append("Nombre: ").append(partes_art[1]).append("\n");
        
        // Se valida si existe la tercera parte (Descripción)
        // Se verifica que el array tenga al menos 3 elementos
        if (partes_art.length > 2) 
            info.append("Descripción: ").append(partes_art[2]).append("\n");
        
        // Se valida si existe la cuarta parte (Características)
        // Se verifica que el array tenga al menos 4 elementos
        if (partes_art.length > 3) {
            // Se divide las características por el delimitador "#"
            // Cada característica es una entidad separada
            caracteristicas = partes_art[3].split("#");
            
            // Bucle para recorrer cada característica del artefacto
            for (int i = 0; i < caracteristicas.length; i++) {
                // Se divide cada característica por el delimitador "/"
                // Formato de cada característica: Nombre/Tipo/Opciones
                partes_carac = caracteristicas[i].split("/");
                
                // Se valida si la característica tiene al menos el nombre (primera parte)
                if (partes_carac.length > 0) {
                    // Se agrega el nombre de la característica con indentación (dos espacios)
                    // i+1 es para mostrar la característica numerada comenzando desde 1
                    info.append("  Característica ").append(i+1).append(": ").append(partes_carac[0]).append("\n");
                }
                
                // Se valida si la característica tiene opciones (tercera parte, índice 2)
                if (partes_carac.length > 2) {
                    // Se divide las opciones por el delimitador ":"
                    // Cada opción es un valor separado
                    opciones_carac = partes_carac[2].split(":");
                    
                    // Se agrega las opciones con indentación (cuatro espacios)
                    // String.join() une todos los elementos del array con ", " como separador
                    info.append("    Opciones: ").append(String.join(", ", opciones_carac)).append("\n");
                }
            }
        }
        // Se agrega un salto de línea para separar visualmente cada artefacto
        info.append("\n");
        
        // Se retorna la información formateada como String
        return info.toString();
    }

    /**
     * Lee el archivo de artefactos y devuelve información procesada de cada línea.
     * CAMBIO: Antes retornaba void y llamaba a crear_artefacto() sin retorno.
     *         Ahora retorna String con todos los artefactos procesados.
     */
    public String mostrar_artefacto() {
        // Ruta del archivo de artefactos
        // Este archivo contiene información de artefactos con características opcionales
        this.setNombre("C:\\Users\\Deyner\\OneDrive - Universidad de Manizales\\Escritorio\\artefactos_2.txt");
        
        // Se crea un objeto File para acceder al archivo en la ruta especificada
        File arch = new File(this.getNombre());
        
        // StringBuilder para almacenar el contenido formateado de todos los artefactos
        StringBuilder contenido = new StringBuilder();

        // try-with-resources: cierra automáticamente FileReader y BufferedReader al terminar
        try (FileReader lectura = new FileReader(arch);
             BufferedReader b_leer = new BufferedReader(lectura)) {
            
            // Se lee la primera línea del archivo
            String linea = b_leer.readLine();
            
            // Bucle que continúa mientras haya líneas que leer
            while (linea != null) {
                // Se llama a crear_artefacto() para procesar la línea y obtener información formateada
                // El resultado se agrega al StringBuilder
                contenido.append(crear_artefacto(linea));
                
                // Se lee la siguiente línea
                linea = b_leer.readLine();
            }// fin del bucle de lectura del archivo
        } 
        // Si el archivo no existe, se captura FileNotFoundException
        catch (FileNotFoundException ex) {
            // Se registra el error
            System.getLogger(Archivo.class.getName()).log(System.Logger.Level.ERROR, "Archivo no encontrado", ex);
            // Se retorna un mensaje de error
            return "Error: Archivo de artefactos no encontrado.";
        } 
        // Si hay problemas en la lectura, se captura IOException
        catch (IOException ex) {
            // Se registra el error
            System.getLogger(Archivo.class.getName()).log(System.Logger.Level.ERROR, "Error de E/S", ex);
            // Se retorna un mensaje de error
            return "Error: Problema de lectura de artefactos.";
        }
        // Se retorna todo el contenido procesado como String
        return contenido.toString();
    }// fin método mostrar_artefacto


}//fin clase Archivo
