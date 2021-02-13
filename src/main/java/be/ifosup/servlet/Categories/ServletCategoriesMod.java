package be.ifosup.servlet.Categories;

import be.ifosup.categories.Categories;
import be.ifosup.categories.CategoriesDAO;
import be.ifosup.dao.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

import static be.ifosup.librairies.functions.convertHtmlSpecialChars;

@WebServlet(name = "ServletCategoriesMod", urlPatterns = "/mod-categorie")
public class ServletCategoriesMod extends HttpServlet {

    private CategoriesDAO categoriesDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérations des champs
        try {
            String magId = request.getParameter("mag_id");
            request.setAttribute("magId", magId);
        } catch(NullPointerException e) {
            String magId = null;
        }
        String catId = request.getParameter("catId");
        Categories categorie = null;

        try {
            categorie = categoriesDAO.lire(Long.parseLong(catId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("categorie", categorie);
        request.getRequestDispatcher("vues/modCategories.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Formater en UTF-8

        request.setCharacterEncoding("UTF-8");

        // Récupérations des champs

        Long catId = Long.parseLong(request.getParameter("catId"));
        String catNom = convertHtmlSpecialChars(request.getParameter("catNom")).trim();
        try {
            String magId = request.getParameter("mag_id");
            request.setAttribute("magId", magId);
        } catch(NullPointerException e) {
            String magId = null;
        }

        // Modification dans la DB
        
        if(!catNom.equals("")){
            categoriesDAO.modifier(catId, catNom);}

        // Redirection

        try {
            request.setAttribute("categories", categoriesDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/categories.jsp").forward(request,response);
    }
}
