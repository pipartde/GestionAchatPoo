package be.ifosup.servlet.Categories;

import be.ifosup.dao.DAOFactory;
import be.ifosup.categories.Categories;
import be.ifosup.categories.CategoriesDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ServletCategoriesAdd", urlPatterns = {"/add-categorie"})
public class ServletCategoriesAdd extends HttpServlet {
    private CategoriesDAO categoriesDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categoriesDAO = daoFactory.getCategoriesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Formater en UTF-8
        request.setCharacterEncoding("UTF-8");


        // Récupération des champs
        String catNom = request.getParameter("catNom").trim();


        // Ajout dans la DB
        if (!catNom.equals("")) {
            categoriesDAO.ajouter(new Categories(catNom));
        }




        // Redirection
        try {
            request.setAttribute("categories", categoriesDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/categories.jsp").forward(request, response);
    }
}
