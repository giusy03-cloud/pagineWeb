package com.dipartimento.ristorantitwo.controller.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Questa servlet gestisce la richiesta HTTP POST al percorso /doLogin per effettuare il login
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Leggi i parametri username e password dal form
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Log di debug per controllare i parametri ricevuti
        System.out.println("Login attempt with Username: " + username + " and Password: " + password);

        // Verifica le credenziali
        if (username != null && password != null && username.equals("kristian@email.it") && password.equals("reale")) {
            // Se corrette, salva il nome utente nella sessione
            req.getSession(true).setAttribute("username", username);
            // Redirige alla home page
            resp.sendRedirect("/");  // Assicurati che la home page sia configurata correttamente
        } else {
            // Se errate, fai il forward alla pagina di errore
            System.out.println("Login failed: invalid username or password.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("templates/loginErrato.html");
            dispatcher.forward(req, resp);
        }
    }
}
