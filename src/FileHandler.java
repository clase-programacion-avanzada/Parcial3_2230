import java.io.*;
import java.util.*;

public class FileHandler {



    public static void escribirListaDeProfesoresArchivoBinario(String nombreArchivo,List<Profesor> profesores)
            throws IOException {
        File file = new File(nombreArchivo);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for(Profesor profesor : profesores) {
                oos.writeObject(profesor);
            }
        }

    }

    public static void cargarProfesores(String rutaPersistencia,
                                        List<Profesor> profesores) throws RuntimeException,
            IOException, ClassNotFoundException {
        File file = new File(rutaPersistencia);
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while(true) {
                Profesor profesor = (Profesor) ois.readObject();
                profesores.add(profesor);

            }
        }catch (EOFException e) {

        }
    }

    public static void exportarProfesores(String rutaArchivo,
                                          List<String> listaAExportar)
            throws IOException {

        FileWriter myWriter = new FileWriter(rutaArchivo);
        myWriter.write("========== Profesores en nomina ==========");
            for (String s : listaAExportar) {
                myWriter.write("--------------------------------");
                myWriter.write(s);
            }
            myWriter.close();

    }
}
