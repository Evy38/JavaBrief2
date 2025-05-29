// Classe de test pour vérifier le fonctionnement de la classe Personne
public class TestPersonne {
    // Méthode principale, point d'entrée du programme
    public static void main(String[] args) {
        // Création d'une instance de Personne avec les infos d'Alice Durand, 30 ans
        Personne p = new Personne("Alice", "Durand", 30);

        // Appel de la méthode pour afficher la présentation dans la console
        p.sePresenter();
    }
}
