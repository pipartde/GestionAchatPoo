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
            preparedStatement = connection.prepareStatement("DELETE magasins , achats , produits FROM magasins INNER JOIN achats ON achMagId = magId INNER JOIN produits ON achProId = proId WHERE magId = ?;");
            preparedStatement.setLong(1, magId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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
    public void modifier(Long magId, String magNom) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE magasins SET magNom = ? WHERE magId = ?;");

            preparedStatement.setString(1, magNom);
            preparedStatement.setLong(2, magId);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Magasin> liste() throws SQLException {
        List<Magasin> magasins = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM magasins ORDER BY magNom ASC;");

        while( resultat.next()) {
            Long magId = resultat.getLong("magId");
            String magNom = resultat.getString("magNom");

            Magasin magasin = new Magasin(magId, magNom);

            magasins.add(magasin);
        }
        return magasins;
    }

    @Override
    public Magasin recuperer(Long magId) throws SQLException {

        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT magNom FROM magasins WHERE magId = ?;");
        preparedStatement.setLong(1, magId);
        resultat = preparedStatement.executeQuery();

        resultat.next();
        String magNom = resultat.getString("magNom");
        Magasin magasin = new Magasin(magId, magNom);

        return magasin;
    }
}