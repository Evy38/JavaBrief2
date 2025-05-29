// Classe Chat qui hérite d'Animal
public class Chat extends Animal {
    // Redéfinition de la méthode crier pour un chat
    @Override
    public void crier() {
        System.out.println("Le chat miaule : Miaou !");
    }
}
