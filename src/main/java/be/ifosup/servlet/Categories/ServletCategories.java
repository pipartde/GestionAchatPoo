package be.ifosup.servlet.Categories;

import be.ifosup.categories.CategoriesDAO;
import be.ifosup.dao.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCategories", urlPatterns = {"/categories"})
public class ServletCategories extends HttpServlet {
    private CategoriesDAO categoriesDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String magId = request.getParameter("mag_id");
            request.setAttribute("magId", magId);
        } catch(NullPointerException e) {
            String magId = null;
        }
        // Affichage de la liste des catégories
        try {
            request.setAttribute("categories", categoriesDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/vues/categories.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // todos formulaire de modification+ajout+suppression Categories
    }
}
