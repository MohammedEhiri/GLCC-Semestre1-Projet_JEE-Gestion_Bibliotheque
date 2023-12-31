package penalites;

import java.util.List;

public interface PenaliteDao {
    void ajouterPenalite(Penalite penalite);
    Penalite getPenalite(int id);
    List<Penalite> getAllPenalites();
    List<Penalite> getPenalitesByEmprunt(int idEmprunt);
    void supprimerPenalite(int id);
}

