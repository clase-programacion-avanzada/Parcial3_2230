import java.util.ArrayList;
import java.util.List;

public class Nomina {

    List<Profesor> profesores;

    public Nomina() {
        this.profesores = new ArrayList<>();
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

}
