package be.ifosup.mesure;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesureDaoImpl implements MesureDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultat = null;

    public MesureDaoImpl(DAOFactory daoFactory) {this.daoFactory = daoFactory; }

    @Override
    public void ajouter(Mesure mesure) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO mesures (mesNom) VALUE (?);");

        preparedStatement.setString(1, mesure.getMesNom());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(Long mesId) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM mesures WHERE mesId = ?;");

        preparedStatement.setLong(1, mesId);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("UPDATE produits SET proMesId = 1 WHERE proMesId = ?;");
        preparedStatement.setLong(1, mesId);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Long mesId, String mesNom) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE mesures SET mesNom = ? WHERE mesId = ?;");

        preparedStatement.setString(1, mesNom);
        preparedStatement.setString(2, Long.toString(mesId));

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Mesure> liste() throws SQLException {
        List<Mesure> mesures = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM mesures ORDER BY mesId;");

        while ( resultat.next()){
            Long mesId = resultat.getLong("mesId");
            String mesNom = resultat.getString("mesNom");

            Mesure mesure = new Mesure(mesId, mesNom);

            mesures.add(mesure);
        }

        return mesures;
    }

    @Override
    public Mesure recuperer(Long mesId) throws SQLException {

        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT mesNom FROM mesures WHERE mesId = ?;");
        preparedStatement.setLong(1, mesId);
        resultat = preparedStatement.executeQuery();

        resultat.next();
        String mesNom = resultat.getString("mesNom");
        Mesure mesure = new Mesure(mesId, mesNom);

        return mesure;
    }
}
