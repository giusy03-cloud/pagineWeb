package com.dipartimento.ristorantitwo.persistence.dao;

import com.dipartimento.ristorantitwo.model.Piatto;

import java.util.List;

// Interfaccia che definisce le operazioni CRUD per la gestione dei piatti
public interface PiattoDao {

    // Recupera tutti i piatti
    List<Piatto> findAll();

    // Trova un piatto tramite il suo nome
    Piatto findByPrimaryKey(String nome);

    // Salva un nuovo piatto nel DB
    void save(Piatto piatto);

    // Elimina piatto da DB
    void delete(Piatto piatto);

    // Trova tutti i piatti associati a un determinato ristorante
    // identificato dal suo nome
    List<Piatto> findAllByRistoranteName(String name);
}
