public class ProfesorPlanta extends Profesor{

    private String categoria;
    private Integer salario;

    public ProfesorPlanta(String nombre,
                          String correo,
                          String categoria,
                          Integer salario){
        super(nombre,correo);
        this.categoria = categoria;
        this.salario = salario;


    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    @Override
    public String imprimirSalario() {
        
        return "Nombre: " + this.getNombre() + " \n" +
                "Correo: " + super.getCorreo() + " \n" +
                "Profesor de planta en categoría " + categoria + " \n" +
                "Salario: $" + salario + " mensual " + " \n" ;
    }






}
