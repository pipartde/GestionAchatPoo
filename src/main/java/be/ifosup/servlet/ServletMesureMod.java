package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.Mesure;
import be.ifosup.mesure.MesureDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMesureMod", urlPatterns = {"/mesures-mod"})

public class ServletMesureMod extends HttpServlet {

    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO = daoFactory.getMesuresDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupération Id

        String mesId = request.getParameter("mesId");
        Mesure mesure = null;

        // Modification

        try {
            mesure = mesureDAO.recuperer(Long.parseLong(mesId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mesure", mesure);
        request.getRequestDispatcher("/vues/mesures-mod.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Forcer utf8

        request.setCharacterEncoding("UTF-8");

        // Champs

        String mesId = request.getParameter("mesId");
        String mesNom = request.getParameter("mesNom");

        // Ajout

        try {
            mesureDAO.modifier(Long.parseLong(mesId), mesNom);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Redirection
        try {
            request.setAttribute("ListeDesMesures", mesureDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/mesures.jsp").forward(request, response);
    }
}