package Exercices;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Grégory Balatre
 * - Implémentation de tapis de jeu Yu GI HO avec ses fonctionnalités
 * - Le code commenté dans la fonction main() permet de tester quelques fonctionnalités,
 *   priviliegiez tout de même le code déjà présent pour une meilleure immersion et tester toutes les implémentations.
 */

public class TP3_6 {

    public static class TapisDeJeu extends TP3_7.FabriqueDeck_YUGIOH{

        public static ArrayList<String> zoneMonstre;
        public static ArrayList<String> zoneMagieEtPiege;
        public static ArrayList<String> cimetiere;
        public static ArrayList<String> zoneTerrain;
        public static ArrayList<String> hand;

        public TapisDeJeu() {
            zoneMonstre = new ArrayList<>();
            zoneMagieEtPiege = new ArrayList<>();
            cimetiere = new ArrayList<>();
            zoneDeck = new ArrayList<>();
            zoneTerrain = new ArrayList<>();
            zoneExtraDeck = new ArrayList<>();
            hand = new ArrayList<>();
            zoneExtraDeck = new ArrayList<>();
        }

        //fonction pour piocher une carte du deck ou de l'extra deck
        public static void piocherCarte(ArrayList<TP3_5.ICarteYuGiOH> deckName) {
            if (hand.size() <= 7) {
                deckName.get(0).getName();
                hand.add(deckName.get(0).getName());
                System.out.println("Vous avez pioché la carte " + deckName.get(0).getName() + " dans votre deck.");
                deckName.remove(0);
            }
            if (hand.size() >= 8) {
                System.out.println("Votre main est pleine, choississez une carte a envoyer au cimetiere :\n");
                for (int i = 0; i < hand.size(); i++) {
                    System.out.println((i + 1) + " - " + hand.get(i));
                }
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                if (num <= hand.size() && num > 0){
                    detruireCarte(hand.get(num-1));
                }
            }
        }

        //fonction affiche le deck de l'utilisateur
        public static void Deck() {
            System.out.println("Votre deck :");
            int i = 1;
            for (  TP3_5.ICarteYuGiOH card : deckList) {
                System.out.println(i + " - " + card.getName());
                i++;
            }
            System.out.println("\nVotre extra deck :");
            int j = 1;
            for (  TP3_5.ICarteYuGiOH card : zoneExtraDeck) {
                System.out.println(j + " - " + card.getName());
                j++;
            }
        }

        //fonction afficher les informations d'une carte du deck en particulier
        public static void informationCard() {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\nEntrez le numéro de carte associé à la carte dans votre deck.");
                int num = sc.nextInt();
                for ( int i = 0; i < deckList.size(); i++) {
                    if (i == num-1) {
                        if (zoneDeck.get(i).getType().contains("Monster")) {
                            System.out.println("Nom :" + deckList.get(i).getName());
                            System.out.println("Niveau :" + deckList.get(i).getNiveau());
                            System.out.println("Attribut :" + deckList.get(i).getAttribut());
                            System.out.println("Description :" + deckList.get(i).getDescription());
                            System.out.println("Type carte :" + deckList.get(i).getType());
                            System.out.println("Attaque :" + deckList.get(i).getAttaque());
                            System.out.println("Defense :" + deckList.get(i).getDefense());
                            System.out.println("Nom classe :" + deckList.get(i).getNomClasse());
                            System.out.println("Numero carte :" + deckList.get(i).getNumeroCarte());
                            return;
                        } else {
                            System.out.println("Nom :" + deckList.get(i).getName());
                            System.out.println("Description :" + deckList.get(i).getDescription());
                            System.out.println("Niveau :" + deckList.get(i).getIcone());
                            System.out.println("Type carte :" + deckList.get(i).getType());
                            System.out.println("Nom classe :" + deckList.get(i).getNomClasse());
                            System.out.println("Numero carte :" + deckList.get(i).getNumeroCarte());
                            return;
                        }

                    }
                }
                System.out.println("Nombre incorrect.");
            } catch (Exception e) {
                System.out.println("Entrer un nombre.");
            }
        }

