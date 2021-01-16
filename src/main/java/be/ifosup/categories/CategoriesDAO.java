package be.ifosup.categories;

import java.sql.SQLException;
import java.util.List;

public interface CategoriesDAO {

    List<Categories> liste() throws SQLException;
}
