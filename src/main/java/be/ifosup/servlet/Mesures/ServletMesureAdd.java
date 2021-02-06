package be.ifosup.servlet.Mesures;

import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.Mesure;
import be.ifosup.mesure.MesureDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMesureAdd", urlPatterns = {"/mesures-add"})

public class ServletMesureAdd extends HttpServlet {
    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO = daoFactory.getMesuresDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Forcer utf8
        request.setCharacterEncoding("UTF-8");

        // Champs

        String mesNom = request.getParameter("mesNom");

        // Ajout

        try {
            mesureDAO.ajouter(new Mesure(mesNom));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Redirection

        try {
            request.setAttribute("ListeDesMesures", mesureDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/mesures.jsp").forward(request,response);
    }
}

