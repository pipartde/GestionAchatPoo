package be.ifosup.dao;



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
        DAOFactory instance = new DAOFactory("jdbc:mysql://localhost:3306/gestionachat", "root", "");
        return instance;
    }

    // Recuperer la connexion

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Recuperer les données


}
