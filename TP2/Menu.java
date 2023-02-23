import javax.swing.*;

/**
 * @author Grégory Balatre
 * @see class Menu (fichier principal du TP)
 * menu pour acceder aux exercices
 */

public class Menu {
    public static void main(String[] args) {

        while (true) {

            String[] menu = {"Exercice 1 & 2", "Exercice 3", "Exercice 4", "Exercice 5"};

            String option = (String) JOptionPane.showInputDialog(
                    null,
                    "Bienvenue sur le menu !",
                    "Choississez un exercice",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    menu,
                    menu[0]);

            System.out.println("Démarrage de l': " + option);

            switch (option) {
                case "Exercice 1 & 2":
                    Exercices.TP2_1.main();
                    break;
                case "Exercice 3":
                    Exercices.TP2_3.main();
                    break;
                case "Exercice 4":
                    Exercices.TP2_4.main();
                    break;
                case "Exercice 5":
                    Exercices.TP2_5.main();
                    break;
            }
            if (!Retry()) {
                break;
            };
        }
    }

    public static boolean Retry() {
         JFrame f = null;
         int a=JOptionPane.showConfirmDialog(f,"Voulez vous retournez au menu ?");
         return a == JOptionPane.YES_OPTION;
    }
}