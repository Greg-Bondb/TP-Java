import java.util.Scanner;

/**
 * @author Grégory Balatre
 * @param BLUE GREEN BLACK importation de couleur
 * affiche un arbre de hauteur input
 */

class TP1_2 {
    public static void main() {

        final String ANSI_RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";
        final String GREEN = "\u001B[32m";
        final String BLACK = "\u001B[30m";

        int input = 1;
        while(input != 0) {
            try {
                System.out.println("\n" + "Hauteur de l'arbre (0 pour quitter) :");
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                int equal = input + 2;
                int star = 1;
                if (input <= 0) {
                    System.out.println("\n" + "Entrez une hauteur valide >= 1 :");
                } else {
                    for (int i = 0; i < input; i++) {
                        System.out.println(BLUE + "=".repeat(equal) + GREEN + "*".repeat(star) + BLUE + "=".repeat(equal));
                        equal = equal - 1;
                        star = star + 2;
                    }
                    System.out.println("=".repeat(input + 2) + BLACK + "*" + BLUE + "=".repeat(input + 2));
                    System.out.println("=".repeat(input + 1) + BLACK + "*".repeat(3) + BLUE + "=".repeat(input + 1) + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu.");
            }
        }
    }
}