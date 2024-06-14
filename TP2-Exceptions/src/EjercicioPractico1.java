import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class EjercicioPractico1 {

    public EjercicioPractico1() {}

    public void adivinarNumero(Scanner scanner) {

        Random random = new Random();
        ValidacionesExceptions validaciones = new ValidacionesExceptions();
        String seguirJugando = "s";
        int numeroRandom = random.nextInt(500) + 1;
        int intentosUsuario = 0;
        int numeroDebug = 29;

        System.out.println("\nBienvenido al juego 'Adivina el Número'");
        do {
            int numeroUsuario = 0;
            boolean entradaValida = false;

            while(!entradaValida) {
                try {
                    System.out.println("\nIngrese un número entre 1 y 500:");
                    numeroUsuario = scanner.nextInt();
                    scanner.nextLine();
                    validaciones.validarRango(numeroUsuario);
                    entradaValida = true;
                }
                catch (InputMismatchException | InvalidRange exception) {
                    System.out.println("\nError: Debe ingresar un número entero válido entre 1 y 500.");
                    scanner.nextLine();
                }
            }

            intentosUsuario++;

            if (numeroUsuario == numeroDebug) {
                System.out.println("\n¡Felicidades! ¡Has adivinado el número " + numeroDebug + " en " + intentosUsuario + " intentos!");
                return;
            }
            else if (numeroUsuario < numeroRandom) System.out.println("\nEl número es mayor que " + numeroUsuario);

            else System.out.println("\nEl número es menor que " + numeroUsuario);

            System.out.println("\nPulse 's' para seguir jugando o pulse 'n' para salir:");
            seguirJugando = scanner.nextLine();

        } while (!seguirJugando.toLowerCase().equals("n"));
    }

}
