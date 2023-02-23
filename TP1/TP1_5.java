import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Grégory Balatre
 * @param input nombre fournit par l'utilisateur
 * calcul la somme des éléments d’un tableau de flottants
 */

class TP1_5 {

    public static void main() {
            int input = 1;
            while(true) {
                try {
                    System.out.println("Entrez la taille du tableau (0 pour terminer) : ");
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    if (input == 0) {
                        break;
                    } else if (input < 0) {
                        System.out.println("Erreur, la valeur ne peut pas etre negative.");
                    } else {
                        Tab(input);
                    }
                } catch (Exception e) {
                    System.out.println("Un problème est survenu. \n");
                }
            }
            System.out.println("Fin du programme.");
    }
    public static void Tab(int input) {
        float[] tab = new float[input];
        float sum = 0;
        for (int i = 0; i < input; i++) {
            System.out.println("Entre valeur " + (i+1) + " :");
            Scanner sc = new Scanner(System.in);
            tab[i] = sc.nextInt();
        }
            for( float j : tab) {
                sum += j;
            }
            System.out.println("La somme du tableau est de " + sum + "\n");
        }
}