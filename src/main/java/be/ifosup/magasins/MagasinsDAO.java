package be.ifosup.magasins;

import java.sql.SQLException;
import java.util.List;


public interface MagasinsDAO {

    void ajouter(Magasins magasins);
    void supprimer(Long id);
    void modifier(Long id);
    List<Magasins> liste() throws SQLException;

}