import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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

        List<String> reporteSalarios = nominaIngenieria.imprimirNomina();

        reporteSalarios.forEach( r -> System.out.println(r));

        nominaIngenieria.getProfesores().forEach(p -> System.out.println(p.getCorreo()));

        nominaIngenieria.eliminarProfesor("pepito@javeriana.edu.co");

        nominaIngenieria.getProfesores().forEach(p -> System.out.println(p.getCorreo()));

    }


}