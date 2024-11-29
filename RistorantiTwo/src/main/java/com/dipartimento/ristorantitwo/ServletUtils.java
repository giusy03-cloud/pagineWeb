package com.dipartimento.ristorantitwo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServletUtils {

    @RequestMapping(value = "/views/**", method = {RequestMethod.GET, RequestMethod.POST})
    public String templateHandler(HttpServletRequest request) {
        String resource = request.getRequestURI().substring("/views/".length());
        System.out.println("URL resource: " + resource);

        // Controlla se ".html" è presente nella stringa
        int htmlIndex = resource.indexOf(".html");
        if (htmlIndex != -1) {
            resource = resource.substring(0, htmlIndex);  // Rimuovi l'estensione .html
        }

        return resource;
    }

}
