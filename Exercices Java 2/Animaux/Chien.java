// Classe Chien qui hérite d'Animal
public class Chien extends Animal {
    // Redéfinition de la méthode crier pour un chien
    @Override
    public void crier() {
        System.out.println("Le chien aboie : Ouaf ouaf !");
    }
}
