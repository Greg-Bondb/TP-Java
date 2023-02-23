package Exercices;

/**
 * @author Grégory Balatre
 * - Modelisation d'une carte monstre du jeu Yu Gi Oh avec ses attributs
 */

public class TP3_3 {
    public static class CarteMonstre extends TP3_5.AMonstre {

        @Override
        public TP3_4.CartePiegeEtMagie.Icone getIcone() {
            return null;
        }

        //enumeration Attribut
        public enum Attribut {
            TERRE,
            EAU,
            FEU,
            VENT,
            LUMIERE,
            TENEBRES
        }

        // Constructeur de la classe CarteMonstre
        public CarteMonstre(String nom, int niveau, Attribut attribut, String type, String numero, int attaque, int defense, String description) {
            super(nom, niveau, attribut, type, numero, attaque, defense, description);
        }
    }

    public static class TP_Classe {
        // fonction principale
        public static void main() {
            // Créer une instance de CarteMonstre avec les informations de la carte "Invocateur Dragon Bleu"
            TP3_3.CarteMonstre invocateurDragonBleu = new TP3_3.CarteMonstre("Invocateur Dragon Bleu", 4, TP3_3.CarteMonstre.Attribut.VENT, "Magicien/Effet", "YS14-FR017", 1500, 600, "Si cette carte est envoyée depuis le Terrain au Cimetière : vous pouvez ajouter 1 Monstre Normal de Type Dragon/ Guerrier/Magicien depuis votre Deck à votre main.");

            System.out.println("\nNom de la carte : " + invocateurDragonBleu.getName());
            System.out.println("Niveau de la carte : " + invocateurDragonBleu.getNiveau());
            System.out.println("Attribut de la carte : " + invocateurDragonBleu.getAttribut());
            System.out.println("Description : " + invocateurDragonBleu.getDescription());
            System.out.println("Type de la carte : " + invocateurDragonBleu.getType());
            System.out.println("ATT carte : " + invocateurDragonBleu.getAttaque());
            System.out.println("DEF carte : " + invocateurDragonBleu.getDefense());
            System.out.println("Nom de la classe : " + invocateurDragonBleu.getNomClasse());
            System.out.println("Numero de la carte : " + invocateurDragonBleu.getNumeroCarte());
        }
    }
}
