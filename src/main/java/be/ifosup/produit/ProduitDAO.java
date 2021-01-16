package be.ifosup.produit;

import be.ifosup.magasin.Magasin;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDAO {


    void ajouter(Produit produit);
    void supprimer(Long id);
    void modifier(Long id);
    List<Produit> liste() throws SQLException;

}
