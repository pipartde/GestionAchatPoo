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
    public void ajouter(Produit produits, Long listeId) {
        try {
            connection = daoFactory.getConnection();
            String sql = "INSERT INTO produits (proNom, proCatId, proMesId, proQtt) VALUES (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, produits.getproNom());
            preparedStatement.setLong(2, produits.getProCatId());
            preparedStatement.setLong(3, produits.getProMesId());
            preparedStatement.setDouble(4, produits.getproQtt());
            long lastInsertedID = preparedStatement.executeUpdate(sql, preparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement = connection.prepareStatement("INSERT INTO achats (achMagId, achProId) VALUES (?, ?);");
            preparedStatement.setLong(1, listeId);
            preparedStatement.setLong(2, lastInsertedID);
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
    public void modifier(Long id, String proNom, Long proCatId, Long proMesId, Double proQtt) {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE produits SET proNom = ?, proCatId = ?, proMesId = ?, proQtt = ? WHERE proId = ?");

            preparedStatement.setString(1, proNom);
            preparedStatement.setLong(2, proCatId);
            preparedStatement.setLong(3, proMesId);
            preparedStatement.setDouble(4, proQtt);
            preparedStatement.setLong(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Produit> liste(Long listeId) throws SQLException {
        List<Produit> produits = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM produits inner join achats on achProId=proId inner join magasins on magId=achMagId WHERE magId = ?");
        preparedStatement.setLong(1, listeId);

        while( resultat.next()) {
            Long id = resultat.getLong("proId");
            String proNom = resultat.getString("proNom");
            Double proQtt = resultat.getDouble("proQtt");
            Long proCatId = resultat.getLong("proCatId");
            Long proMesId = resultat.getLong("proMesId");

            Produit produit = new Produit(id, proNom, proCatId, proMesId, proQtt);

            produits.add(produit);
        }
        return produits;
    }

    @Override
    public Produit recuperer(Long proId) throws SQLException{

        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM produits WHERE proID = ?;");
        preparedStatement.setLong(1, proId);
        resultat = preparedStatement.executeQuery();

        resultat.next();

        Long id = resultat.getLong("proId");
        String proNom = resultat.getString("proNom");
        Double proQtt = resultat.getDouble("proQtt");
        Long proCatId = resultat.getLong("proCatId");
        Long proMesId = resultat.getLong("proMesId");

        Produit produit = new Produit(id, proNom, proCatId, proMesId, proQtt);

        return produit;
    }

}
