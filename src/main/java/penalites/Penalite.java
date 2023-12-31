package penalites;

import java.util.Date;

public class Penalite {
    private int id;
    private int idEmprunt;
    private double montant;
    private java.util.Date dateDebut;
    private java.util.Date dateFin;
	public Penalite(int id, int idEmprunt, double montant, Date dateDebut, Date dateFin) {
		super();
		this.id = id;
		this.idEmprunt = idEmprunt;
		this.montant = montant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public Penalite(int idEmprunt, double montant, Date dateDebut, Date dateFin) {
		super();
		this.idEmprunt = idEmprunt;
		this.montant = montant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEmprunt() {
		return idEmprunt;
	}
	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public java.util.Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(java.util.Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public java.util.Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(java.util.Date dateFin) {
		this.dateFin = dateFin;
	}
    

	
    
    
}