package bibliothecaire;

import java.sql.SQLException;
import java.util.List;

public interface BibliothecaireDao {
    public void add(Bibliothecaire bibliothecaire) throws SQLException;
    public void update(Bibliothecaire bibliothecaire) throws SQLException;
    public void delete(int id) throws SQLException;
    public Bibliothecaire getById(int id) throws SQLException;
    public Bibliothecaire getByUsername(String username) throws SQLException;
    public List<Bibliothecaire> getAll() throws SQLException;
	public Bibliothecaire getByUsernameAndPassword(String username, String password) throws SQLException;

}

