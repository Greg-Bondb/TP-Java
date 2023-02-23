import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main() {
        System.out.println("\nEntrez la taille du tableau (0 pour terminer) : ");
        Scanner sc = new Scanner(System.in);
        double taille = sc.nextInt();
        if (taille <= 0) {
            System.out.println("Erreur, la valeur ne peut pas etre negative ou egale a 0");
        } else {
            Tableau((int) taille);
        }
    }

    public static void Tableau(int taille) {
        int x = 0;
        int y = 0;
        double somme = 0;
        DecimalFormat df = new DecimalFormat("0.0");
        List<Double> liste = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String[][] tableau = new String[taille][taille];
        // fabrication du tableau
        for (int i = 1; i <= Math.pow(taille,2); i++, y++) {
            if (y == taille){
                x++;
                y = 0;
            }
            System.out.println("Entre valeur [" + (x+1) + "," + (y+1) + "]" + " :");
            int number = sc.nextInt();
            tableau[x][y] = String.valueOf(number);
        }
        x = 0;
        y = 0;
        // print tableau + somme droite
        for ( int j = 0; j < Math.pow(taille,2); j++, y++) {
            if (y == taille){
                System.out.print(Arrays.toString(tableau[x]));
                x++;
                y = 0;
                System.out.println((" " + somme/taille));
                liste.add(somme/taille);
                somme = 0;
            }
            somme += Integer.parseInt(tableau[x][y]);
        }
        System.out.print(Arrays.toString(tableau[x]));
        System.out.println((" " + df.format(somme/taille)));
        liste.add((somme/taille));
        // print somme bas
        x = 0;
        y = 0;
        somme = 0;
        for ( int k = 0; k < Math.pow(taille,2); k++, x++) {
            if (x == taille){
                y++;
                x = 0;
                System.out.print((" " + df.format(somme/taille)));
                liste.add((somme/taille));
                somme = 0;
            }
            somme += Integer.parseInt(tableau[x][y]);
        }
        System.out.print((" " + df.format(somme/taille)));
        liste.add((somme/taille));
        // print somme angle
        double sum = 0;
        for(int i = 0; i < liste.size(); i++) {
            sum += liste.get(i);
        }
        System.out.println(" " + df.format((sum/2)));
    }
}