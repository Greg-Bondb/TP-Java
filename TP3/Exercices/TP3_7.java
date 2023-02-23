package Exercices;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Grégory Balatre
 * - Création d'un deck Yu Gi Ho automatique (de 40 à 60 cartes)
 * - Utilisation d'une API stockée en local pour plus de réalisme (l'API peut aussi etre implémenter sur Github)
 */

public class TP3_7 {

    public static class FabriqueDeck_YUGIOH {

        public static ArrayList<TP3_5.ICarteYuGiOH> zoneDeck = new ArrayList<TP3_5.ICarteYuGiOH>();
        public static ArrayList<TP3_5.ICarteYuGiOH> deckList = new ArrayList<TP3_5.ICarteYuGiOH>();

        public static ArrayList<TP3_5.ICarteYuGiOH> zoneExtraDeck = new ArrayList<TP3_5.ICarteYuGiOH>();

        // fonction demarrage fabrique deck
        public static void start(){
            while(true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Entrez le nombre de carte (40 cartes MIN & 60 cartes MAX):");
                    int nbCarte = sc.nextInt();
                    if (nbCarte < 40 || nbCarte > 60 ) {
                        System.out.println("Vous devez entrer un nombre compris entre 40 cartes et 60 cartes.\n");
                    } else {
                        // construit le deck
                        Fabrique(nbCarte);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e+"Entrer un nombre compris entre 40 cartes et 60 cartes.");
                }
            }
        }

        // Creation Deck auto (50% monstres et 50% cartes magies et pièges).
        public static void Fabrique(int nbCarte) {
            // création nouveau deck
            ArrayList<TP3_5.ICarteYuGiOH> deck = new ArrayList<>();
            // join BDD
            Gson gson = new Gson();
            File jsonFile = new File("./src/Fichiers/TP3_7/BDD.json");
            try (FileReader reader = new FileReader(jsonFile)) {
                Data data = gson.fromJson(reader, Data.class);
                // tableau de cartes
                Card[] cards = data.data;
                // liste des cartes aléatoires
                List<Card> selectedCards = new ArrayList<>();
                // map count nb exemplaire cartes aléatoires
                Map<String, Integer> cardCount = new HashMap<>();

                int monsterCards = 0;
                int spellTrapCards = 0;

                // Création deck
                while (selectedCards.size() < nbCarte) {
                    // random index card
                    int randomIndex = new Random().nextInt(cards.length);
                    // récuperation info carte tirée
                    Card card = cards[randomIndex];
                    // max 3 cartes identique
                    if (cardCount.containsKey(card.name) && cardCount.get(card.name) >= 3) {
                        continue;
                    }
                    // 50% cartes Monster and 50% Spell/Trap
                    if (card.type.contains("Monster") && monsterCards < nbCarte / 2) {
                        monsterCards++;
                    } else if (card.type.equals("Spell Card") || card.type.equals("Trap Card") && spellTrapCards < nbCarte / 2) {
                        spellTrapCards++;
                    } else {
                        continue;
                    }
                    // ajout carte au deck
                    selectedCards.add(card);
                    // ajout carte tableau exemplaires
                    cardCount.put(card.name, cardCount.getOrDefault(card.name, 0) + 1);
                }
                for (Card card : selectedCards) {
                    String replace;
                    // correction BDD problem
                    if (card.card_sets == null) {
                        replace = "null";
                    } else {
                        replace = card.card_sets[0].set_code;
                    }
                    // création carte monstre/spell/trap
                    TP3_5.ICarteYuGiOH carte;
                    if (card.type.contains("Monster")){
                        carte = new TP3_3.CarteMonstre(card.name, card.level, card.attribute, card.type, replace, card.atk, card.def, card.desc);
                    } else {
                        carte = new TP3_4.CartePiegeEtMagie(card.name, card.type, card.race, card.desc, replace);
                    }
                    zoneDeck.add(carte);
                    deckList.add(carte);
                }

                // Création extra deck
                while (zoneExtraDeck.size() < 15) {
                    int randomIndex = new Random().nextInt(cards.length);
                    Card card = cards[randomIndex];
                    if (card.type.contains("Xyz") || card.type.contains("Synchro") || card.type.contains("Fusion")) {
                        String replace;
                        if (card.card_sets == null) {
                            replace = "null";
                        } else {
                            replace = card.card_sets[0].set_code;
                        }
                        TP3_5.ICarteYuGiOH carte;
                        carte = new TP3_3.CarteMonstre(card.name, card.level, card.attribute, card.type, replace, card.atk, card.def, card.desc);
                        zoneExtraDeck.add(carte);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Création du deck effectué.");
        }

        static class Data {
            Card[] data;
        }

        static class Card {
            int level;
            String name;
            TP3_3.CarteMonstre.Attribut attribute;
            String type;
            TP3_4.CartePiegeEtMagie.Icone race;
            int atk;
            int def;
            String desc;
            CardSet[] card_sets;
        }

        static class CardSet {
            String set_code;
        }
    }

}