// Déclaration de la classe Personne
public class Personne {
    // Attributs privés pour protéger les données (encapsulation)
    private String nom;
    private String prenom;
    private int age;

    // Constructeur : méthode spéciale pour créer un objet Personne avec ses infos
    public Personne(String nom, String prenom, int age) {
        this.nom = nom;       // 'this.nom' = attribut de l'objet, 'nom' = paramètre
        this.prenom = prenom;
        this.age = age;
    }

    // Méthode pour présenter la personne en affichant une phrase
    public void sePresenter() {
        System.out.println("Bonjour, je m'appelle " + prenom + " " + nom + " et j'ai " + age + " ans.");
    }

    // Getter pour lire le nom
    public String getNom() {
        return nom;
    }

    // Setter pour modifier le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour lire le prénom
    public String getPrenom() {
        return prenom;
    }

    // Setter pour modifier le prénom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter pour lire l'âge
    public int getAge() {
        return age;
    }

    // Setter pour modifier l'âge
    public void setAge(int age) {
        this.age = age;
    }
}
