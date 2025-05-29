// Classe de test pour vérifier le comportement des animaux
public class TestAnimaux {
    public static void main(String[] args) {
        // Création d'un tableau d'animaux (polymorphisme)
        Animal[] animaux = { new Chien(), new Chat() };

        // Parcours du tableau et appel de crier()
        for (Animal a : animaux) {
            a.crier();  // Appelle la méthode adaptée à chaque animal
        }
    }
}
