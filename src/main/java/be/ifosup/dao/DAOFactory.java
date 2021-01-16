package be.ifosup.dao;


import be.ifosup.categories.CategoriesDAO;
import be.ifosup.categories.CategoriesDAOImpl;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.magasin.MagasinDaoImpl;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.mesure.MesureDaoImpl;
import be.ifosup.produit.ProduitDAO;
import be.ifosup.produit.ProduitDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    // Attributs
    private final String url;
    private final String username;
    private final String password;

    // Constructeur

    public DAOFactory(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Charger le driver et se connecter a la bdd

    public static DAOFactory getInstance(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        // ATTENTION A NE PAS OUBLIER DE CHANGER LE NOM DE LA BDD DANS L'URL
        DAOFactory instance = new DAOFactory("jdbc:mysql://localhost:3306/gestionachat?serverTimezone=CET", "root", "");
        return instance;
    }

    // Récupérer la connexion

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupérer les données

    public MagasinDAO getMagasinsDAO(){
        return new MagasinDaoImpl(this);
    }
    public ProduitDAO getProduitsDAO(){
        return new ProduitDaoImpl(this);
    }
    public MesureDAO getMesuresDAO(){
        return new MesureDaoImpl(this);
    }


    public CategoriesDAO getCategoriesDAO() {
        return new CategoriesDAOImpl(this);
    }
}

