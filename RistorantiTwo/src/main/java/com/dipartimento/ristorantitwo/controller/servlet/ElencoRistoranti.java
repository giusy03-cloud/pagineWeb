package com.dipartimento.ristorantitwo.controller.servlet;

import com.dipartimento.ristorantitwo.model.Ristorante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//questa classe SERVLET gestisce la richiesta HTTP GET al percorso /ristoranti


@WebServlet("/ristoranti")
public class ElencoRistoranti extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Funziona!!");
        //PrintWriter writer = resp.getWriter();
        //writer.println("<html><strong>Funziona!!</strong></html>");

        String username = (String) req.getSession(true).getAttribute("username");
        System.out.println("username: " + username);
        if (username != null) {
            //se un utente è autenticato, la servlet crea una lista di oggetti Ristorante
            //e la inoltra alla pagina HTML(elenco_ristoranti.html) utilizzando un requestDispatcher
            //Ho fatto la query
            List<Ristorante> ristoranti = new ArrayList<Ristorante>();
            Ristorante r1 = new Ristorante();
            r1.setNome("Le Casette di Zio Santino");
            r1.setDescrizione("Ristorante/Pizzeria");
            r1.setUbicazione("Rende");
            ristoranti.add(r1);

            Ristorante r2 = new Ristorante();
            r2.setNome("Fratfrode");
            r2.setDescrizione("Pizzeria");
            r2.setUbicazione("Rende");
            ristoranti.add(r2);

            req.setAttribute("ristoranti", ristoranti);

            RequestDispatcher dispatcher = req.getRequestDispatcher("templates/elenco_ristoranti.html");
            dispatcher.forward(req, resp);
        }else{
            //se invece non è autenticatp, viene reindirizzato alla pafina notAuthorized.html
            RequestDispatcher dispatcher = req.getRequestDispatcher("templates/notAuthorized.html");
            dispatcher.forward(req, resp);
        }

    }
}