package be.ifosup.magasins;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagasinsDaoImpl implements MagasinsDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resulat = null;

    public MagasinsDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Magasins magasins) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO magasins (magNom) VALUES (?);");

            preparedStatement.setString(1, magasins.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM magasins WHERE magId = ?;");

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void modifier(Long id) {
        // a faire !
    }

    @Override
    public List<Magasins> liste() throws SQLException {
        List<Magasins> magasins = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resulat = statement.executeQuery("SELECT PK_todo, description, titre as categorie FROM todos INNER JOIN categorie ON FK_cat = PK_cat;");

        while( resulat.next()) {
            Long id = resulat.getLong("PK_todo");
            String description = resulat.getString("description");
            String categorie = resulat.getString("categorie");

            Magasins magasins = new Magasins(id, description, categorie);

            magasins.add(magasins);
        }
        return magasins;
    }
}