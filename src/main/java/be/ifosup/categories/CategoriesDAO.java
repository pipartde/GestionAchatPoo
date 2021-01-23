package be.ifosup.categories;

import java.sql.SQLException;
import java.util.List;

public interface CategoriesDAO {

    void ajouter(Categories categories);
    void supprimer(Long catId);
    void modifier(Long catId, String catNom);
    Categories lire(Long catId) throws SQLException;

    List<Categories> liste() throws SQLException;
}
