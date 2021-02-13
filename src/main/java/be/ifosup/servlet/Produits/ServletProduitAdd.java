package be.ifosup.servlet.Produits;

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

import static be.ifosup.librairies.functions.convertHtmlSpecialChars;

@WebServlet(name = "ServletProduitAdd", urlPatterns = {"/produitAdd"})
public class ServletProduitAdd extends HttpServlet {

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
        // servlet envoi des données dans une page .jsp
        String magId = request.getParameter("magId");
        try {
            request.setAttribute("magId", magId);
            request.setAttribute("categories", categoriesDAO.liste());
            request.setAttribute("mesures", mesureDAO.liste());
            request.setAttribute("magasins", magasinDAO.liste());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("vues/produit.jsp?magId=" + magId).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet reçoit les info formulaire

        // forcer l'UTF-8 dans les échanges
        request.setCharacterEncoding("UTF-8");

        Long magId = Long.parseLong(request.getParameter("magId"));

        try {
            Long proCatId = Long.parseLong(request.getParameter("category"));
            String proNom = convertHtmlSpecialChars(request.getParameter("proNom").trim());
            Double proQtt = Double.parseDouble(request.getParameter("quantity").trim());
            Long proMesId = Long.parseLong(request.getParameter("mesures"));

            // ajout du produit dans la BD

            if (!proNom.equals("") && isGreaterZero(proQtt)) {
                produitDAO.ajouter(new Produit(proNom, proCatId, proMesId, proQtt), magId);
            }

        } catch (NumberFormatException e) {
            // todo : ajouter un message à retourner sur la .jsp en cas d'erreur??
        } finally {
            // redirection
            try {
                request.setAttribute("magId", magId);
                request.setAttribute("produits", produitDAO.liste(magId));
                request.setAttribute("categories", categoriesDAO.liste());
                request.setAttribute("mesures", mesureDAO.liste());
                request.setAttribute("magasins", magasinDAO.liste());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("vues/produits.jsp?magId=" + magId).forward(request, response);
        }
    }


    protected static boolean isGreaterZero(Double toCheck) {
        return toCheck > 0;
    }

}