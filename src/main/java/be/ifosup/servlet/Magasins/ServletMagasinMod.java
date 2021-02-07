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

@WebServlet(name = "ServletMagasinMod", urlPatterns = {"/modMagasin"})
public class ServletMagasinMod extends HttpServlet {

    private MagasinDAO magasinDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // forcer l'UTF-8 dans les échanges

        request.setCharacterEncoding("UTF-8");

        // récupération des valeurs du formulaire

        String magId = request.getParameter("magId");
        String magNom = request.getParameter("magNom").trim();

        // ajout du magasin dans la BD

        if(!magNom.equals("")){
            magasinDAO.modifier(Long.parseLong(magId), magNom);}

        // redirection

        try {
            request.setAttribute("magasins", magasinDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/magasins.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // récupération Id

        String magId = request.getParameter("magId");
        Magasin magasin = null;
        try {
            magasin = magasinDAO.recuperer(Long.parseLong(magId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("magasin", magasin);
        request.getRequestDispatcher("/vues/modMagasins.jsp").forward(request,response);
    }
}