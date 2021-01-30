package be.ifosup.servlet.Produits;

import be.ifosup.categories.CategoriesDAO;
import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProduitMod", urlPatterns = {"/produitMod"})
public class ServletProduitMod extends HttpServlet {

    private ProduitDAO produitDAO;
    private CategoriesDAO categoriesDAO;
    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
        this.mesureDAO = daoFactory.getMesuresDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //envoit des données a une page .jsp
        String id = request.getParameter("id");
        String listeId = request.getParameter("listeId");
        Produit produit = null;
        try {
            produit = produitDAO.recuperer(Long.parseLong(id));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            request.setAttribute("listeId", listeId);
            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("produit", produit);
        request.getRequestDispatcher("/vues/produitMod.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //reçoit des données d'un formulaire

        // forcer l'UTF-8 dans les échanges
        request.setCharacterEncoding("UTF-8");

        // récupération des valeurs du formulaire
        String listeId = request.getParameter("listeId");
        String id = request.getParameter("proId");
        String proCatId = request.getParameter("category");
        String proNom = request.getParameter("proNom");
        String proQtt = request.getParameter("quantity");
        String proMesId = request.getParameter("mesures");

        // modification du produit dans la BD
        produitDAO.modifier(Long.parseLong(id), proNom, Long.parseLong(proCatId),Long.parseLong(proMesId),Double.parseDouble(proQtt));

        // redirection
        try {
            request.setAttribute("produits", produitDAO.liste(Long.parseLong(listeId)));
            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/produits.jsp").forward(request, response);
    }
}
