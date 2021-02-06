package be.ifosup.servlet.Produits;

import be.ifosup.categories.CategoriesDAO;
import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
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
    private MagasinDAO magasinDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitsDAO();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
        this.mesureDAO = daoFactory.getMesuresDAO();
        this.magasinDAO = daoFactory.getMagasinsDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //envoit des données a une page .jsp
        String id = request.getParameter("id");
        String magId = request.getParameter("magId");
        Produit produit = null;
        try {
            produit = produitDAO.recuperer(Long.parseLong(id));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            request.setAttribute("magId", magId);
            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());
            request.setAttribute("magasins", magasinDAO.liste());
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

        String magId = request.getParameter("magId");
        String id = request.getParameter("proId");
        String proCatId = request.getParameter("category");
        String proNom = request.getParameter("proNom").trim();
        String proQtt = request.getParameter("quantity").trim();
        String proMesId = request.getParameter("mesures");

        // modification du produit dans la BD

        try {
            if(!proNom.equals("") && !proQtt.equals("")){
                produitDAO.modifier(Long.parseLong(id), proNom, Long.parseLong(proCatId),Long.parseLong(proMesId),Double.parseDouble(proQtt));}
            else {
                request.setAttribute("magId", magId);
                request.setAttribute("produits", produitDAO.liste(Long.parseLong(magId)));
                request.setAttribute("categories", categoriesDAO.liste());
                request.setAttribute("mesures", mesureDAO.liste());
                request.setAttribute("magasins", magasinDAO.liste());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // redirection

        try {
            request.setAttribute("magId", magId);
            request.setAttribute("produits", produitDAO.liste(Long.parseLong(magId)));
            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());
            request.setAttribute("magasins", magasinDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/produits.jsp").forward(request, response);
    }
}
