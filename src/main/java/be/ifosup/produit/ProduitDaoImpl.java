package be.ifosup.produit;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements ProduitDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultat = null;

    public ProduitDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Produit produits) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO produits (proNom) VALUES (?);");

            preparedStatement.setString(1, produits.getproNom());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void supprimer(Long id) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM produits WHERE proId = ?;");

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
    public List<Produit> liste() throws SQLException {
        List<Produit> produits = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM produits;");

        while( resultat.next()) {
            Long id = resultat.getLong("proId");
            String proNom = resultat.getString("proNom");

            Produit produit= new Produit(id, proNom);

            produits.add(produit);
        }
        return produits;
    }
}
