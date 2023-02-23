package Exercices;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Grégory Balatre
 * - Créer des étudiants et une Classe et teste des fonctionnalités
 * - Possibilité de sauvegarder et lire une liste d'étudiant dans un fichier .txt
 */
public class TP3_1 {

    public static class Etudiant {
        // Attributs de la classe Etudiant
        private final String nom;
        private final String prenom;
        private final String numero;
        private final Map<String, Map<String, Double>> notes;

        // Constructeur de la classe Etudiant
        public Etudiant(String nom, String prenom, String numero) {
            this.nom = nom;
            this.prenom = prenom;
            this.numero = numero;
            this.notes = new HashMap<>();
        }

        // Méthode pour ajouter une note à un étudiant
        public void setNote(String matiere, String typeNote, double note) {
            if (!this.notes.containsKey(matiere)) {
                this.notes.put(matiere, new HashMap<>());
            }
            this.notes.get(matiere).put(typeNote, note);
        }

        // Méthode surchargeée pour ajouter le numero de l'examem à un étudiant
        public void setNote(String matiere, String typeNote, int nbExam, double note) {
            if (!this.notes.containsKey(matiere)) {
                this.notes.put(matiere, new HashMap<>());
            }
            this.notes.get(matiere).put(typeNote + "_" + nbExam, note);
        }

        // Méthode pour afficher toutes les notes d'un étudiant
        public void afficherNotes() {
            for (Map.Entry<String, Map<String, Double>> entry : this.notes.entrySet()) {
                String matiere = entry.getKey();
                Map<String, Double> notesMatiere = entry.getValue();
                for (Map.Entry<String, Double> entry2 : notesMatiere.entrySet()) {
                    String typeNote = entry2.getKey();
                    double note = entry2.getValue();
                    System.out.println(matiere + " - " + typeNote + " : " + note);
                }
            }
        }

        // Méthode surchargeée pour afficher les notes d'un étudiant dans une matière spécifique
        public void afficherNotes(String matiere) {
            if (this.notes.containsKey(matiere)) {
                Map<String, Double> notesMatiere = this.notes.get(matiere);
                for (Map.Entry<String, Double> entry : notesMatiere.entrySet()) {
                    String typeNote = entry.getKey();
                    double note = entry.getValue();
                    System.out.println(matiere + " - " + typeNote + " : " + note);
                }
            } else {
                System.out.println("L'étudiant n'a pas de notes enregistrées dans cette matière.");
            }
        }

        // Méthode pour calculer la moyenne d'un étudiant dans certaine matière
        public double moyenne(String matiere) {
            double moyenne = 0;
            int nbNotes = 0;
            if (this.notes.containsKey(matiere)) {
                Map<String, Double> notesMatiere = this.notes.get(matiere);
                for (Double note : notesMatiere.values()) {
                    moyenne += note;
                    nbNotes++;
                }
                moyenne /= nbNotes;
            }
            return moyenne;
        }
    }

    public static class Classe {
        private final Map<String, Etudiant> etudiants;

        // Constructeur de la classe Classe
        public Classe() {
            // Attributs de la classe Classe
            this.etudiants = new HashMap<>();
        }

        // Méthode pour ajouter un étudiant à la classe
        public void setEtudiant(Etudiant etudiant) {
            this.etudiants.put(etudiant.numero, etudiant);
        }

        // Méthode pour afficher tous les étudiants de la classe
        public void afficher() {
            System.out.println("Affichage de tous les étudiants actuel :");
            for (Etudiant etudiant : this.etudiants.values()) {
                System.out.println(etudiant.nom + " " + etudiant.prenom);
            }
        }

        // Méthode pour calculer la moyenne de la classe dans une matière donnée
        public double moyenneClasse(String matiere) {
            double moyenne = 0;
            int nbEtudiants = 0;
            for (Etudiant etudiant : this.etudiants.values()) {
                moyenne += etudiant.moyenne(matiere);
                nbEtudiants++;
            }
            moyenne /= nbEtudiants;
            return moyenne;
        }

        // Méthode pour sauvegarder la liste des étudiants dans un fichier
        public void sauvegarderEtudiants(String file) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Etudiant etudiant : this.etudiants.values()) {
                writer.write(etudiant.nom + "_" + etudiant.prenom + "_" + etudiant.numero);
                writer.newLine();
            }
            writer.close();
        }

        // Méthode pour lire la liste des étudiants dans un fichier
        public void chargerEtudiants(String file) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String ligne;
            System.out.println("------------------------------");
            System.out.println("Lecture de la liste :");
            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split("_");
                String nom = elements[0];
                String prenom = elements[1];
                String numero = elements[2];
                Etudiant etudiant = new Etudiant(nom, prenom, numero);
                System.out.println("-" + nom + " " + prenom + " " + numero);
                this.etudiants.put(numero, etudiant);
            }
            System.out.println("------------------------------");
            reader.close();
        }
    }

    public static class TP_Classe {
        //fonction principale
        public static void main() throws IOException {

            // Création de la classe
            Classe B2INFO = new Classe();

            B2INFO.chargerEtudiants("./src/Fichiers/TP3_1/Liste.txt");

            // Création et ajout d'étudiants à la classe
            Etudiant etudiant4 = new Etudiant("Sevenet", "Axel", "4");
            Etudiant etudiant5 = new Etudiant("Zaphattii", "Nolan", "5");
            Etudiant etudiant6 = new Etudiant("Coletta", "Quentin", "6");
            B2INFO.setEtudiant(etudiant4);
            B2INFO.setEtudiant(etudiant5);
            B2INFO.setEtudiant(etudiant6);

            // Affichage de tous les étudiants
            B2INFO.afficher();

            // Ajout de notes pour chaque étudiant
            etudiant4.setNote("PHP", "Exo1", 1, 15);
            etudiant4.setNote("PHP", "Exo2", 12);
            etudiant5.setNote("Infra", "Exo1", 2, 14);
            etudiant5.setNote("PHP", "Exo1", 16);
            etudiant6.setNote("Dev", "Exo1", 3, 17);
            etudiant6.setNote("PHP", "Exo1", 5);

            // Affichage des notes de chaque étudiant
            System.out.println("------------------------------");
            System.out.println("Attribution de notes pour les étudiants crées :");
            System.out.println("-" + etudiant4.nom + " " + etudiant4.prenom + " " + etudiant4.numero + " :");
            etudiant4.afficherNotes();
            System.out.println("-" + etudiant5.nom + " " + etudiant5.prenom + " " + etudiant5.numero + " :");
            etudiant5.afficherNotes();
            System.out.println("-" + etudiant6.nom + " " + etudiant6.prenom + " " + etudiant6.numero + " :");
            etudiant6.afficherNotes();
            System.out.println("------------------------------");
            System.out.println("Note(s) de " + etudiant5.nom + " " + etudiant5.prenom + " en Infra :");
            etudiant5.afficherNotes("Infra");

            // Affichage de la moyenne de chaque étudiant pour une certaine matiere
            System.out.println("Moyenne de Axel en PHP : " + etudiant4.moyenne("PHP"));
            System.out.println("Moyenne de Nolan en Infra : " + etudiant5.moyenne("Infra"));
            System.out.println("Moyenne de Quentin en Dev : " + etudiant6.moyenne("Dev"));

            // Affichage de la moyenne de la classe pour une certaine matiere
            System.out.println("------------------------------");
            System.out.println("Moyenne de la classe en PHP : " + B2INFO.moyenneClasse("PHP"));

            B2INFO.sauvegarderEtudiants("./src/Fichiers/TP3_1/Liste.txt");
        }
    }

}