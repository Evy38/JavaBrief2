// Classe abstraite représentant un employé
public abstract class Employe {
    protected String nom;

    // Constructeur pour initialiser le nom de l'employé
    public Employe(String nom) {
        this.nom = nom;
    }

    // Méthode abstraite à implémenter dans les classes filles
    public abstract double calculerSalaire();

    // Getter pour récupérer le nom
    public String getNom() {
        return nom;
    }
}
