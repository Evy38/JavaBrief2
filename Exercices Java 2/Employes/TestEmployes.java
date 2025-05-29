public class TestEmployes {
    public static void main(String[] args) {
        // Création d'un salarié et d'un freelance
        Employe salarie = new Salarie("Marie", 2500.0);
        Employe freelance = new Freelance("Paul", 120, 20.0);

        // Affichage du salaire de chaque employé
        System.out.println(salarie.getNom() + " gagne " + salarie.calculerSalaire() + " €");
        System.out.println(freelance.getNom() + " gagne " + freelance.calculerSalaire() + " €");
    }
}
