package com.dipartimento.ristorantitwo.service;


import com.dipartimento.ristorantitwo.exception.PiattoNotValidException;
import com.dipartimento.ristorantitwo.model.Piatto;

import java.util.Collection;

//questa interfaccia definisce un contratto che descrive le operazioni che
//un servizio di piatti deve supportare

public interface IPiattoService {

    // list
    //collezione di tutti i piatti disponibili nel sistema
    Collection<Piatto> findAll();

    // retrieve byID
    //piatto identificato dal suo nome
    Piatto findById(String nome);

    // create
    //crea un nuovo piatto nel sistema
    Piatto createPiatto(Piatto piatto) throws Exception;

    // update
    //aggiorna un piatto esistente nel sistema
    Piatto updatePiatto(String nomePiatto, Piatto piatto) throws Exception;

    // delete
    //elimina un piatto dal sistema identificato dal nome
    void deletePiatto(String nome);


}