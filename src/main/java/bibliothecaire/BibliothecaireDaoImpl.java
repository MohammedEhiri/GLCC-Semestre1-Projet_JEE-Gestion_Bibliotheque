package bibliothecaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliothecaireDaoImpl implements BibliothecaireDao {

	Connection connexion;
	


    public BibliothecaireDaoImpl() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");  
    		connexion =DriverManager.getConnection(  "jdbc:mysql://localhost:3306/bibliotheque","root","root");  ;
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	System.out.println("bien fait ");
    	}
    		
    

    @Override
    public void add(Bibliothecaire bibliothecaire) throws SQLException {
        String query = "INSERT INTO bibliothecaire (nom, prenom,email, username, mot_de_passe) VALUES (?,?, ?, ?, ?)";
        PreparedStatement statement = connexion.prepareStatement(query);
        statement.setString(1, bibliothecaire.getNom());
        statement.setString(2, bibliothecaire.getPrenom());
        statement.setString(3, bibliothecaire.getEmail());
        statement.setString(4, bibliothecaire.getUsername());
        statement.setString(5, bibliothecaire.getPassword());
        statement.executeUpdate();
    	System.out.println("bien add ");

    }

    @Override
    public void update(Bibliothecaire bibliothecaire) throws SQLException {
        String query = "UPDATE bibliothecaire SET nom=?, prenom=?,email=?, username=?, mot_de_passe=? WHERE id=?";
        PreparedStatement statement = connexion.prepareStatement(query);
        statement.setString(1, bibliothecaire.getNom());
        statement.setString(2, bibliothecaire.getPrenom());
        statement.setString(3, bibliothecaire.getEmail());
        statement.setString(4, bibliothecaire.getUsername());
        statement.setString(5, bibliothecaire.getPassword());
        statement.setInt(6, bibliothecaire.getId());
        statement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM bibliothecaire WHERE id=?";
        PreparedStatement statement = connexion.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public Bibliothecaire getById(int id) throws SQLException {
        String query = "SELECT * FROM bibliothecaire WHERE id=?";
        PreparedStatement statement = connexion.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Bibliothecaire bibliothecaire = null;
        if (resultSet.next()) {
            bibliothecaire = new Bibliothecaire();
            bibliothecaire.setId(resultSet.getInt("id"));
            bibliothecaire.setNom(resultSet.getString("nom"));
            bibliothecaire.setPrenom(resultSet.getString("prenom"));
            bibliothecaire.setPrenom(resultSet.getString("email"));
            bibliothecaire.setUsername(resultSet.getString("username"));
            bibliothecaire.setPassword(resultSet.getString("mot_de_passe"));
        }
        return bibliothecaire;
    }

    @Override
    public List<Bibliothecaire> getAll() throws SQLException {
        String query = "SELECT * FROM bibliothecaire";
        PreparedStatement statement = connexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Bibliothecaire> bibliothecaires = new ArrayList<>();
        while (resultSet.next()) {
            Bibliothecaire bibliothecaire = new Bibliothecaire();
            bibliothecaire.setId(resultSet.getInt("id"));
            bibliothecaire.setNom(resultSet.getString("nom"));
            bibliothecaire.setPrenom(resultSet.getString("prenom"));
            bibliothecaire.setPrenom(resultSet.getString("email"));
            bibliothecaire.setUsername(resultSet.getString("username"));
            bibliothecaire.setPassword(resultSet.getString("mot_de_passe"));
            bibliothecaires.add(bibliothecaire);
        }
        return bibliothecaires;
    }

	@Override
	public Bibliothecaire getByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Bibliothecaire getByUsernameAndPassword(String username, String password) throws SQLException {
	    String query = "SELECT * FROM bibliothecaire WHERE username = ? AND mot_de_passe = ?";
	    PreparedStatement statement = connexion.prepareStatement(query);
	    statement.setString(1, username);
	    statement.setString(2, password);
	    ResultSet resultSet = statement.executeQuery();

	    Bibliothecaire bibliothecaire = null;
	    if (resultSet.next()) {
	        bibliothecaire = new Bibliothecaire();
	        bibliothecaire.setId(resultSet.getInt("id"));
	        bibliothecaire.setNom(resultSet.getString("nom"));
	        bibliothecaire.setPrenom(resultSet.getString("prenom"));
	        bibliothecaire.setPrenom(resultSet.getString("email"));
	        bibliothecaire.setUsername(resultSet.getString("username"));
	        bibliothecaire.setPassword(resultSet.getString("mot_de_passe"));
	    }

	    resultSet.close();
	    statement.close();
	    connexion.close();

	    return bibliothecaire;
	}

}
