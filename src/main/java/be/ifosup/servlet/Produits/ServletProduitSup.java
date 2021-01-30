package be.ifosup.servlet.Produits;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProduitSup", urlPatterns = {"/produitSup"})
public class ServletProduitSup extends HttpServlet {

    private ProduitDAO produitDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupération Id
        String id = request.getParameter("id");
        // appel de la méthode de suppresion
        produitDAO.supprimer(Long.parseLong(id));
        // récupération des magasins et retour a la bonne vue
        try {
            request.setAttribute("produits", produitDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/vues/produits.jsp").forward(request,response);
    }


}
