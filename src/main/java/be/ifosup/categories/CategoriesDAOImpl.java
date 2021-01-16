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
    public void ajouter(Categories categories) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO categoies (catNom) VALUE (?); ");

            preparedStatement.setString(1, categories.getcatNom());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void supprimer(Long catId) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM categories WHERE catId = ?;");

            preparedStatement.setLong(1, catId);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void modifier(Long catId) {
         // todo ajouter fonction 'modifier categories"
    }

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
