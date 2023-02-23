package Exercices;

/**
 * @author Grégory Balatre
 * - Modelisation des cartes Piege et Magie du jeu Yu Gi Oh avec leurs attributs
 */

public class TP3_4 {

    public static class CartePiegeEtMagie extends TP3_5.APiegeEtMagie {

        @Override
        public TP3_3.CarteMonstre.Attribut getAttribut() {
            return null;
        }

        @Override
        public int getNiveau() {
            return 0;
        }

        @Override
        public int getAttaque() {
            return 0;
        }

        @Override
        public int getDefense() {
            return 0;
        }

        //enumeration Icone
        public enum Icone {
            EQUIPEMENT,
            TERRAIN,
            JEU_RAPIDE,
            CONTRE,
            CONTINUE,
            RITUEL
        }

        // Constructeur de la classe Carte
        public CartePiegeEtMagie(String nom, String type, Icone icone, String description, String numero) {
            super(nom, type, icone, description, numero);
        }

    }

    public static class TP_Classe {
        // fonction main
        public static void main() {
            // Créer une instance de Carte Magie (TyphonEspaceMystique) et Piege (SortilegeDeLombre)
            CartePiegeEtMagie TyphonEspaceMystique = new CartePiegeEtMagie("Typhon d’Espace Mystique", "Magie", CartePiegeEtMagie.Icone.JEU_RAPIDE, "Ciblez 1 Carte Magie/Piège sur le Terrain ; détruisez la cible.", "YS14-FR024");
            CartePiegeEtMagie SortilegeDeLombre = new CartePiegeEtMagie("Sortilège de l’ombre", "Piège", CartePiegeEtMagie.Icone.EQUIPEMENT, "Activez cette carte en ciblant 1 monstre face recto contrôlé par votre adversaire ; il perd 700 ATK, et aussi, il ne peut ni attaquer ni changer sa position de combat. Lorsqu’il quitte le Terrain, détruisez cette carte", "YS14-FR035");

            System.out.println("\nNom de la carte : " + TyphonEspaceMystique.getName());
            System.out.println("Description : " + TyphonEspaceMystique.getDescription());
            System.out.println("Icone de la carte : " + TyphonEspaceMystique.getIcone());
            System.out.println("Type de la carte : " + TyphonEspaceMystique.getType());
            System.out.println("Nom de la classe : " + TyphonEspaceMystique.getNomClasse());
            System.out.println("Numéro de la carte : " + TyphonEspaceMystique.getNumeroCarte());
            System.out.println("------------------------------");

            System.out.println("Nom de la carte : " + SortilegeDeLombre.getName());
            System.out.println("Description : " + SortilegeDeLombre.getDescription());
            System.out.println("Icone de la carte : " + SortilegeDeLombre.getIcone());
            System.out.println("Type de la carte : " + SortilegeDeLombre.getType());
            System.out.println("Nom de la classe : " + SortilegeDeLombre.getNomClasse());
            System.out.println("Numéro de la carte : " + SortilegeDeLombre.getNumeroCarte());
        }
    }

}