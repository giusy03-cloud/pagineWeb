package com.dipartimento.ristorantitwo.persistence.dao;

import com.dipartimento.ristorantitwo.model.Piatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PiattoDaoProxyImpl implements PiattoDao {

    private final PiattoDao piattoDao;

    @Autowired
    public PiattoDaoProxyImpl(@Qualifier("piattoDaoJpa") PiattoDao piattoDao) {
        this.piattoDao = piattoDao;
    }

    @Override
    public List<Piatto> findAll() {
        System.out.println("Proxy: Recupero tutti i piatti");
        return piattoDao.findAll();
    }

    @Override
    public Piatto findByPrimaryKey(String nome) {
        System.out.println("Proxy: Recupero piatto con nome " + nome);
        return piattoDao.findByPrimaryKey(nome);
    }

    @Override
    public void save(Piatto piatto) {
        System.out.println("Proxy: Salvataggio del piatto " + piatto.getNome());
        piattoDao.save(piatto);
    }

    @Override
    public void delete(Piatto piatto) {
        System.out.println("Proxy: Eliminazione del piatto " + piatto.getNome());
        piattoDao.delete(piatto);
    }

    @Override
    public List<Piatto> findAllByRistoranteName(String name) {
        System.out.println("Proxy: Recupero piatti per ristorante " + name);
        return piattoDao.findAllByRistoranteName(name);
    }
}
