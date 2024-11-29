package com.dipartimento.ristorantitwo.controller;

import com.dipartimento.ristorantitwo.model.Ristorante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GestioneRistorante {

    @PostMapping("/addRistorante")  // Cambia @GetMapping in @PostMapping
    public String aggiungiRistorante(@RequestBody Ristorante ristorante) {
        System.out.println("ristorante: " + ristorante.getNome());
        return "Ristorante aggiunto con successo!";
    }
}

