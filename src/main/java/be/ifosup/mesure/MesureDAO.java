package be.ifosup.mesure;

import java.sql.SQLException;
import java.util.List;

public interface MesureDAO {
    void ajouter (Mesure mesure) throws SQLException;

    void supprimer (Long mesId) throws SQLException;

    void modifier (Mesure mesure);

    List<Mesure> liste() throws SQLException;
}
