package membres;

import java.sql.SQLException;
import java.util.List;

public interface MembreDao {
    
    void ajouterMembre(Membre membre) throws SQLException;
    
    Membre getMembreById(int id) throws SQLException;
    
    Membre getMembreByEmail(String email) throws SQLException;
    
    List<Membre> getAllMembres() throws SQLException;
    
    void modifierMembre(Membre membre) throws SQLException;
    
    void supprimerMembre(int id) throws SQLException;
    
}
