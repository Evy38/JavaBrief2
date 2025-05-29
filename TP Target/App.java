import javax.swing.*; // interface graphique (fenêtres, boutons, etc.)

// Classe principale qui lance l'application
public class App { 
    public static void main(String[] args) { 

        // SwingUtilities.invokeLater lance l'exécution du code dans le thread spécial d'interface graphique (thread EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("T.A.R.G.E.T."); 
            // Création d'une fenêtre avec titre "T.A.R.G.E.T."

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            // Permet de fermer l'application quand on clique sur la croix de la fenêtre

            frame.setSize(600, 600); 
            // Définit la taille de la fenêtre (600x600 pixels)

            frame.setResizable(false); 
            // Empêche l'utilisateur de redimensionner la fenêtre

            GamePanel gamePanel = new GamePanel(); 
            // Création d'une instance de GamePanel (notre panneau de jeu)

            frame.add(gamePanel); 
            // Ajoute ce panneau à la fenêtre (pour l'afficher)

            frame.setVisible(true); 
            // Rend la fenêtre visible à l'écran
        });
    }
}
