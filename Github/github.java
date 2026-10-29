import java.util.Random;
import java.util.Scanner;

public class github {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("        BIENVENIDO AL JUEGO");
        System.out.println("    Adivina el número secreto");
        System.out.println("====================================");

        boolean seguirJugando = true;

        while (seguirJugando) {
            jugarPartida();
            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            String respuesta = SCANNER.nextLine().trim().toLowerCase();

            if (!respuesta.equals("s") && !respuesta.equals("si") && !respuesta.equals("sí") && !respuesta.equals("y")) {
                seguirJugando = false;
            }
        }

        System.out.println("\nGracias por jugar. ¡Hasta luego!");
        SCANNER.close();
    }

    private static void jugarPartida() {
        int numeroSecreto = 1 + RANDOM.nextInt(100);
        int intentoMaximo = 8;
        int intentos = 0;

        System.out.println("\nHe pensado un número entre 1 y 100.");
        System.out.println("Tienes " + intentoMaximo + " intentos para adivinarlo.\n");

        while (intentos < intentoMaximo) {
            System.out.print("Ingresa tu número: ");
            String entrada = SCANNER.nextLine();

            try {
                int numeroUsuario = Integer.parseInt(entrada);
                intentos++;

                if (numeroUsuario < 1 || numeroUsuario > 100) {
                    System.out.println("El número debe estar entre 1 y 100.");
                    continue;
                }

                if (numeroUsuario == numeroSecreto) {
                    System.out.println("\n¡Felicidades! Adivinaste el número secreto: " + numeroSecreto);
                    System.out.println("Lo lograste en " + intentos + " intento(s).\n");
                    return;
                } else if (numeroUsuario < numeroSecreto) {
                    System.out.println("Muy bajo. Intenta con un número mayor.");
                } else {
                    System.out.println("Muy alto. Intenta con un número menor.");
                }

                int intentosRestantes = intentoMaximo - intentos;
                System.out.println("Intentos restantes: " + intentosRestantes);

                if (intentos == intentoMaximo) {
                    System.out.println("\n¡Se acabaron los intentos! El número secreto era: " + numeroSecreto);
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número válido.");
            }
        }
    }
}
