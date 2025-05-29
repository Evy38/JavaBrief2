// Classe Freelance qui hérite d'Employe
public class Freelance extends Employe {
    private int heures;
    private double tarifHoraire;

    // Constructeur initialisant nom, nombre d'heures travaillées et tarif horaire
    public Freelance(String nom, int heures, double tarifHoraire) {
        super(nom);  // Appel du constructeur de la classe mère
        this.heures = heures;
        this.tarifHoraire = tarifHoraire;
    }

    // Implémentation de la méthode calculerSalaire
    @Override
    public double calculerSalaire() {
        return heures * tarifHoraire;
    }
}
