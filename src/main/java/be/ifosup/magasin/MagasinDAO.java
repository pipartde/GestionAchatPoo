package be.ifosup.magasin;

import java.sql.SQLException;
import java.util.List;


public interface MagasinDAO {

    void ajouter(Magasin magasin);
    void supprimer(Long magId);
    void modifier(Long magId, String magNom);
    Magasin recuperer(Long magId) throws SQLException;
    List<Magasin> liste() throws SQLException;

}