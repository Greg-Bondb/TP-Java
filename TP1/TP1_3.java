import java.util.Objects;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * @param input nombre fournit par l'utilisateur
 * - Transformer un nombre binaire vers son équivalent décimale
 * – Transformer un nombre décimal en binaire
 */

class TP1_3 {
    public static void main() {
        int input = 1;
        boolean rep = false;
        Scanner sc;
        while(true) {
            try {
                if (!rep) {
                    Menu();
                    sc = new Scanner(System.in);
                    input = sc.nextInt();
                }
                if (input == 0) {
                    break;
                } else if (input == 1) {
                    System.out.println("Choississez un nombre (decimal->binaire) :");
                    sc = new Scanner(System.in);
                    int nb = sc.nextInt();
                    System.out.println("Conversion en decimal : " + Integer.toBinaryString(nb));
                    rep = Retry();
                } else if (input == 2) {
                    System.out.println("Choississez un nombre (binaire->decimal) :");
                    sc = new Scanner(System.in);
                    String nb = sc.nextLine();
                    System.out.println("Conversion en decimal : " + Integer.parseInt(nb, 2));
                    rep = Retry();
                } else {
                    System.out.println("Je n'ai pas compris.\n");
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu. \n");
            }
        }
        System.out.println("Merci, a bientot");
    }

    public static void Menu() {
        System.out.println("\nVoulez-vous convertir :");
        System.out.println("    0- quitter le programme");
        System.out.println("    1- un nombre décimal en binaire");
        System.out.println("    2- un nombre binaire en décimal");
    }

    public static boolean Retry() {
        System.out.println("\n" + "Voulez-vous recommencer [oO] ? ");
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        if (Objects.equals(rep, "o") || Objects.equals(rep, "O")) {
            return true;
        } else {
            return false;
        }
    }
}