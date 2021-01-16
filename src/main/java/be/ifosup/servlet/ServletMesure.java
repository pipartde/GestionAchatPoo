package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.MesureDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMesure", urlPatterns = "/mesures")

public class ServletMesure extends HttpServlet {
    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO = daoFactory.getMesuresDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("ListeDesMesures", mesureDAO.liste());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        request.getRequestDispatcher("/vues/mesures.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