        //fonction cartes dans la main de l'utilisateur
        public static void hand() {
            for (int i = 0; i < hand.size(); i++) {
                System.out.println((i + 1) + " - " + hand.get(i));
            }
            if (hand.size() == 0) {
                System.out.println("Vous n'avez pas de cartes dans votre main");
            }
        }

        //fonction pour jouer une carte monstre
        public static void jouerCarteMonstre() {
            if (zoneMonstre.size() <= 6) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Entrez le nombre de la carte Monstre que vous souhaitez placer sur le terrain :");
                for (int i = 0; i < hand.size(); i++) {
                    System.out.println((i + 1) + " - " + hand.get(i));
                }
                int nbCarte = sc.nextInt();
                if (nbCarte <= hand.size() && nbCarte > 0 && zoneDeck.get(nbCarte).getType().contains("Monster")) {
                    zoneMonstre.add(hand.get(nbCarte-1));
                    System.out.println(zoneMonstre.get(zoneMonstre.size()-1) + " a été joué dans la zone Monstre.");
                    hand.remove(nbCarte-1);
                }else {
                    System.out.println("Impossible de jouer la carte car le numero est pas bon ou la carte n'est pas une carte Monstre");
                }
            } else {
                System.out.println("Impossible de jouer la carte, la zone Monstre est pleine.");
            }
        }

        //fonction jouer une carte magie ou piege
        public static void jouerCarteMagieEtPiege() {
            if (zoneMagieEtPiege.size() <= 6) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Entrez le nombre de la carte Magie ou Piege que vous souhaitez placer sur le terrain :");
                for (int i = 0; i < hand.size(); i++) {
                    System.out.println((i + 1) + " - " + hand.get(i));
                }
                int nbCarte = sc.nextInt();
                if (nbCarte <= hand.size() && nbCarte > 0 && zoneDeck.get(nbCarte).getType().contains("Spell") || zoneDeck.get(nbCarte).getType().contains("Trap")) {
                    zoneMagieEtPiege.add(hand.get(nbCarte-1));
                    System.out.println(zoneMagieEtPiege.get(zoneMagieEtPiege.size()-1) + " a été joué dans la zone Magie et Piege.");
                    hand.remove(nbCarte-1);
                } else {
                    System.out.println("Impossible de jouer la carte car le numero est pas bon ou la carte n'est pas une carte Magie ou Piege");
                }
            } else {
                System.out.println("Impossible de jouer la carte, la zone Magie & Piege est pleine.");
            }
        }

        //fonction jouer une carte de terrain
        public static void jouerCarteTerrain() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez le nombre de la carte Magie de terrain :");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println((i + 1) + " - " + hand.get(i));
            }
            int nbCarte = sc.nextInt();
            if (zoneTerrain.size() == 0 && nbCarte <= hand.size() && nbCarte > 0 && zoneDeck.get(nbCarte).getType().contains("Field")) {
                zoneTerrain.add(hand.get(nbCarte-1));
                System.out.println(hand.get(nbCarte-1) + " a été joué dans la zone Terrain.");
                hand.remove(nbCarte-1);
            } else {
                System.out.println("Vous devez d'abord envoyer la carte de terrain actuelle au cimetière pour en jouer une nouvelle.");
            }
        }

        //fonction affiche toute les cartes de la zone monstre
        public static void afficherZoneMonstre() {
            if (zoneMonstre.size() == 0) {
                System.out.println("La zone Monstre est vide." + "\n");
                return;
            }
            System.out.println("Contenu de la zone Monstre : ");
            for (int i = 0; i < zoneMonstre.size(); i++) {
                System.out.println(i+1 + " - " + zoneMonstre.get(i));
            }
            System.out.print("\n");
        }

        //fonction affiche toute les cartes de la zone magie et piege
        public static void afficherZoneMagieEtPiege() {
            if (zoneMagieEtPiege.size() == 0) {
                System.out.println("La zone Magie & Piège est vide." + "\n");
                return;
            }
            System.out.println("Contenu de la zone Magie & Piège:");
            for (int i = 0; i < zoneMagieEtPiege.size(); i++) {
                System.out.println(i+1 + " - " + zoneMagieEtPiege.get(i));
            }
            System.out.print("\n");
        }

        //fonction afficher la carte terrain en cours
        public static void afficherTerrain() {
            if (zoneTerrain.size() == 0) {
                System.out.println("Le Terrain est vide." + "\n");
                return;
            }
            System.out.println("Carte du Terrain : ");
            System.out.println("1 - " + zoneMonstre.get(0) + "\n");
        }

        //fonction de destruction d'une carte
        public static void detruireCarte(String carte) {
            if (hand.contains(carte)) {
                hand.remove(carte);
                cimetiere.add(carte);
                System.out.println(carte + " a été détruite et envoyée au cimetière.");
            } else if (zoneMonstre.contains(carte)) {
                zoneMonstre.remove(carte);
                cimetiere.add(carte);
                System.out.println(carte + " a été détruite et envoyée au cimetière.");
            } else if (zoneMagieEtPiege.contains(carte)) {
                zoneMagieEtPiege.remove(carte);
                cimetiere.add(carte);
                System.out.println(carte + " a été détruite et envoyée au cimetière.");
            } else if (zoneTerrain.contains(carte)) {
                zoneTerrain.remove(carte);
                cimetiere.add(carte);
                System.out.println(carte + " a été détruite et envoyée au cimetière.");
            } else {
                System.out.println("La carte spécifiée n'est pas présente sur le terrain ou dans votre main.");
            }
        }

        //fonction affiche toute les cartes dans le cimetiere
        public static void afficherCimetiere() {
            if (cimetiere.size() == 0) {
                System.out.println("La zone Cimetiere est vide.");
                return;
            }
            System.out.println("Contenu du Cimetière : ");
            for (int i = 0; i < cimetiere.size(); i++) {
                System.out.println(i+1 + " - " + cimetiere.get(i));
            }
            System.out.print("\n");
        }
    }

    //fonction AMagieDeTerrain
    public static class AMagieDeTerrain extends TP3_4.CartePiegeEtMagie {
        public AMagieDeTerrain(String nom, String numeroCarte, String description) {
            super(nom, "Magie", Icone.TERRAIN, numeroCarte, description);
        }
    }

    //fonction menu
    public static void menu() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\nBienvenue sur le menu, que voulez vous faire :");
                tabMenu();
                int choice = sc.nextInt();
                if (choice == 0) {
                    System.exit(0);
                } else if (choice == 1) {
                    TapisDeJeu.Deck();
                } else if (choice == 2) {
                    TapisDeJeu.informationCard();
                } else if (choice == 3) {
                    TapisDeJeu.piocherCarte(TapisDeJeu.zoneDeck);
                } else if (choice == 4) {
                    TapisDeJeu.piocherCarte(TapisDeJeu.zoneExtraDeck);
                } else if (choice == 5) {
                    TapisDeJeu.hand();
                } else if (choice == 6) {
                    TapisDeJeu.jouerCarteMonstre();
                } else if (choice == 7) {
                    TapisDeJeu.jouerCarteMagieEtPiege();
                } else if (choice == 8) {
                    TapisDeJeu.jouerCarteTerrain();
                } else if (choice == 9) {
                    TapisDeJeu.afficherTerrain();
                    TapisDeJeu.afficherZoneMonstre();
                    TapisDeJeu.afficherZoneMagieEtPiege();
                    TapisDeJeu.afficherCimetiere();
                } else {
                    System.out.println("Entrer un nombre correct.");
                }

            } catch (Exception e) {
                System.out.println(e + "Entrer un nombre correct.");
            }
        }
    }

    //fonction tableau des entrées
    public static void tabMenu() {
        System.out.println("0 : quitter le jeu");
        System.out.println("1 : voir le deck");
        System.out.println("2 : voir les informations d'une carte du deck");
        System.out.println("3 : piocher une carte du deck");
        System.out.println("4 : piocher une carte de l'extra deck");
        System.out.println("5 : voir les cartes dans la main");
        System.out.println("6 : jouer une carte Monstre");
        System.out.println("7 : jouer une carte Magie & Piege");
        System.out.println("8 : jouer une carte Magie de Terrain");
        System.out.println("9 : information tapis de jeu (terrain, zoneMonstre, zoneMagie&Piege, Cimetiere)");
    }

    public static class TP_Classe {
        //fonction principale
        public static void main() {
            TapisDeJeu tapis = new TapisDeJeu();
            new AMagieDeTerrain("Terrain de la Jungle", "TER-001", "Ajoute 500 à l'ATK de tous les monstres de type Beast-Warrior sur le terrain et augmente leur DEF de 200.");
            tapis.start();
            menu();

            /*

            // Création des cartes monstre
            TP3_3.CarteMonstre dragonBlancAuxYeuxBleus = new TP3_3.CarteMonstre("Dragon Blanc aux Yeux Bleus", 8, TP3_3.CarteMonstre.Attribut.LUMIERE, "Dragon", "LC01-FR001", 3000, 2500, "Un dragon puissant aux yeux bleus");
            TP3_3.CarteMonstre dragonNoirDuChaos = new TP3_3.CarteMonstre("Dragon Noir du Chaos", 8, TP3_3.CarteMonstre.Attribut.TENEBRES, "Dragon", "LC01-FR002", 2800, 2600, "Un dragon maléfique du chaos");

            // Création des cartes piege et magie
            TP3_4.CartePiegeEtMagie FeuArdent = new TP3_4.CartePiegeEtMagie("Feu Ardent", "Magie", TP3_4.CartePiegeEtMagie.Icone.JEU_RAPIDE, "Inflige des dommages à l'adversaire égaux à l'ATK d'un monstre sur le terrain de l'adversaire", "LC5D-FR222");
            TP3_4.CartePiegeEtMagie PiegeARenvoyer = new TP3_4.CartePiegeEtMagie("Piège à Renvoyer", "Piège", TP3_4.CartePiegeEtMagie.Icone.CONTRE, "Retourne un monstre de l'adversaire dans la main de son propriétaire", "LC5D-FR123");

            // Création carte terrain
            AMagieDeTerrain terrain = new AMagieDeTerrain("Terrain de la Jungle", "TER-001", "Ajoute 500 à l'ATK de tous les monstres de type Beast-Warrior sur le terrain et augmente leur DEF de 200.");

            TP3_5.ICarteYuGiOH Sphinx = new TP3_3.CarteMonstre("Sphinx", 6, TP3_3.CarteMonstre.Attribut.TERRE, "Divinité", "LC01-EN002", 2800, 2000, "Une divinité égyptienne avec des capacités de magie puissantes.");

            // Ajout des cartes au deck
            tapis.zoneDeck.add(dragonBlancAuxYeuxBleus);
            tapis.zoneDeck.add(dragonNoirDuChaos);
            tapis.zoneDeck.add(FeuArdent);
            tapis.zoneDeck.add(PiegeARenvoyer);
            tapis.zoneExtraDeck.add(Sphinx);

            // Piocher une carte
            tapis.piocherCarte(TapisDeJeu.zoneDeck);

            // Piocher une carte de l'extra deck
            tapis.piocherCarte(TapisDeJeu.zoneExtraDeck);

            // Détruire une carte
            tapis.detruireCarte("Feu Ardent");

            // Afficher le contenu de la zone Monstre
            tapis.afficherZoneMonstre();

            // Afficher le contenu de la zone Magie et Piège
            tapis.afficherZoneMagieEtPiege();

            // Afficher le contenu du Cimetière
            tapis.afficherCimetiere();

            // Afficher le contenu du deck et de l'extra deck
            tapis.Deck();

            */
        }
    }
}