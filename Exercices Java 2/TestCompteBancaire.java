// Classe de test pour la classe CompteBancaire
public class TestCompteBancaire {
    public static void main(String[] args) {
        // Création d'un compte avec un solde initial de 100 €
        CompteBancaire compte = new CompteBancaire(100);

        // Déposer 50 €
        compte.deposer(50);

        // Retirer 30 €
        compte.retirer(30);

        // Essayer de retirer 150 € (plus que le solde)
        compte.retirer(150);

        // Afficher le solde final
        System.out.println("Solde final : " + compte.getSolde() + " €");
    }
}
