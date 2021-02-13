package be.ifosup.servlet.Categories;

import be.ifosup.dao.DAOFactory;
import be.ifosup.categories.Categories;
import be.ifosup.categories.CategoriesDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCategoriesSupp", urlPatterns = {"/sup-categorie"})
public class ServletCategoriesSup extends HttpServlet {
    private CategoriesDAO categoriesDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Récupération des champs
        String id = request.getParameter("id");
        try {
            String magId = request.getParameter("mag_id");
            request.setAttribute("magId", magId);
        } catch(NullPointerException e) {
            String magId = null;
        }


        // Suppression dans la DB
        categoriesDAO.supprimer(Long.parseLong(id));

        //Redirection

        try {
            request.setAttribute("categories", categoriesDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/categories.jsp").forward(request, response);
    }
}
