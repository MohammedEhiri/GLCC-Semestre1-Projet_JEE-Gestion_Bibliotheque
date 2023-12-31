package ouvrages;

public class Ouvrage {
    private int id;
    private String titre;
    private String auteur;
    private String description;
    private int nbExemplaires;
    

    public Ouvrage(int id, String titre, String auteur, String description, int nbExemplaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.nbExemplaires = nbExemplaires;
    }
    public Ouvrage( String titre, String auteur, String description, int nbExemplaires) {
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.nbExemplaires = nbExemplaires;
    }
    public Ouvrage() {
        
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbExemplaires() {
		return nbExemplaires;
	}
	public void setNbExemplaires(int nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
	}

    
}
