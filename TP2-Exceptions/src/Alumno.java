import java.util.Objects;

public class Alumno {

    //Atributos
    private String nombreApellidoAlumno;
    private String nacionalidadAlumno;

    //Métodos constructores
    public Alumno(String nombreApellidoAlumno, String nacionalidadAlumno) {
        this.nombreApellidoAlumno = nombreApellidoAlumno;
        this.nacionalidadAlumno = nacionalidadAlumno;
    }

    public Alumno() {
        this.nombreApellidoAlumno = "";
        this.nacionalidadAlumno = "";
    }

    //Métodos getter y setter
    public String getNombreApellidoAlumno() { return nombreApellidoAlumno; }
    public void setNombreApellidoAlumno(String nombreApellidoAlumno) { this.nombreApellidoAlumno = nombreApellidoAlumno; }

    public String getNacionalidadAlumno() { return nacionalidadAlumno; }
    public void setNacionalidadAlumno(String nacionalidadAlumno) { this.nacionalidadAlumno = nacionalidadAlumno; }

    //Otros métodos
    @Override
    public String toString() {
        return "Alumno" + "\n" +
                "Nombre y Apellido: " + nombreApellidoAlumno + "\n" +
                "Nacionalidad: " + nacionalidadAlumno +  "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Alumno alumno = (Alumno) object;
        return Objects.equals(nombreApellidoAlumno, alumno.nombreApellidoAlumno) && Objects.equals(nacionalidadAlumno, alumno.nacionalidadAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreApellidoAlumno, nacionalidadAlumno);
    }
}
