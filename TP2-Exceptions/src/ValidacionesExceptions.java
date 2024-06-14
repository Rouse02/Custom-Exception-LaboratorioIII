import java.util.ArrayList;

public class ValidacionesExceptions {

    public boolean validarRango(int numeroUsuario) throws InvalidRange {

        if(numeroUsuario > 0 && numeroUsuario <= 500) return true;
        else throw new InvalidRange("Rango inválido. Debe estar comprendido entre 1-500");
    }

    public boolean validarCadenaVacia(String cadena) throws InvalidEmptyString {

        if(!cadena.isEmpty()) return true;

        else throw new InvalidEmptyString("La cadena de texto no puede estar vacía");
    }

    public boolean validarCadena(String cadena) throws InvalidString {

        if(!cadena.matches(".*\\d+.*") && !(cadena.matches(".*[^a-zA-Z0-9 ].*"))) return true;

        else throw new InvalidString("La cadena no puede contener números ni simbolos");
    }

    public boolean validarSiExisteElAlumno(ArrayList<Alumno> alumnosBuffer, Alumno alumnoBuffer) throws NonExistentStudent {

        boolean existe = false;
        for(Alumno alumnosBuff : alumnosBuffer) if(alumnosBuffer.equals(alumnoBuffer)) existe =  true;

        if(!existe) throw new NonExistentStudent("Alumno inexistente");
        else {
            System.out.println("\nExiste el alumno");
            return existe;
        }
    }
}
