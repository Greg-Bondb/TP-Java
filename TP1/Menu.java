import javax.swing.*;

/**
 * @author Grégory Balatre
 * @param option nombre fournit par l'utilisateur
 * menu pour acceder aux exercices
 */

public class Menu {
    public static void main(String[] args) {

        while (true) {

            String[] menu = {"Exercice 1", "Exercice 2", "Exercice 3", "Exercice 4", "Exercice 5", "Exercice 6", "test"};

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
                case "Exercice 1":
                    TP1_1.main();
                    break;
                case "Exercice 2":
                    TP1_2.main();
                    break;
                case "Exercice 3":
                    TP1_3.main();
                    break;
                case "Exercice 4":
                    TP1_4.main();
                    break;
                case "Exercice 5":
                    TP1_5.main();
                    break;
                case "Exercice 6":
                    TP1_6.main();
                    break;
                case "test":
                    test.main();
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