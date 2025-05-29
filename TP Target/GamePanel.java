import java.awt.*; // Import des classes graphiques (couleurs, formes, etc.)
import java.util.ArrayList; // Import pour la liste dynamique de points (trajectoire)
import java.util.List; // Interface Liste
import java.util.Random; // Import pour générer des nombres aléatoires
import javax.swing.*; // Import des composants Swing (JPanel, JButton, etc.)

public class GamePanel extends JPanel {

    // Attributs privés (encapsulation pour protéger les données)
    private JTextField angleField;          // Zone de texte pour saisir l'angle de tir
    private JTextField vitesseField;        // Zone de texte pour saisir la vitesse initiale
    private JButton nouvellePositionButton; // Bouton pour repositionner canon et cible
    private JButton tirerButton;             // Bouton pour lancer le tir

    private final Random random = new Random();  // Pour générer des nombres aléatoires

    private int angle;           // Angle de tir (0 à 90 degrés)
    private int vitesse;         // Vitesse initiale (10 à 100)

    private int wind;            // Vent horizontal aléatoire entre -5 et +5
    private final double gravity = 0.5;  // Gravité constante qui influence la trajectoire

    private double canonX, canonY;     // Coordonnées du canon (carré bleu)
    private double cibleX, cibleY;     // Coordonnées de la cible (carré rouge)

    private double projX, projY;       // Coordonnées du projectile (point)
    private double vx, vy;             // Vitesse du projectile selon X et Y

    private int score = 0;             // Score du joueur

    private List<Point> trajectoire;   // Liste des points où est passé le projectile (trace)

    private Timer timer;               // Timer pour animer le mouvement du projectile

    // Constructeur : appelé quand on crée un GamePanel
    public GamePanel() {
        setLayout(null);  // On utilise pas un layout manager, on positionne manuellement

        // Initialisation des champs de saisie et boutons
        angleField = new JTextField();
        angleField.setBounds(10, 10, 100, 25);  // position et taille (x, y, largeur, hauteur)
        add(angleField);

        vitesseField = new JTextField();
        vitesseField.setBounds(120, 10, 100, 25);
        add(vitesseField);

        nouvellePositionButton = new JButton("Nouvelle position");
        nouvellePositionButton.setBounds(230, 10, 150, 25);
        add(nouvellePositionButton);

        tirerButton = new JButton("Tirer");
        tirerButton.setBounds(390, 10, 100, 25);
        add(tirerButton);

        trajectoire = new ArrayList<>(); // liste vide pour la trace du projectile

        // Place canon et cible aléatoirement au début
        placeCannonAndTarget();

        // Configure le timer : toutes les 50ms, updateProjectile() est appelé
        timer = new Timer(50, _ -> updateProjectile());
        timer.start();

        // Action quand on clique sur "Nouvelle position"
        nouvellePositionButton.addActionListener(_ -> {
            placeCannonAndTarget();
            trajectoire.clear();  // efface la trace
            repaint();            // demande de redessiner le JPanel
        });

        // Action quand on clique sur "Tirer"
        tirerButton.addActionListener(_ -> startShooting());
    }

    // Place aléatoirement le canon et la cible dans leurs zones respectives
    private void placeCannonAndTarget() {
        // Canon : carré bleu positionné à gauche (x entre 20 et 100, y entre 100 et 500)
        canonX = 20 + random.nextInt(81);   // 20 à 100 inclus
        canonY = 100 + random.nextInt(401); // 100 à 500 inclus

        // Cible : carré rouge positionné à droite (x entre 400 et 560, y entre 100 et 500)
        cibleX = 400 + random.nextInt(161); // 400 à 560 inclus
        cibleY = 100 + random.nextInt(401); // 100 à 500 inclus

        // Projectile initialisé sur le canon (lancé depuis le canon)
        projX = canonX;
        projY = canonY;
    }

    // Récupère les valeurs saisies, valide et calcule les vitesses initiales
    private void startShooting() {
        try {
            angle = Integer.parseInt(angleField.getText());   // convertit texte en int
            vitesse = Integer.parseInt(vitesseField.getText());

            // Vérifie que l'angle est entre 0 et 90
            if (angle < 0 || angle > 90) {
                JOptionPane.showMessageDialog(this, "Angle doit être entre 0 et 90");
                return;
            }

            // Vérifie que la vitesse est entre 10 et 100
            if (vitesse < 10 || vitesse > 100) {
                JOptionPane.showMessageDialog(this, "Vitesse doit être entre 10 et 100");
                return;
            }

            // Génère un vent horizontal aléatoire entre -5 et +5
            wind = -5 + random.nextInt(11); // -5 à 5 inclus

            // Initialise la position du projectile au canon
            projX = canonX;
            projY = canonY;

            // Convertit l'angle en radians pour les calculs trigonométriques
            double radians = Math.toRadians(angle);

            // Calcule la vitesse initiale selon x et y (divisé par 2 pour la simulation)
            vx = Math.cos(radians) * vitesse / 2;
            vy = -Math.sin(radians) * vitesse / 2;

            trajectoire.clear();  // vide la trace avant le tir
            repaint();            // redessine

        } catch (NumberFormatException e) {
            // Si le texte n'est pas un nombre valide
            JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides");
        }
    }

    // Méthode appelée par le Timer pour mettre à jour la position du projectile
    private void updateProjectile() {
        // Si le projectile n'est pas encore lancé (vitesse = 0), ne fait rien
        if (vx == 0 && vy == 0) return;

        // Met à jour la position du projectile en fonction de la vitesse
        projX += vx;

        // Le vent modifie la vitesse horizontale légèrement à chaque itération
        vx += wind / 10.0;

        projY += vy;

        // La gravité augmente la vitesse verticale (vers le bas)
        vy += gravity;

        // Ajoute la nouvelle position à la trajectoire (pour la trace)
        trajectoire.add(new Point((int) projX, (int) projY));

        // Teste si le projectile touche la cible
        if (projX >= cibleX && projX <= cibleX + 20 && projY >= cibleY && projY <= cibleY + 20) {
            score++;        // augmente le score
            JOptionPane.showMessageDialog(this, "Bravo ! Cible touchée. Score : " + score);
            // Stoppe le projectile
            vx = 0;
            vy = 0;
        }

        // Teste si le projectile sort de l'écran (largeur 600, hauteur 600)
        if (projX < 0 || projX > 600 || projY > 600) {
            // Arrête le mouvement
            vx = 0;
            vy = 0;
        }

        repaint(); // redessine pour afficher la nouvelle position et la trace
    }

    // Dessine le jeu à l'écran : canon, cible, projectile, trace, score
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fond blanc
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dessine le canon (carré bleu 20x20)
        g.setColor(Color.BLUE);
        g.fillRect((int) canonX, (int) canonY, 20, 20);

        // Dessine la cible (carré rouge 20x20)
        g.setColor(Color.RED);
        g.fillRect((int) cibleX, (int) cibleY, 20, 20);

        // Dessine la trajectoire (petits points noirs)
        g.setColor(Color.BLACK);
        for (Point p : trajectoire) {
            g.fillOval(p.x, p.y, 4, 4);  // petit cercle de diamètre 4
        }

        // Dessine le projectile (point vert)
        g.setColor(Color.GREEN);
        g.fillOval((int) projX, (int) projY, 10, 10);

        // Affiche le score en haut à droite
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score : " + score, getWidth() - 100, 30);
    }
}
