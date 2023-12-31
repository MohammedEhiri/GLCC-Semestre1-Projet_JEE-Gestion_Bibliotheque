package penalites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PenaliteDaoImpl implements PenaliteDao {
    
    private Connection connexion;
    
    public PenaliteDaoImpl() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");  
    		connexion =DriverManager.getConnection(  "jdbc:mysql://localhost:3306/bibliotheque","root","root");
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	System.out.println("bien fait ");
    }

    @Override
    public void ajouterPenalite(Penalite penalite) {
        String query = "INSERT INTO penalite (id_emprunt, montant, dateDebut, dateFin) VALUES (?, ?,?, ?)";
        try (PreparedStatement statement = connexion.prepareStatement(query)) {
            statement.setInt(1, penalite.getIdEmprunt());
            statement.setDouble(2, penalite.getMontant());
            
            statement.setObject(3, penalite.getDateDebut());
            statement.setObject(4, penalite.getDateFin());

            statement.executeUpdate();
        	System.out.println("bien ajoutée ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Penalite getPenalite(int id) {
        String query = "SELECT * FROM penalite WHERE id = ?";
        try (PreparedStatement statement = connexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idEmprunt = resultSet.getInt("id_emprunt");
                double montant = resultSet.getDouble("montant");
                Date dateDebut= resultSet.getDate("dateDebut");
                Date dateFin= resultSet.getDate("dateFin");

                return new Penalite(id, idEmprunt, montant,dateDebut,dateFin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Penalite> getAllPenalites() {
        List<Penalite> penalite = new ArrayList<>();
        String query = "SELECT * FROM penalite";
        try (PreparedStatement statement = connexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idEmprunt = resultSet.getInt("id_emprunt");
                double montant = resultSet.getDouble("montant");
                Date dateDebut= resultSet.getDate("dateDebut");
                Date dateFin= resultSet.getDate("dateFin");

            
                penalite.add(new  Penalite(id, idEmprunt, montant,dateDebut,dateFin));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penalite;
    }

    @Override
    public List<Penalite> getPenalitesByEmprunt(int idEmprunt) {
        List<Penalite> penalite = new ArrayList<>();
        String query = "SELECT * FROM penalite WHERE id_emprunt = ?";
        try (PreparedStatement statement = connexion.prepareStatement(query)) {
            statement.setInt(1, idEmprunt);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double montant = resultSet.getDouble("montant");
                Date dateDebut= resultSet.getDate("dateDebut");
                Date dateFin= resultSet.getDate("dateFin");

                penalite.add(new Penalite(id, idEmprunt, montant,dateDebut,dateFin));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penalite;
    }

    @Override
    public void supprimerPenalite(int id) {
        String query = "DELETE FROM penalite WHERE id = ?";
        try (PreparedStatement statement = connexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

