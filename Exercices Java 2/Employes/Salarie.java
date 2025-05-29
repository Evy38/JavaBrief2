// Classe Salarié qui hérite d'Employe
public class Salarie extends Employe {
    private double salaireMensuel;

    // Constructeur initialisant nom et salaire mensuel
    public Salarie(String nom, double salaireMensuel) {
        super(nom);  // Appel du constructeur de la classe mère
        this.salaireMensuel = salaireMensuel;
    }

    // Implémentation de la méthode calculerSalaire
    @Override
    public double calculerSalaire() {
        return salaireMensuel;
    }
}
