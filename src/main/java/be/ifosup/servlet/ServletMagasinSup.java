package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletTodoSup", urlPatterns = {"/supTodo"})
public class ServletMagasinSup extends HttpServlet {

    private MagasinDAO magasinDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupération Id
        String id = request.getParameter("id");
        // appel de la méthode de suppresion
        magasinDAO.supprimer(Long.parseLong(id));
        // récupération des todos et retour a la bonne vue
        try {
            request.setAttribute("todos", magasinDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/vues/todos.jsp").forward(request,response);
    }
}