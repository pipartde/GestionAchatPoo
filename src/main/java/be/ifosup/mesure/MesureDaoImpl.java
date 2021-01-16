package be.ifosup.mesure;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesureDaoImpl implements MesureDAO{
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultat = null;

    public MesureDaoImpl(DAOFactory daoFactory) {this.daoFactory = daoFactory; }

    @Override
    public void ajouter(Mesure mesure) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO mesures (mesId, mesNom) VALUE (?, ?)");

        preparedStatement.setLong(1, mesure.getMesId());
        preparedStatement.setString(2, mesure.getMesNom());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(Long mesId) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM mesures WHERE mesId = ?");

        preparedStatement.setLong(1, mesId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Mesure mesure) {
        // à faire
    }

    @Override
    public List<Mesure> liste() throws SQLException {
        List<Mesure> mesures = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM mesures");

        while ( resultat.next()){
            Long mesId = resultat.getLong("mesId");
            String mesNom = resultat.getString("mesNom");

            mesures.add(new Mesure(mesId, mesNom));
        }

        return mesures;
    }
}