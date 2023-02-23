package Exercices;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * - La fonction Nim simule le jeu de Nim(le perdant est celui qui retire la derniere allumette)
 * - La fonction NimInverse simule le jeu de Nim inversé (le gagant est celui qui retire la derniere allumette)
 */

public class TP2_5 {

    static int nb = 0;
    static int rand;
    public static void main() {
        while(true) {
            try {
                System.out.println("\nEntrez votre nom : ");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                Menu(name);
                int input = sc.nextInt();
                switch (input) {
                    case 0 -> {
                        System.out.println("\nFin du programme.");
                        System.exit(0);
                    }
                    case 1 -> Nim(name);
                    case 2 -> NimInverse(name);
                    default -> System.out.println("\nJe n'ai pas compris votre demande :(");
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu. \n");
            }
        }
    }
    public static void Nim(String name) {
        Start(name);
        int alu = 1;
        Scanner sc = new Scanner(System.in);
        Random n = new Random();
        while(nb != 0) {
            if (rand == 0) {    //ordinateur
                if (nb % 4 == 0) {
                    alu = 3;
                } else if (nb % 4 != 1){
                    alu = nb % 4 - 1;
                } else {
                    alu = n.nextInt(Math.min(3,nb)) + 1;
                }
                System.out.println("Ordinateur enlève : " + alu);
                nb -= alu;
                rand++;
            } else {    //joueur
                try {
                    System.out.print(name + " enlève : ");
                    alu = sc.nextInt();
                    if (alu > nb) {
                        System.out.println("Vous enlevez trop d'allumettes !");
                    } else if (alu > 0 && alu < 4) {
                        nb -= alu;
                        rand--;
                    } else {
                        System.out.println("Choisissez seulement 1, 2 ou 3 !");
                    }
                } catch (Exception e) {
                    System.out.println("Une erreur est survenue : seulement 1, 2 ou 3 sont acceptés");
                }
            }
            System.out.println("il reste " + nb +" : " + "|".repeat(nb));
        }
        if (rand == 0) {
            System.out.println("\nL'ordinateur à gagné :)");
            System.out.println(name + " à perdu :(");
        }else {
            System.out.println("\n" + name + " à gagné :)");
            System.out.println("L'ordinateur à perdu :(");
        }
    }

    public static void NimInverse(String name) {
        Start(name);
        int alu;
        Scanner sc = new Scanner(System.in);
        Random n = new Random();
        while(nb != 0) {
            if (rand == 0) {    //ordinateur
                if (nb % 4 == 3) {
                    alu = 3;
                } else if (nb % 4 != 0) {
                    alu = nb % 4;
                } else {
                    alu = n.nextInt(Math.min(3,nb)) + 1;
                }
                System.out.println("Ordinateur enlève : " + alu);
                nb -= alu;
                rand++;
            } else {    //joueur
                try {
                    System.out.print(name + " enlève : ");
                    alu = sc.nextInt();
                    if (alu > nb) {
                        System.out.println("Vous enlevez trop d'allumettes !");
                    } else if (alu > 0 && alu < 4) {
                        nb -= alu;
                        rand--;
                    }  else {
                        System.out.println("Choisissez seulement 1, 2 ou 3 !");
                    }
                } catch (Exception e) {
                    System.out.println("Une erreur est survenue : seulement 1, 2 ou 3 sont acceptés");
                }
            }
            System.out.println("il reste " + nb +" : " + "|".repeat(nb));
        }
        if (rand == 0) {
            System.out.println("\n" + name + " à gagné :)");
            System.out.println("L'ordinateur à perdu :(");
        }else {
            System.out.println("\n" + "L'ordinateur à gagné :)");
            System.out.println(name + " à perdu :(");
        }
    }

    public static void Start(String name) {
        Scanner sc = new Scanner(System.in);
        while (nb < 15) {
            System.out.println("Choisissez le nombre d'allumette de départ ( > 15) :");
            nb = sc.nextInt();
        }
        Random n = new Random();
        rand = n.nextInt(2);
        int alu;
        if (rand == 0) {
            System.out.println("L'ordinateur commence");
        } else {
            System.out.println(name + " commence");
        }
        System.out.println("il reste " + nb +" : " + "|".repeat(nb));
    }

    public static void Menu(String name) {
        System.out.println("\nBonjour " + name + " que voulez vous faire ?");
        System.out.println("    0- quitter le programme");
        System.out.println("    1- Jeu de Nim (le perdant est celui qui retire la derniere allumette)");
        System.out.println("    2- Jeu de Nim inversé (le gagant est celui qui retire la derniere allumette)");
    }

}

