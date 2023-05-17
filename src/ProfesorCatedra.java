public class ProfesorCatedra extends Profesor{

    Integer tarifa;
    Integer horas;

    public ProfesorCatedra(String nombre, String correo, Integer tarifa, Integer horas){

        super(nombre,correo);
        this.tarifa = tarifa;
        this.horas = horas;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }


    @Override
    public String imprimirSalario() {
        return "Nombre: " + super.getNombre() + " \n" +
                "Correo: " + super.getCorreo() + " \n" +
                "Profesor de catedra con tarifa de $ " + tarifa + "por hora" + " \n" +
                "Dicta " +  horas + " al mes " + " \n" ;
    }


}
