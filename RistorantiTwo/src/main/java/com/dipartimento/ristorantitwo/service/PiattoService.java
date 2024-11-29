package com.dipartimento.ristorantitwo.service;


import com.dipartimento.ristorantitwo.exception.PiattoNotValidException;
import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.persistence.dao.PiattoDao;
import org.springframework.stereotype.Service;

import java.util.Collection;

//LA CLASSE IMPLEMENTA L'INTERFACCIA IPIATTOSERVICE
//FORNISCE LA LOGICA CONCREAT PER GESTIRE I PIATTI
@Service
class PiattoService implements IPiattoService {

    //opzione autowiring 1
//    @Autowired
//    private  PiattoDao dao;

    // opzione autowiring 2
    private final PiattoDao piattoDao;

    //COSTRUTTORE ACCETTA UN'ISTANZA DI PIATTODAO, PER L'ACCESSO AI DATI

    PiattoService(PiattoDao piattoDao) {
        this.piattoDao = piattoDao;
    }


    //QUESTO METODO ACCEDE AI DATI E RESTITUISCE LA LISTA DEI PIATTI
    @Override
    public Collection<Piatto> findAll() {
        return piattoDao.findAll();
    }

    //RESTITUISCE UN PIATTO CERCANDOLO NEL DATABASE TRAMITE IL NOME
    @Override
    public Piatto findById(String nome) {
        return piattoDao.findByPrimaryKey(nome);
    }

    //CREA NUOVO PIATTO
    @Override
    public Piatto createPiatto(Piatto piatto) throws Exception {

        System.out.println("Doing create piatto");
        // verifythata Piatto is consistent
        checkPiattoIsValid(piatto);

        //verify that not exists a Piatto with the same name...
        Piatto byPrimaryKey = piattoDao.findByPrimaryKey(piatto.getNome());
        if(byPrimaryKey!=null){
            throw new Exception("Already exists a Piatto whit the same name:"+piatto.getNome());
        }


        //SE IL PIATTO E' VALIDO E NON ESISTE GIA', VIENE SALVATO NEL DATABSE

        piattoDao.save(piatto);

        return piattoDao.findByPrimaryKey(piatto.getNome());
    }

    //METODO CHE VERIFICA SE IL PIATTO E' VALIDO
    private void checkPiattoIsValid(Piatto piatto) throws PiattoNotValidException {
        if(piatto==null){
            throw new PiattoNotValidException("Piatto must be not null");
        }

        if(piatto.getNome()==null || piatto.getNome().isEmpty()){
            throw new PiattoNotValidException("Piatto.nome must be not null and not empty");
        }

        //TODO other checks..

    }

    //AGGIORNA UN PIATTO ESISTENTE, PRIMA VERIFICA SE E' VALIDO
    @Override
    public Piatto updatePiatto(String nomePiatto, Piatto piatto) throws Exception {

        System.out.println("Doing update");
        checkPiattoIsValid(piatto);

        //VERIFICO SE ESISTE UN PIATTO CON IL NOME DATO NEL DATABASE
        Piatto byPrimaryKey = piattoDao.findByPrimaryKey(nomePiatto);
        if(byPrimaryKey==null){
            throw new Exception("Not exists a Piatto whit the name:"+piatto.getNome());
        }

        //SE IL PIATTO ESISTE AGGIOTNO IL PIATTO E LO SALVA
        piatto.setNome(nomePiatto);

        piattoDao.save(piatto);

        return piattoDao.findByPrimaryKey(piatto.getNome());
    }

    @Override
    public void deletePiatto(String nome) {
        //TODO modify DAO
//        this.piattoDao.delete(nome);
    }
}