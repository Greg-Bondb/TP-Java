import java.util.Scanner;

/**
 * @author Grégory Balatre
 * @param input nombre fournit par l'utilisateur
 * affiche la racine carré de l'input
 */

class TP1_1 {
    public static void main() {
        int input = 1;
        while(input != 0) {
            try {
                System.out.println("Entrer une valeur positive (0 pour terminer) : ");
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input < 0) {
                    System.out.println("Erreur, la valeur ne peut pas être négative.");
                } else if (input > 0) {
                    System.out.println("La racine de " + input + " est " + Math.sqrt(input));
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu.");
            }
        }
        System.out.println("Fin du programme.");
    }
}