package be.ifosup.dao;


import be.ifosup.magasins.MagasinDAO;
import be.ifosup.magasins.MagasinDaoImpl;

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
        DAOFactory instance = new DAOFactory("jdbc:mysql://localhost:3306/gestionachat", "root", "");
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
}
