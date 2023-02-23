package Exercices;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.util.Random;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Grégory Balatre
 * - Affiche en graphique un JButton, BoxLayout et Cartes de jeu aléatoire
 */

public class TP3_2 {

    public static class TP_Classe {
        // fonction main
        public static void main() {
            while (true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    Menu();
                    int input = sc.nextInt();
                    switch (input) {
                        case 0 -> {
                            System.out.println("\nFin du programme.");
                            System.exit(0);
                        }
                        case 1 -> {
                            close();
                            Button.main();
                        }
                        case 2 -> {
                            close();
                            Formulaire.main();
                        }
                        case 3 -> {
                            close();
                            Jeu.main();
                        }
                        default -> System.out.println("\nJe n'ai pas compris votre demande :(");
                    }
                } catch (Exception e) {
                    System.out.println("Un problème est survenu. \n");
                }
            }
        }
    }

    // fonction qui ferme toutes les frames
    public static void close() {
        for (Frame frame : JFrame.getFrames()) {
            frame.dispose();
        }
    }

    // fonction menu
    public static void Menu() {
        System.out.println("\nBonjour que voulez vous faire ?");
        System.out.println("    0- quitter le programme");
        System.out.println("    1- Graphique -> JButton");
        System.out.println("    2- Graphique -> BoxLayout");
        System.out.println("    3- Graphique -> Afficher carte");
    }

    // fonction boutton classique + fantaisie
    public static class Button {

        public static void main() {
            // Création de la fenêtre
            JFrame fenetre = new JFrame("Boutons");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(400, 150);

            // Création du conteneur principal
            JPanel panel = new JPanel(new FlowLayout());

            // Création d'un bouton classique
            JButton boutonClassique = new JButton("Bouton classique");
            panel.add(boutonClassique);


            // Upload une image pour le bouton
            ImageIcon icon = new ImageIcon("./src/Fichiers/TP3_2/dark.jpg");
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);

            // Création d'un bouton fantaisie
            JButton boutonFantaisie = new JButton("Bouton fantaisie", icon);
            boutonFantaisie.setBackground(Color.GRAY);
            Border line = new LineBorder(Color.BLACK);
            Border margin = new EmptyBorder(5, 15, 5, 15);
            Border compound = new CompoundBorder(line, margin);
            boutonFantaisie.setBorder(compound);
            panel.add(boutonFantaisie);

            // Ajout d'un écouteur d'événements aux boutons
            ActionListener listener = e -> {
                JButton bouton = (JButton) e.getSource();
                String nomBouton = bouton.getText();
                JOptionPane.showMessageDialog(fenetre, "Vous avez appuyé sur : " + nomBouton, "Information", JOptionPane.INFORMATION_MESSAGE);
            };
            boutonClassique.addActionListener(listener);
            boutonFantaisie.addActionListener(listener);

            // Ajout du conteneur principal à la fenêtre
            fenetre.add(panel);

            // Centrage de la fenêtre
            fenetre.setLocationRelativeTo(null);
            fenetre.setVisible(true);

            // Affichage de la fenêtre
            fenetre.setVisible(true);
        }
    }

    // fonction formulaire boutton
    public static class Formulaire {

        public static void main() {
            // Création de la fenêtre
            JFrame fenetre = new JFrame("Formulaire");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(350, 200);

            // Création du conteneur principal
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            // Création du champ de saisie du pseudo
            JPanel panelName = new JPanel();
            panelName.add(new JLabel("Nom :"));
            JTextField champPseudo = new JTextField(20);
            panelName.add(champPseudo);
            panel.add(panelName);

            // Création du champ de saisie du mot de passe
            JPanel panelMdp = new JPanel();
            panelMdp.add(new JLabel("Password :"));
            JPasswordField champMdp = new JPasswordField(20);
            panelMdp.add(champMdp);
            panel.add(panelMdp);

            // Création des boutons "Ok" et "Annuler"
            JPanel panelBoutons = new JPanel();
            panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));
            JButton boutonOk = new JButton("Ok");
            JButton boutonAnnuler = new JButton("Annuler");
            panelBoutons.add(Box.createHorizontalGlue());
            panelBoutons.add(boutonOk);
            panelBoutons.add(Box.createRigidArea(new Dimension(10, 0)));
            panelBoutons.add(boutonAnnuler);
            panelBoutons.add(Box.createHorizontalGlue());

            // Ajout d'un espace entre les champs de saisie et les boutons
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(panelBoutons);

            // Ajout d'un écouteur d'événements aux boutons
            ActionListener listener = e -> {

                String pseudo = champPseudo.getText();
                char[] mdp = champMdp.getPassword();

                StringBuilder pass = new StringBuilder();
                for (char c : mdp) {
                    pass.append(c);
                }

                JButton bouton = (JButton) e.getSource();
                String nomBouton = bouton.getText();
                JOptionPane.showMessageDialog(fenetre, "Vous avez appuyé sur : " + nomBouton + "\nnom : " + pseudo + "\npwd : " + pass, "Information", JOptionPane.INFORMATION_MESSAGE);
            };
            boutonOk.addActionListener(listener);
            boutonAnnuler.addActionListener(listener);

            // Centrage de la fenêtre
            fenetre.setLocationRelativeTo(null);
            fenetre.setVisible(true);

            // Ajout du conteneur principal à la fenêtre
            fenetre.add(panel);

            // Affichage de la fenêtre
            fenetre.setVisible(true);
        }
    }

    // fonction jeu de carte
    public static class Jeu {
        private static final String[] COULEURS = {"k", "s", "p", "l"};
        private static final String[] VALEURS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};

        public static void afficherCartes(JPanel panel) throws IOException {
            Random alea = new Random();

            // Supprime les éléments du JPanel actuel
            panel.removeAll();

            // Ajoute un espace entre chaque carte
            panel.add(Box.createRigidArea(new Dimension(5, 0)));

            // Génère 3 cartes aléatoires et affiche leurs images
            for (int i = 0; i < 3; i++) {
                String couleur = COULEURS[alea.nextInt(COULEURS.length)];
                String valeur = VALEURS[alea.nextInt(VALEURS.length)];
                String imageUrl = "https://www.improvemagic.com/wp-content/uploads/2020/11/" + couleur + valeur + ".png";
                BufferedImage image = ImageIO.read(new URL(imageUrl));

                // Ajoute l'image de la carte au JPanel
                panel.add(new JLabel(new ImageIcon(image)));

                // Ajoute un espace entre chaque carte
                panel.add(Box.createRigidArea(new Dimension(5, 0)));
            }

            // Met à jour le JPanel avec les nouvelles cartes
            panel.revalidate();
        }

        public static void main() throws IOException {
            // Crée un JFrame et un JPanel pour afficher les cartes
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            frame.add(panel);

            // Affiche les 3 premières cartes
            Jeu.afficherCartes(panel);

            // Crée un bouton "Tirer 3 nouvelles cartes"
            JButton bouton = new JButton("Tirer 3 nouvelles cartes");

            bouton.addActionListener(e -> {
                try {
                    // Affiche 3 nouvelles cartes au clic sur le bouton
                    Jeu.afficherCartes(panel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            // Ajoute le bouton en bas de la fenêtre
            frame.add(bouton, "South");

            // Affiche le JFrame
            frame.pack();
            frame.setVisible(true);
        }
    }

}
