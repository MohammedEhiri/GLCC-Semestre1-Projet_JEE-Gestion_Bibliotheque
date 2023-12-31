package emprunts;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpruntDaoImpl implements EmpruntDao {

	private Connection conn;

    public EmpruntDaoImpl() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");  
    		conn =DriverManager.getConnection(  "jdbc:mysql://localhost:3306/bibliotheque","root","root");  ;
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	System.out.println("bien fait ");
    }

   
    @Override
    public void ajouterEmprunt(Emprunt emprunt) throws SQLException {
    	
    	
        String query = "INSERT INTO emprunt (id_membre, id_ouvrage, date_emprunt, date_retour) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, emprunt.getIdMembre());
        ps.setInt(2, emprunt.getIdOuvrage());
        ps.setObject(3, emprunt.getDateEmprunt());
        ps.setObject(4, emprunt.getDateRetour());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Emprunt getEmpruntById(int id) throws SQLException {
        String query = "SELECT * FROM emprunt WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Emprunt emprunt = null;
        if (rs.next()) {
            int idMembre = rs.getInt("id_membre");
            int idOuvrage = rs.getInt("id_ouvrage");
            Date dateEmprunt = rs.getDate("date_emprunt");
            Date dateRetour = rs.getDate("date_retour");
            emprunt = new Emprunt(id, idMembre, idOuvrage, dateEmprunt, dateRetour);
        }
        rs.close();
        ps.close();
        return emprunt;
    }
    @Override
    public Emprunt getEmpruntByid_membreANDidOuvrage(int id,int idOuvrage) throws SQLException {
        String query = "SELECT * FROM emprunt WHERE id_membre = ? AND id_ouvrage = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.setInt(2, idOuvrage);

        ResultSet rs = ps.executeQuery();
        Emprunt emprunt = null;
        if (rs.next()) {
            int idMembre = rs.getInt("id_membre");
            int id_Ouvrage = rs.getInt("id_ouvrage");
            Date dateEmprunt = rs.getDate("date_emprunt");
            Date dateRetour = rs.getDate("date_retour");
            emprunt = new Emprunt(idMembre, id_Ouvrage, dateEmprunt, dateRetour);
        }
        rs.close();
        ps.close();
        return emprunt;
    }

    @Override
	public List<Emprunt> getEmpruntsEnCours() throws SQLException{
        String query = "SELECT * FROM emprunt";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Emprunt> emprunt = new ArrayList<>();
        while (rs.next()) {
            int idEmprunt = rs.getInt("id");
            int idMembre = rs.getInt("id_membre");
            int idOuvrage = rs.getInt("id_ouvrage");
            Date dateEmprunt = rs.getDate("date_emprunt");
            Date dateRetour = rs.getDate("date_retour");
            emprunt.add(new Emprunt(idEmprunt, idMembre, idOuvrage, dateEmprunt, dateRetour));
        }
        rs.close();
        st.close();
        return emprunt;
    }

    @Override
    public void modifierEmprunt(Emprunt emprunt) throws SQLException {
        String query = "UPDATE emprunt SET id_membre = ?, id_ouvrage = ?, date_emprunt = ?, date_retour = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, emprunt.getIdMembre());
        ps.setInt(2, emprunt.getIdOuvrage());
        ps.setObject(3, emprunt.getDateEmprunt());
        ps.setObject(4, emprunt.getDateRetour());
        ps.setInt(5, emprunt.getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void supprimerEmprunt(int id) throws SQLException {
        
    	PreparedStatement ps = conn.prepareStatement("DELETE FROM emprunt WHERE id = ?");
    	ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
            
        }
    }

