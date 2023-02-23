package Exercices;
import java.io.*;

/**
 * @author Grégory Balatre
 * - Implémentation d'une interface ICarteYuGiOH, AMonstre et APiegeEtMagie pour grouper les modelisations
 * - Possibilité de sauvegarder et lire une carte ICarteYuGiHO via un fichier .txt
 */

public class TP3_5 {

    // Interface ICarteYuGiOH
    public interface ICarteYuGiOH {
        // Attributs de l'interface ICarteYuGiOH
        public String getName();
        public String getDescription();
        public String getNomClasse();
        public String getNumeroCarte();
        public String getType();
        public TP3_3.CarteMonstre.Attribut getAttribut();

        public TP3_4.CartePiegeEtMagie.Icone getIcone();

        int getNiveau();
        int getAttaque();
        int getDefense();
    }

    public abstract static class AMonstre implements ICarteYuGiOH, Serializable {
        // Attributs de la classe AMonstre
        public String nom;
        public int niveau;
        public TP3_3.CarteMonstre.Attribut attribut;
        public String type;
        public String numero;
        public int attaque;
        public int defense;
        public String description;

        // Constructeur AMonstre
        public AMonstre(String nom, int niveau, TP3_3.CarteMonstre.Attribut attribut, String type, String numero, int attaque, int defense, String description) {
            this.nom = nom;
            this.niveau = niveau;
            this.attribut = attribut;
            this.type = type;
            this.numero = numero;
            this.attaque = attaque;
            this.defense = defense;
            this.description = description;
        }

        public String getName() {
            return this.nom;
        }
        public int getNiveau() {
            return this.niveau;
        }
        public TP3_3.CarteMonstre.Attribut getAttribut() {
            return this.attribut;
        }
        public String getType() {
            return this.type;
        }
        public String getNumeroCarte() {
            return this.numero;
        }

        public int getAttaque() {
            return this.attaque;
        }

        public int getDefense() {
            return this.defense;
        }
        public String getDescription() {
            return this.description;
        }
        public String getNomClasse() {
            return "Monstre";
        }

        @Serial
        private static final long serialVersionUID = 1L;
    }

    public abstract static class APiegeEtMagie implements ICarteYuGiOH, Serializable {

        // Attributs de la classe APiegeEtMagie
        public String nom;
        public String type;
        public TP3_4.CartePiegeEtMagie.Icone icone;
        public String description;
        public String numero;

        // Constructeur APiegeEtMagie
        public APiegeEtMagie(String nom, String type, TP3_4.CartePiegeEtMagie.Icone icone, String description, String numero) {
            this.nom = nom;
            this.type = type;
            this.icone = icone;
            this.description = description;
            this.numero = numero;
        }

        public String getName() {
            return this.nom;
        }

        public String getDescription() {
            return this.description;
        }

        public String getNomClasse() {
            return "Piege et magie";
        }

        public String getNumeroCarte() {
            return this.numero;
        }

        public TP3_4.CartePiegeEtMagie.Icone getIcone() {
            return this.icone;
        }

        public String getType() {
            return this.type;
        }

        @Serial
        private static final long serialVersionUID = 1L;

    }

    public static class CarteIO {

        //fonction de sauvegarde
        public static void saveCarte(ICarteYuGiOH carte, String filePath) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(carte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //fonction de lecture
        public static ICarteYuGiOH readCarte(String filePath) {
            ICarteYuGiOH carte = null;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                carte = (ICarteYuGiOH) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return carte;
        }
    }

    public static class TP_Classe {
        // fonction main
        public static void main() {
            TP3_3.CarteMonstre invocateurDragonBleu = new TP3_3.CarteMonstre("Invocateur Dragon Bleu", 4, TP3_3.CarteMonstre.Attribut.VENT, "Magicien/Effet", "YS14-FR017", 1500, 600, "Si cette carte est envoyée depuis le Terrain au Cimetière : vous pouvez ajouter 1 Monstre Normal de Type Dragon/ Guerrier/Magicien depuis votre Deck à votre main.");
            TP3_4.CartePiegeEtMagie TyphonEspaceMystique = new TP3_4.CartePiegeEtMagie("Typhon d’Espace Mystique", "Magie", TP3_4.CartePiegeEtMagie.Icone.JEU_RAPIDE, "Ciblez 1 Carte Magie/Piège sur le Terrain ; détruisez la cible.", "YS14-FR024");

            // Sauvegarde de la carte monstre dans un fichier
            CarteIO.saveCarte(invocateurDragonBleu, "./src/Fichiers/TP3_5/invocateurDragonBleu.txt");
            // Sauvegarde de la carte magie dans un fichier
            CarteIO.saveCarte(TyphonEspaceMystique, "./src/Fichiers/TP3_5/TyphonEspaceMystique.txt");

            // Lecture de la carte monstre à partir du fichier
            ICarteYuGiOH carteMonstre = CarteIO.readCarte("./src/Fichiers/TP3_5/invocateurDragonBleu.txt");
            // Lecture de la carte magie à partir du fichier
            ICarteYuGiOH carteMagie = CarteIO.readCarte("./src/Fichiers/TP3_5/TyphonEspaceMystique.txt");

            // Affichage des informations de la carte monstre
            System.out.println("Lecture Carte Invocateur Dragon Bleu");
            System.out.println("Nom :" + carteMonstre.getName());
            System.out.println("Niveau :" + carteMonstre.getNiveau());
            System.out.println("Attribut :" + carteMonstre.getAttribut());
            System.out.println("Description :" + carteMonstre.getDescription());
            System.out.println("Type :" + carteMonstre.getType());
            System.out.println("Attaque :" + carteMonstre.getAttaque());
            System.out.println("Defense :" + carteMonstre.getDefense());
            System.out.println("Classe :" + carteMonstre.getNomClasse());
            System.out.println("Numero :" + carteMonstre.getNumeroCarte());
            System.out.println("-----------------------------------------------");

            // Affichage des informations de la carte magie
            System.out.println("Lecture Carte Typhon Espace Mystique");
            System.out.println("Nom :" + carteMagie.getName());
            System.out.println("Description :" + carteMagie.getDescription());
            System.out.println("Icone :" + carteMagie.getIcone());
            System.out.println("Type :" + carteMagie.getType());
            System.out.println("Classe :" + carteMagie.getNomClasse());
            System.out.println("Numero :" + carteMagie.getNumeroCarte());
        }
    }

}