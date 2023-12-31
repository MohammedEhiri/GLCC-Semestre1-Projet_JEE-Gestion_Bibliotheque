package emprunts;

import java.sql.SQLException;
import java.util.List;

public interface EmpruntDao {
    void ajouterEmprunt(Emprunt emprunt) throws SQLException;
    Emprunt getEmpruntById(int id) throws SQLException;
    List<Emprunt> getEmpruntsEnCours() throws SQLException;
    void modifierEmprunt(Emprunt emprunt) throws SQLException;
    void supprimerEmprunt(int id) throws SQLException;
	Emprunt getEmpruntByid_membreANDidOuvrage(int id_membre, int idOuvrage) throws SQLException;
}

