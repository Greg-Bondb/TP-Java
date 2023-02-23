import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * @param input nombre fournit par l'utilisateur
 * calcul la somme des n premiers termes de la suite Un = Un-1 + 1 / n avec n > 0 et U1 = 1
 */

class TP1_4 {
    public static void main() {
        int input = 1;
        while(true) {
            try {
                System.out.print("Entrez le nombre de terme de la suite à calculer n avec n > 0 (0 pour terminer) : ");
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input < 0) {
                    System.out.println("Erreur, la valeur ne peut pas etre negative. \n");
                } else if (input > 0) {
                    Function(input);
                } else {
                    System.out.println("Fin du programme.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu. \n");
            }
        }
    }
    public static void Function(float input) {
        DecimalFormat df = new DecimalFormat("0.0000");
        float U = 1;
        for (float i = 1; i < input; i++) {
            U = U + (1/(i+1));
        }
        System.out.println("U" + Math.round(input) + " est = " + df.format(U));
    }
}