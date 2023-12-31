package emprunts;

public class Emprunt {
    private int id;
    private int idMembre;
    private int idOuvrage;
    private java.util.Date dateEmprunt;
    private java.util.Date dateRetour;
    
	public Emprunt(int id, int idMembre, int idOuvrage, java.util.Date dateEmprunt, java.util.Date dateRetour) {
		super();
		this.id = id;
		this.idMembre = idMembre;
		this.idOuvrage = idOuvrage;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		
		
	}
	public Emprunt(int idMembre, int idOuvrage, java.util.Date dateEmprunt, java.util.Date dateRetour) {
		super();
		this.idMembre = idMembre;
		this.idOuvrage = idOuvrage;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMembre() {
		return idMembre;
	}
	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}
	public int getIdOuvrage() {
		return idOuvrage;
	}
	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}
	public java.util.Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(java.util.Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public java.util.Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(java.util.Date dateRetour) {
		this.dateRetour = dateRetour;
	}

    
}

