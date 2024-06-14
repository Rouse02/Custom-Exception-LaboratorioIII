import java.util.Scanner;

public class Menu {

    public Menu() {}

    public void gestionarMenu(Scanner scanner) {

        String eleccion;
        int eleccionInciso;

        do {
            System.out.println("\n1) Ejercicio1");
            System.out.println("2) Ejercicio2");
            System.out.println("3) Ejercicio3");
            System.out.println("4) Ejercicio4");

            System.out.println("\nIngrese el inciso a dirigirse: ");
            eleccionInciso = scanner.nextInt();
            scanner.nextLine();

            switch(eleccionInciso) {

                case 1:
                    System.out.println("\nRta: El orden de los catch está invertido. Los catch deben manejar las exception en orden de la más específica a la más general");
                break;

                case 2:
                    System.out.println("\nRta: El bloque finally se ejecutará siempre suceda o no la exception. Por ende, retorna siempre 3");
                break;

                case 3:
                    EjercicioPractico1 ejercicio1 = new EjercicioPractico1();
                    ejercicio1.adivinarNumero(scanner);
                break;

                case 4:
                    Colegio colegio = new Colegio();
                    colegio.gestionarColegio(scanner);
                break;

                default:
                    System.out.println("\nInciso inválido. Vuelva a intentarlo");
                break;
            }

            System.out.println("\nPulse 's' para continuar o pulse 'n' para salir del menú: ");
            eleccion = scanner.nextLine();

        }while(!(eleccion.toLowerCase().equals("n")));
    }
}
