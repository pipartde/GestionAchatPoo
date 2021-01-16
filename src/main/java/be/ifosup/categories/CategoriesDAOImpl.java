package be.ifosup.categories;

import be.ifosup.dao.DAOFactory;
import be.ifosup.categories.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOImpl implements CategoriesDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultat = null;

    public CategoriesDAOImpl(DAOFactory daoFactory) {this.daoFactory = daoFactory;}

    @Override
    public List<Categories> liste() throws SQLException {
        List<Categories> categories = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM categories");

        while (resultat.next()) {
            Long catId = resultat.getLong("catId");
            String catNom = resultat.getString("catNom");

            Categories categorie = new Categories(catId, catNom);

            categories.add(categorie);
        }
        return categories;
    }
}
