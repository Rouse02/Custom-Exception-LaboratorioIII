import java.lang.reflect.Array;
import java.util.*;

public class Colegio {

    //Atributos
    Map<String, ArrayList<Alumno>> mapaDelColegio;

    //Método constructor
    public Colegio() {
        mapaDelColegio = new HashMap<>();
    }

    //Otros métodos
    public Alumno pedirDatosAlumno(Scanner scanner) {

        ValidacionesExceptions validaciones = new ValidacionesExceptions();
        boolean verificacionCadena = false;
        String nacionalidadAlumno, nombreAlumno;
        Alumno nuevoAlumno = null;

        do {
            System.out.println("\nIngrese la nacionalidad del alumno: ");
            nacionalidadAlumno = scanner.nextLine();
            System.out.println("\nIngrese el nombre y apellido del alumno: ");
            nombreAlumno = scanner.nextLine();

            try{
                validaciones.validarCadenaVacia(nacionalidadAlumno);
                validaciones.validarCadena(nacionalidadAlumno);
                validaciones.validarCadenaVacia(nombreAlumno);
                validaciones.validarCadena(nombreAlumno);

                verificacionCadena = true;
                nuevoAlumno = new Alumno(nombreAlumno, nacionalidadAlumno);
            }
            catch(InvalidEmptyString exception) {
                System.out.println("\nError: " + exception.getMessage());
                verificacionCadena = false;
            }
            catch(InvalidString exception) {
                System.out.println("\nError: " + exception.getMessage());
                verificacionCadena = false;
            }
        }while(!verificacionCadena);

        return nuevoAlumno;
    }

    public void agregarAlumno(Alumno nuevoAlumno) {

        ArrayList<Alumno> arrayListBuffer = new ArrayList<>();

        if(mapaDelColegio.containsKey(nuevoAlumno.getNacionalidadAlumno())) arrayListBuffer = this.mapaDelColegio.get(nuevoAlumno.getNacionalidadAlumno());

        arrayListBuffer.add(nuevoAlumno);

        mapaDelColegio.put(nuevoAlumno.getNacionalidadAlumno(), arrayListBuffer);
    }

    public boolean eliminarAlumno(Alumno alumno) {

        ArrayList<Alumno> arrayListBuffer;

        if(this.mapaDelColegio.containsKey(alumno.getNacionalidadAlumno())) {

            arrayListBuffer = this.mapaDelColegio.get(alumno.getNacionalidadAlumno());
            Iterator<Alumno> iteratorArrayList = arrayListBuffer.iterator();

            while(iteratorArrayList.hasNext()) {
                Alumno alumnoBuffer = iteratorArrayList.next();

                if(alumnoBuffer.equals(alumno)) {
                    iteratorArrayList.remove();
                    mapaDelColegio.put(alumno.getNacionalidadAlumno(), arrayListBuffer);
                    return true;
                }
            }
        }
        return false;
    }

    public void verNacionalidad(String nacionalidad) {

        if(this.mapaDelColegio.containsKey(nacionalidad)) {

            ArrayList<Alumno> alumnosBuffer = this.mapaDelColegio.get(nacionalidad);
            System.out.println("\nNacionalidad: " + nacionalidad + " \nAlumnos: " + alumnosBuffer.size());
        }
        else System.out.println("\nNacionalidad inexistente");
    }

    public void verNacionalidadesColegio() {
        System.out.println("Nacionalidades: " + this.mapaDelColegio.keySet());
    }

    public void verTodos() {

        System.out.println("Estoy en el método verTodos");
        for(Map.Entry<String, ArrayList<Alumno>> entry : mapaDelColegio.entrySet()) System.out.println("\nNacionalidad: " + entry.getKey() + "\nAlumnos: " + entry.getValue().size());
    }

    public void gestionarColegio(Scanner scanner) {

        String salirMenu;
        int eleccionInciso;
        String nacionalidadAlumno, nombreAlumno;
        Alumno alumnoBuffer = new Alumno();

        do {
            System.out.println("\nBienvenido al sistema de gestion del Colegio");
            System.out.println("\n1) Agregar Alumno");
            System.out.println("\n2) Mostrar nacionalidad y el número de alumnos de esa nacionalidad");
            System.out.println("\n3) Muestra todas las nacionalidades diferentes que existen en el colegio");
            System.out.println("\n4) Borrar alumno");
            System.out.println("\n5) Muestra las distintas nacionalidades y el número de alumnos que existen por nacionalidad");

            System.out.println("\nIngrese el inciso a dirigirse:");
            eleccionInciso = scanner.nextInt();
            scanner.nextLine();

            switch (eleccionInciso) {

                case 1:
                    Alumno alumno = pedirDatosAlumno(scanner);
                    agregarAlumno(alumno);
                    break;

                case 2:
                    ValidacionesExceptions validaciones = new ValidacionesExceptions();
                    boolean verificacionNacionalidad = false;
                    String nacionalidad;

                    do {
                        System.out.println("\nIngrese la nacionalidad del alumno: ");
                        nacionalidad = scanner.nextLine();

                        try {
                            validaciones.validarCadenaVacia(nacionalidad);
                            validaciones.validarCadena(nacionalidad);
                            verificacionNacionalidad = true;
                        }
                        catch(InvalidEmptyString exception) {
                            System.out.println("\nError: " + exception.getMessage());
                            verificacionNacionalidad = false;
                        }
                        catch(InvalidString exception) {
                            System.out.println("\nError: " + exception.getMessage());
                            verificacionNacionalidad = false;
                        }
                    }while(!verificacionNacionalidad);

                    verNacionalidad(nacionalidad);
                    break;

                case 3:
                    verNacionalidadesColegio();
                break;

                case 4:
                    boolean isEliminado = eliminarAlumno(pedirDatosAlumno(scanner));

                    if(isEliminado) System.out.println("\nAlumno eliminado");
                    else System.out.println("\n Alumno no encontrado");
                    break;
                case 5:
                    verTodos();
                break;

                default:
                    System.out.println("\nOpción no válida. Vuelva a intentarlo");
                break;
            }
            System.out.println("\nPulse 's' para continuar o pulse 'n' para salir:");
            salirMenu = scanner.nextLine();

        }while(!(salirMenu.toLowerCase().equals("n")));
    }
}
