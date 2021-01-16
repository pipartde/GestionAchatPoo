package be.ifosup.magasins;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagasinDaoImpl implements MagasinDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resulat = null;

    public MagasinDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Magasin magasin) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO magasins (magNom) VALUES (?);");

            preparedStatement.setString(1, magasin.getNomMag());

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
    public List<Magasin> liste() throws SQLException {
        List<Magasin> magasins = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resulat = statement.executeQuery("SELECT * FROM magasins;");

        while( resulat.next()) {
            Long id = resulat.getLong("magId");
            String magNom = resulat.getString("magNom");

            Magasin magasin = new Magasin(id, magNom);

            magasins.add(magasin);
        }
        return magasins;
    }
}