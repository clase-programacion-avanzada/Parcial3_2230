import java.io.Serializable;
import java.util.Random;

public abstract class Profesor implements Serializable {
    private static final Random RANDOM = new Random();

    private static final int MAXIMO_ALEATORIO = 100;
    private String nombre;
    private String correo;
    private int numeroDeEjemploParaOrdenarPorNumero;

    public Profesor(String nombre, String correo){
        this.nombre=nombre;
        this.correo=correo;
        this.numeroDeEjemploParaOrdenarPorNumero = RANDOM.nextInt(MAXIMO_ALEATORIO);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public abstract String imprimirSalario();


    public int getNumeroDeEjemploParaOrdenarPorNumero() {
        return numeroDeEjemploParaOrdenarPorNumero;
    }

    public void setNumeroDeEjemploParaOrdenarPorNumero(int numeroDeEjemploParaOrdenarPorNumero) {
        this.numeroDeEjemploParaOrdenarPorNumero = numeroDeEjemploParaOrdenarPorNumero;
    }
}
