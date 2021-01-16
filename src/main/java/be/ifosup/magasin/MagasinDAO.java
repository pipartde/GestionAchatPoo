package be.ifosup.magasin;

import java.sql.SQLException;
import java.util.List;


public interface MagasinDAO {

    void ajouter(Magasin magasin);
    void supprimer(Long id);
    void modifier(Long id);
    List<Magasin> liste() throws SQLException;

}