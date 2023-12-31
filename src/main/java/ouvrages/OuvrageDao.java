package ouvrages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OuvrageDao {
    private Connection connection;

    public OuvrageDao() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");  
    		connection =DriverManager.getConnection(  "jdbc:mysql://localhost:3306/bibliotheque","root","root");  ;
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	System.out.println("bien fait ");
    }

    public void ajouterOuvrage(Ouvrage ouvrage) throws SQLException {
        String query = "INSERT INTO ouvrage (titre, auteur, description, nb_exemplaires) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, ouvrage.getTitre());
            statement.setString(2, ouvrage.getAuteur());
            statement.setString(3, ouvrage.getDescription());
            statement.setInt(4, ouvrage.getNbExemplaires());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                ouvrage.setId(generatedKeys.getInt(1));
            }
        }
    }

    public Ouvrage findById(int id) throws SQLException {
        String query = "SELECT * FROM ouvrage WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Ouvrage ouvrage = new Ouvrage();
                    ouvrage.setId(id);
                    ouvrage.setTitre(resultSet.getString("titre"));
                    ouvrage.setAuteur(resultSet.getString("auteur"));
                    ouvrage.setDescription(resultSet.getString("description"));
                    ouvrage.setNbExemplaires(resultSet.getInt("nb_exemplaires"));

                    return ouvrage;
                }
            }
        }

        return null;
    }
    
    public Ouvrage findByTitle(String titre) throws SQLException {
        String query = "SELECT * FROM ouvrage WHERE titre = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titre);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Ouvrage ouvrage = new Ouvrage();
                    ouvrage.setTitre(resultSet.getString("titre"));
                    ouvrage.setAuteur(resultSet.getString("auteur"));
                    ouvrage.setDescription(resultSet.getString("description"));
                    ouvrage.setNbExemplaires(resultSet.getInt("nb_exemplaires"));

                    return ouvrage;
                }
            }
        }

        return null;
    }

    public List<Ouvrage> findAll() throws SQLException {
        String query = "SELECT * FROM ouvrage";
        List<Ouvrage> ouvrages = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Ouvrage ouvrage = new Ouvrage();
                ouvrage.setId(resultSet.getInt("id"));
                ouvrage.setTitre(resultSet.getString("titre"));
                ouvrage.setAuteur(resultSet.getString("auteur"));
                ouvrage.setDescription(resultSet.getString("description"));
                ouvrage.setNbExemplaires(resultSet.getInt("nb_exemplaires"));

                ouvrages.add(ouvrage);
            }
        }

        return ouvrages;
    }

    public void update(Ouvrage ouvrage) throws SQLException {
        String query = "UPDATE ouvrage SET titre = ?, auteur = ?, description = ?, nb_exemplaires = ? WHERE titre = ? ";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ouvrage.getTitre());
            statement.setString(2, ouvrage.getAuteur());
            statement.setString(3, ouvrage.getDescription());
            statement.setInt(4, ouvrage.getNbExemplaires());
            statement.setString(5, ouvrage.getTitre());

            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM ouvrage WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public void delete(String titre) throws SQLException {
        String query = "DELETE FROM ouvrage WHERE titre = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.executeUpdate();
        }
    }

		public List<Ouvrage> findAllNouveaute() throws SQLException {
	        String query = "SELECT * FROM ouvrage ORDER BY id DESC";
	        List<Ouvrage> ouvrages = new ArrayList<>();

	        try (PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                Ouvrage ouvrage = new Ouvrage();
	                ouvrage.setId(resultSet.getInt("id"));
	                ouvrage.setTitre(resultSet.getString("titre"));
	                ouvrage.setAuteur(resultSet.getString("auteur"));
	                ouvrage.setDescription(resultSet.getString("description"));
	                ouvrage.setNbExemplaires(resultSet.getInt("nb_exemplaires"));

	                ouvrages.add(ouvrage);
	            }
	        }
			return ouvrages;
		}}
