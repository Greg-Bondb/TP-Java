import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * @param input nombre fournit par l'utilisateur
 * affiche un tableau de la moyenne des éléments de chaque ligne, de chaque colonne
 */
public class TP1_6 {
    public static void main() {
        int input = 1;
        while(input != 0) {
            try {
                System.out.println("\nEntrez la taille du tableau (0 pour terminer) : ");
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input <= 0) {
                    System.out.println("Erreur, la valeur ne peut pas etre negative ou egale a 0");
                } else {
                    List(input);
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu.");
            }
        }
        System.out.println("Fin du programme.");
    }
    public static void List(int input) {
        List<Integer> list = new ArrayList<>();
        int x = 1;
        int y = 1;
        for (int i = 1; i <= Math.pow(input,2); i++, y++) {
            if (y == input+1){
                x++;
                y = 1;
            }
            System.out.println("Entre valeur [" + x + "," + y + "]" + " :");
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();
            list.add(result);
        }
        Tableau(input, list);
    }
    public static void Tableau(int input, List<Integer> list) {

        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        final String RESET = "\u001B[0m";
        DecimalFormat df = new DecimalFormat("0.00");

        String[][] tabValue = new String[input+2][input+2];
        int x = 0;
        int y = 0;
        int z = 0;
        double angle = 0;
        for (int i = 1; i < Math.pow(input+2,2); i++, y++) {
            if (y == input+2){
                x++;
                y = 0;
            }
            if (x == 0) {
                tabValue[x][y] = BLUE + "[ " + x + ";" + y + " ]" + RESET;
            } else if (y == 0) {
                tabValue[x][y] = BLUE + "[ " + x + ";" + y + " ]" + RESET;
            } else if (y != tabValue.length-1 && x!= tabValue.length-1) {
                if (list.get(z) < 10) {
                    tabValue[x][y] = "   " + list.get(z) + "   ";
                } else {
                    tabValue[x][y] = "  " + list.get(z) + "   ";
                }
                z++;
            } else if (y == tabValue.length-1 && x!= tabValue.length-1) {
                int index = x * input - input;
                double sum = 0;
                for (int j = 0; j < input; j++) {
                    sum += list.get(index+j);
                }
                tabValue[x][y] = GREEN + "( " + df.format(sum/input) + " )" + RESET;
                angle += sum/input;
            } else if (x == tabValue.length-1 && y!= tabValue.length-1) {
                int index = input;
                double sum = 0;
                for (int k = 0; k < input; k++) {
                    sum += list.get(k * index + (y-1));
                }
                tabValue[x][y] = GREEN + "( " + df.format(sum/input) + " )" + RESET;
                angle += sum/input;
            }
            tabValue[input+1][input+1] = GREEN + "( " + angle/2 + " )" + RESET;
        }
        for (String[] str : tabValue) {
            System.out.format("%10s", Arrays.toString(str));
            System.out.println();
        }
    }
}