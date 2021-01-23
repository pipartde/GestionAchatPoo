package be.ifosup.mesure;

import be.ifosup.magasin.Magasin;

import java.sql.SQLException;
import java.util.List;

public interface MesureDAO {
    void ajouter (Mesure mesure) throws SQLException;

    void supprimer (Long mesId) throws SQLException;

    void modifier(Long mesId, String mesNom) throws SQLException;

    List<Mesure> liste() throws SQLException;

    Mesure recuperer(Long mesId) throws SQLException;
}
