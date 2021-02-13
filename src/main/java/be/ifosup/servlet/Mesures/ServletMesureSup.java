package be.ifosup.servlet.Mesures;

import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.MesureDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMesureSup",urlPatterns = {"/mesures-sup"})

public class ServletMesureSup extends HttpServlet {

    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO = daoFactory.getMesuresDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération id

        String mesId = request.getParameter("mesId");
        try {
            String magId = request.getParameter("mag_id");
            request.setAttribute("magId", magId);
            System.out.println(magId);
        } catch(NullPointerException e) {
            String magId = null;
        }

        // Suppression

        try {
            mesureDAO.supprimer(Long.parseLong(mesId));
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
