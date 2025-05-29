// Classe représentant un compte bancaire simple
public class CompteBancaire {
    // Solde du compte, privé pour protéger les données
    private double solde;

    // Constructeur qui initialise le solde avec une valeur donnée
    public CompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    // Méthode pour déposer de l'argent sur le compte
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;  // On ajoute le montant au solde
            System.out.println("Déposé : " + montant + " €");
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    // Méthode pour retirer de l'argent, seulement si le solde est suffisant
    public void retirer(double montant) {
        if (montant > 0) {
            if (solde >= montant) {
                solde -= montant; // On retire le montant du solde
                System.out.println("Retiré : " + montant + " €");
            } else {
                System.out.println("Solde insuffisant pour retirer " + montant + " €");
            }
        } else {
            System.out.println("Le montant à retirer doit être positif.");
        }
    }

    // Getter pour obtenir le solde actuel
    public double getSolde() {
        return solde;
    }
}
