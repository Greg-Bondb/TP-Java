package Exercices;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * - La fonction Factoriel qui calcul la factorielle d'un nombre
 * - La fonction Cnp qui calcul n! /( (n-p)! * p! )
 */

public class TP2_4 {

    public static Scanner sc = new Scanner(System.in);
    public static void main() {
        int n = 1;
        while(n != 0) {
            try {
                Menu();
                Scanner sc = new Scanner(System.in);
                n = sc.nextInt();
                switch (n) {
                    case 0 : System.out.println("Fin du programme");break;
                    case 1: System.out.println("Demarrage de l'exercice Factoriel");Facto();
                    case 2: System.out.println("Demarrage de l'exercice Cnp");Cnp();
                }
            } catch (Exception e) {
                System.out.printf("Une erreur est survenue : %s\n", e.getStackTrace());
            }
        }
    }

    public static void Facto() {
        System.out.println("Rentrez un nombre n positif : ");
        int input = sc.nextInt();
        int result = 1;
        for (int i = 1; i <= input; i++) {
            result = result * i;
        }
        System.out.println(result);
    }

    public static double Factoriel(int input) {
        double result = 1;
        for (int i = 1; i <= input; i++) {
            result = result * i;
        }
        return result;
    }

    public static void Cnp() {
        System.out.println("Rentrez un nombre n positif : ");
        int n = sc.nextInt();
        System.out.println("Rentrez un nombre p positif : ");
        int p = sc.nextInt();
        double result = Factoriel(n) /( Factoriel(n-p) * Factoriel(p) );
        System.out.println(result);
        double res1 = Factoriel(50) /( Factoriel(50-5) * Factoriel(5) );
        double res2 = Factoriel(11) /( Factoriel(11-2) * Factoriel(2) );
        System.out.println("Cnp(50,5) * Cnp(11,2) = " + res1 * res2);
    }

    public static void Menu() {
        System.out.println("\nVoulez-vous convertir :");
        System.out.println("    0- quitter le programme");
        System.out.println("    1- Factorielle d'un nombre");
        System.out.println("    2- Cnp");
    }

}