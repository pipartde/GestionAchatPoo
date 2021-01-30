package be.ifosup.servlet.Magasins;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMagasinAdd", urlPatterns = {"/addMagasin"})
public class ServletMagasinAdd extends HttpServlet {
    private MagasinDAO magasinDAO;
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinsDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // forcer l'UTF-8 dans les échanges
        request.setCharacterEncoding("UTF-8");

        // récupération des valeurs du formulaire
        String magNom = request.getParameter("magNom");

        // ajout du magasin dans la BD
        magasinDAO.ajouter( new Magasin(magNom));

        // redirection
        try {
            request.setAttribute("magasins", magasinDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/magasins.jsp").forward(request, response);
    }
}
