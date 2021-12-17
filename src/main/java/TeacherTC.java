public class TeacherTC implements ProfesorInterface{
    private String nombre;
    private int tipo;
    private int salarioBaseMensual =2000;
    private int comision = 500;
    TeacherTC(int type, String nombre) {
        this.tipo = type;
        this.nombre = nombre;
    }
    public int sueldo() {
        return salarioBaseMensual + comision;

    }
    public String name(){
        return nombre;
    }

}