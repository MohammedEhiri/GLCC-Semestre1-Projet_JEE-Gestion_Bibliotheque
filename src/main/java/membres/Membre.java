package membres;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String type;
    private String password;

    public Membre(int id, String nom, String prenom, String email, String type, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.type = type;
        this.password = password;
    }
    public Membre( String nom, String prenom, String email, String type, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.type = type;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
