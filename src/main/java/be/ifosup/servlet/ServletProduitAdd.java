package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProduitAdd", urlPatterns = {"/add-produit"})
public class ServletProduitAdd extends HttpServlet {
    private ProduitDAO produitDAO;
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // forcer l'UTF-8 dans les échanges
        request.setCharacterEncoding("UTF-8");

        // récupération des valeurs du formulaire
        String proNom = request.getParameter("proNom");

        // ajout du magasin dans la BD
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