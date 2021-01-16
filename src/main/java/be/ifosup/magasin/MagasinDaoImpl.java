package be.ifosup.magasin;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagasinDaoImpl implements MagasinDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultat = null;

    public MagasinDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Magasin magasin) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO magasins (magNom) VALUES (?);");

            preparedStatement.setString(1, magasin.getMagNom());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void supprimer(Long magId) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM magasins WHERE magId = ?;");

            preparedStatement.setLong(1, magId);
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
        resultat = statement.executeQuery("SELECT * FROM magasins;");

        while( resultat.next()) {
            Long magId = resultat.getLong("magId");
            String magNom = resultat.getString("magNom");

            Magasin magasin = new Magasin(magId, magNom);

            magasins.add(magasin);
        }
        return magasins;
    }
}