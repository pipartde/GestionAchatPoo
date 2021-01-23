package be.ifosup.servlet;

import be.ifosup.categories.Categories;
import be.ifosup.categories.CategoriesDAO;
import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletProduitAdd", urlPatterns = {"/add-produit"})
public class ServletProduitAdd extends HttpServlet {
    private ProduitDAO produitDAO;
    private CategoriesDAO categoriesDAO;
    private MesureDAO mesureDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
        this.mesureDAO = daoFactory.getMesuresDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet envoi des données dans une page .jsp

        try {

            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("vues/produitAdd.jsp").forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet reçoit les info formulaire

        // forcer l'UTF-8 dans les échanges
        request.setCharacterEncoding("UTF-8");

        String proNom = request.getParameter("proNom");

        // ajout du produit dans la BD
        produitDAO.ajouter( new Produit(proNom));

        // redirection
        try {
            request.setAttribute("produits", produitDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/produits.jsp").forward(request, response);
    }
}