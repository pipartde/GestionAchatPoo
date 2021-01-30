package be.ifosup.servlet.Produits;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProduit", urlPatterns = "/produits")
public class ServletProduit extends HttpServlet {
    private ProduitDAO produitDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //le servlet envoi des données sur la page .jsp
        try{
            request.setAttribute("produits",produitDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/vues/produits.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //le servlet recoit les données d'un formulaire
    }
}
