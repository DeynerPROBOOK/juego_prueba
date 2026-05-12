
import java.util.ArrayList;
import model.Archivo;
import model.rasgoPersonalidad;





public class Main {

    public static ArrayList<rasgoPersonalidad> rasgos;

    public static void main(String[] args) {
     

    rasgos = new ArrayList<>();

        Archivo obj_archivo = new Archivo();
        obj_archivo.mostrar_archivo();
        // mostrar el arreglo
        System.out.println(rasgos);


    }// fin método main
}// fin clase Main