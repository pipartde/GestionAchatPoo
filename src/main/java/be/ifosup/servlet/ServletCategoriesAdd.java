package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.categories.Categories;
import be.ifosup.categories.CategoriesDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCategoriesAdd", urlPatterns = {"/add-categorie"})
public class ServletCategoriesAdd extends HttpServlet {
    private CategoriesDAO categoriesDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String catNom = request.getParameter("catNom");

        categoriesDAO.ajouter(new Categories(catNom));

        try {
            request.setAttribute("categories", categoriesDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/categories.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vues/categoriesAdd.jsp").forward(request, response);
    }
}
