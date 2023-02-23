package Exercices;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * - Calcul mes impots en fonction de ma situation sociale
 */

public class TP2_3 {

    public static void main() {
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Etes vous marié ? [o/O] ? ");
                String input = sc.nextLine();
                double nb = 1;
                if (Objects.equals(input, "o") || Objects.equals(input, "O")) {
                    nb = 2;
                }
                System.out.println("Combien d'enfants avez vous ? ");
                int input2 = sc.nextInt();
                if (nb == 1 && input2 > 0) {
                    nb += 0.5;
                }
                if (input2 <= 2) {
                    nb += input2 * 0.5;
                } else if (input2 > 2) {
                    nb += (input2-1);
                }
                System.out.println("Entrez votre nombre total de revenu net imposable :");
                double revenu = sc.nextInt();
                if (nb <= 0) {
                    System.out.println("Un problème est survenu.\n");
                } else {
                    MesImpots(nb, revenu);
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu.");
            }
        }
    }

    public static void MesImpots(double nb , double revenu) {
        double result = 0;
        revenu = revenu / nb;
        if (revenu > 160336) {
            result = 1742.95 + 14542.5 + 35174.31 + (revenu - 160336) * 0.45;
        } else if (revenu > 74546) {
            result = 1742.95 + 14542.5 + (revenu - 74545) * 0.41;
        } else if (revenu > 26071) {
            result = 1742.95 + (revenu - 26070) * 0.30;
        } else if (revenu > 10225) {
            result = (revenu - 10225) * 0.11;
        }
        System.out.println(result);
    }
}
