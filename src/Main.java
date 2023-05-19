import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        try {
            escribirProfesoresDesdeMainABinario();
            System.out.println("Archivo de profesores creado con exito!");
        } catch (IOException e) {
            System.out.println("Error creando el archivo " + e.getMessage());
        }

        boolean leerArchivo = true;


        Nomina nominaIngenieria = leerNominaDesdeArchivo();

        if (nominaIngenieria == null) {
            System.out.println("Error al cargar la nomina");
            return;
        }

        List<String> reporteSalarios = nominaIngenieria.imprimirNomina();

        reporteSalarios.forEach( r -> System.out.println(r));

        try {
            nominaIngenieria.exportarProfesores("profesoresExportados.txt");
        } catch (IOException e) {
            System.out.println("Error al exportar archivo " + e.getMessage() );
        }
        System.out.println("Ordenando Profesores por nombre");
        nominaIngenieria.ordenarProfesoresPorNombre();

        nominaIngenieria.getProfesores().forEach(
                p -> System.out.println(p.getNombre())
        );

        System.out.println("Ordenando Profesores por numero");
        nominaIngenieria.ordenarProfesoresPorNumeroDeEjemplo();

        nominaIngenieria.getProfesores().forEach(
                p -> System.out.println(p.getNombre() + " " + p.getNumeroDeEjemploParaOrdenarPorNumero())
        );

        System.out.println("Profesores antes de eliminar por correo");
        nominaIngenieria.getProfesores().forEach(p -> System.out.println(p.getCorreo()));

        nominaIngenieria.eliminarProfesor("pepito@javeriana.edu.co");

        System.out.println("Profesores después de eliminar por correo");
        nominaIngenieria.getProfesores().forEach(p -> System.out.println(p.getCorreo()));

    }

    private static Nomina leerNominaDesdeArchivo() {
        try {
            /*Aunque el constructor de Nomina recibe un booleano, lo he hecho así para poder escribir primero el
            * archivo. Esto está dentro de un try catch porque la lectura del archivo podría fallar*/
            Nomina nominaIngenieria = new Nomina(true);
            return nominaIngenieria;
        } catch (FileNotFoundException | RuntimeException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Error leyendo el archivo debido a que no se ha encontrado : " + e.getCause());
            }

            if (e instanceof RuntimeException) {
                System.out.println("Error leyendo el archivo debido a datos corruptos: " + e.getCause());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    private static void escribirProfesoresDesdeMainABinario() throws IOException {

        Nomina nominaIngenieria = new Nomina();
        String nombrePlanta1 ="Juanito";
        String correoPlanta1 ="juanito@javeriana.edu.co";
        String categoriaPlanta1 = "Asistente";
        Integer salario1 = 8000000;

        nominaIngenieria.agregarProfesorPlanta(nombrePlanta1, correoPlanta1, categoriaPlanta1, salario1);

        String nombrePlanta2 ="Juanita";
        String correoPlanta2 ="juanita@javeriana.edu.co";
        String categoriaPlanta2 = "Titular";
        Integer salario2 = 8500000;

        nominaIngenieria.agregarProfesorPlanta(nombrePlanta2, correoPlanta2, categoriaPlanta2, salario2);

        String nombreCatedra1 = "Pepito";
        String correoCatedra1 = "pepito@javeriana.edu.co";
        Integer tarifaCatedra1 = 50000;
        Integer horasDictadas1 = 8;

        nominaIngenieria.agregarProfesorCatedra(nombreCatedra1, correoCatedra1, tarifaCatedra1, horasDictadas1);

        String nombreCatedra2 = "Anita";
        String correoCatedra2 = "anita@javeriana.edu.co";
        Integer tarifaCatedra2 = 75000;
        Integer horasDictadas2 = 8;

        nominaIngenieria.agregarProfesorCatedra(nombreCatedra2, correoCatedra2, tarifaCatedra2, horasDictadas2);

        nominaIngenieria.exportarProfesoresABinario(nominaIngenieria);

    }


}