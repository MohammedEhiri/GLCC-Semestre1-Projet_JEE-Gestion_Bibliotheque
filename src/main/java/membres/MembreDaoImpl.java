package membres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {
    private Connection connexion;

    public MembreDaoImpl() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");  
    		connexion =DriverManager.getConnection(  "jdbc:mysql://localhost:3306/bibliotheque","root","root");  ;
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	System.out.println("bien fait ");
    	}
    

    @Override
    public void ajouterMembre(Membre membre) throws SQLException {
        String sql = "INSERT INTO membres(nom, prenom, email, type, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, membre.getNom());
        statement.setString(2, membre.getPrenom());
        statement.setString(3, membre.getEmail());
        statement.setString(4, membre.getType());
        statement.setString(5, membre.getPassword());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            membre.setId(rs.getInt(1));
        }
        
        rs.close();
        statement.close();
    }

    @Override
    public Membre getMembreById(int id) throws SQLException {
        String sql = "SELECT * FROM membres WHERE id = ?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Membre membre = null;
        if (rs.next()) {
            membre = new Membre(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("email"), rs.getString("type"), rs.getString("password"));
        }
        rs.close();
        statement.close();
        return membre;
    }

    @Override
    public Membre getMembreByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM membres WHERE email = ?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        Membre membre = null;
        if (rs.next()) {
            membre = new Membre(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("email"), rs.getString("type"), rs.getString("password"));
        }
        rs.close();
        statement.close();
        return membre;
    }

    @Override
    public List<Membre> getAllMembres() throws SQLException {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM membres";
        PreparedStatement statement = connexion.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Membre membre = new Membre(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("email"), rs.getString("type"), rs.getString("password"));
            membres.add(membre);
        }
        rs.close();
        statement.close();
        return membres;
    }

    @Override
    public void modifierMembre(Membre membre) throws SQLException {
        String sql = "UPDATE membres SET nom = ?, prenom = ?, email = ?, type = ?, password = ? WHERE id = ?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, membre.getNom());
        statement.setString(2, membre.getPrenom());
        statement.setString(3, membre.getEmail());
        statement.setString(4, membre.getType());
        statement.setString(5, membre.getPassword());
        statement.setInt(6, membre.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void supprimerMembre(int id) throws SQLException {
        String sql = "DELETE FROM membres WHERE id = ?";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }
    
}
       
