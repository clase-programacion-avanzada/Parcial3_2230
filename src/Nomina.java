import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nomina {
    private static final String RUTA_PERSISTENCIA = "profesores.dat";
    List<Profesor> profesores;

    public  Nomina() {
        this.profesores = new ArrayList<>();
    }
    public Nomina(boolean cargarDatosDesdeArchivo) throws IOException, ClassNotFoundException {
        //El constructor carga siempre en la lista los profesores que están en el archivo
        this.profesores = new ArrayList<>();
        if(cargarDatosDesdeArchivo) {
            FileHandler.cargarProfesores(RUTA_PERSISTENCIA,this.profesores);
        }
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void agregarProfesorPlanta(String nombre, String correo, String categoria, Integer salario){

        ProfesorPlanta nuevoProfesorPlanta = new ProfesorPlanta(nombre,correo, categoria, salario);
        this.profesores.add(nuevoProfesorPlanta);
    }

    public void agregarProfesorCatedra (String nombre, String correo, Integer tarifa, Integer horasDictadas){

        Profesor nuevoProfesorCatedra = new ProfesorCatedra(nombre,correo,tarifa,horasDictadas);
        this.profesores.add(nuevoProfesorCatedra);
    }

    public boolean eliminarProfesor (String correo){

        for (int i=0; i<this.profesores.size(); i++){
            Profesor p = this.profesores.get(i);
            if (p.getCorreo().equals(correo)){
                this.profesores.remove(i);
                return true;
            }

        }
        return false;
    }

    public List<String> imprimirNomina() {
        List<String> nomina = new ArrayList<>();

        for (Profesor p: this.profesores){
            nomina.add(p.imprimirSalario());
        }

        return nomina;


    }

    public static void exportarProfesoresABinario(Nomina nomina) throws IOException {

        FileHandler.escribirListaDeProfesoresArchivoBinario(RUTA_PERSISTENCIA,nomina.getProfesores());

    }

    public void exportarProfesores(String rutaArchivo) throws IOException {
        FileHandler.exportarProfesores(rutaArchivo, this.imprimirNomina());

    }

    public void ordenarProfesoresPorNombre() {

        //One way
        Collections.sort(this.profesores,
                (p1, p2) ->  p1.getNombre().compareTo(p2.getNombre()));
        //Otra forma
        Collections.sort(this.profesores, Comparator.comparing(Profesor::getNombre));

    }

    public int compare (Profesor p1, Profesor p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }

    public void ordenarProfesoresPorNumeroDeEjemplo() {

        //One way
        Collections.sort(this.profesores,
                (p1, p2 ) ->  p1.getNumeroDeEjemploParaOrdenarPorNumero() - p2.getNumeroDeEjemploParaOrdenarPorNumero());
        //Otra forma
        Collections.sort(this.profesores, Comparator.comparingInt(Profesor::getNumeroDeEjemploParaOrdenarPorNumero));


    }
}
