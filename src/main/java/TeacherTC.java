public class TeacherTC implements ProfesorInterface{
    private String nombre;
    private int tipo;
    private int salarioBaseMensual =2000;
    private int comision = 500;
    //private int bonus = 100;
    static final int ProfesorTP = 0;
    static final int ProfesorTC = 1;
    static final int Administrativo = 2;
    TeacherTC(int type, String nombre) {
        this.tipo = type;
        this.nombre = nombre;
    }
    public int Sueldo() {
        return salarioBaseMensual + comision;

    }
    public String Name(){
        return nombre;
    }

}