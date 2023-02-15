package io.github.axel1.corpulenceweb.servlet;

import io.github.axel1.corpulenceweb.calculateur.CalculateurIMC;
import io.github.axel1.corpulenceweb.model.entity.Utilisateur;
import io.github.axel1.corpulenceweb.model.service.IMCService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "imc-servlet", value = "/imc-servlet")
public class IMCServlet extends HttpServlet {

    //Create a new service with the calculateur
    private IMCService service = new IMCService(new CalculateurIMC());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/imc.jsp");
        //Calculate the average with the service
        request.setAttribute("moyenne", service.getMoyenne());
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/imc.jsp");
        String poidsParam = request.getParameter("poids");
        String tailleParam = request.getParameter("taille");

        //Check if the parameters are empty
        if (poidsParam.isEmpty() || tailleParam.isEmpty()) {
            request.setAttribute("moyenne", service.getMoyenne());
            try {
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Convert the parameters to float
        float poids = Float.parseFloat(poidsParam);
        float taille = Float.parseFloat(tailleParam);

        //Calculate the IMC and the corpulence with the service and forward the request
        request.setAttribute("imc", service.getImc(poids, taille));
        request.setAttribute("corpulence", service.getCorpulence(poids, taille));
        request.setAttribute("moyenne", service.getMoyenne());
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
