package be.ifosup.servlet.Produits;

import be.ifosup.categories.CategoriesDAO;
import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProduitSup", urlPatterns = {"/produitSup"})
public class ServletProduitSup extends HttpServlet {

    private ProduitDAO produitDAO;
    private CategoriesDAO categoriesDAO;
    private MesureDAO mesureDAO;
    private MagasinDAO magasinDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
        this.mesureDAO = daoFactory.getMesuresDAO();
        this.magasinDAO = daoFactory.getMagasinsDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ce que le servlet envoie à la vue
        // récupération Id
        String id = request.getParameter("id");
        String magId = request.getParameter("magId");
        // appel de la méthode de suppresion
        produitDAO.supprimer(Long.parseLong(id));
        // récupération des produits et retour a la bonne vue
        try {
            request.setAttribute("magId",magId);
            request.setAttribute("produits", produitDAO.liste(Long.parseLong(magId)));
            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());
            request.setAttribute("magasins", magasinDAO.liste());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/vues/produits.jsp").forward(request,response);
    }

}
