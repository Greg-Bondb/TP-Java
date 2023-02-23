package Exercices;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt;

/**
 * @author Grégory Balatre
 * - La methode Cn calcul 2 * x * y / (x + y)
 * - La methode In calcul sqrt(x * y )
 * - La methode An fait un encadrement de pi
 */

public class TP2_1 {
    public static void main() {
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Entrez la valeur de X :");
                double X = sc.nextDouble();

                System.out.println("Entrez la valeur de Y :");
                double Y = sc.nextDouble();

                System.out.println("Entrez la valeur de N :");
                int N = sc.nextInt();

                if (X <= 0 || Y <= 0 || N <= 0) {
                    System.out.println("Entrez une valeur de X, Y et N >= 0\n");
                } else {
                    Archimede.Cn(X, Y);
                    Archimede.In(X, Y);
                    Archimede.An(N);
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu.");
            }
        }
    }

    public static class Archimede {

        public static double Cn(double X, double Y) {
            return 2 * X * Y / (X + Y);
        }

        public static double In(double X, double Y) {
            return sqrt(X * Y);
        }

        public static void An(int N) {
            System.out.println("Pour X = 4 et Y = 2*sqrt(2), la méthode An renvoie les valeurs suivantes :");
            double X = 4;
            double Y = 2 * sqrt(2);
            double[] tab = new double[N*2];
            for (int i = 0; i < N*2; i += 2) {
                X = Archimede.Cn(X, Y);
                tab[i] = X;
                Y = Archimede.In(X, Y);
                tab[i+1] = Y;
            }
            System.out.println(Arrays.toString(tab));
            System.out.println("le tableau converge vers PI");
        }

    }

}