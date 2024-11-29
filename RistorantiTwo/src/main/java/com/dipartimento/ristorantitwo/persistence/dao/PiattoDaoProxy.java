package com.dipartimento.ristorantitwo.persistence.dao;

import com.dipartimento.ristorantitwo.model.Piatto;

import java.util.List;
import java.util.Set;

public interface PiattoDaoProxy {

    List<Piatto> findAll();

    Piatto findByPrimaryKey(String nome);

    void save(Piatto piatto);

    void delete(Piatto piatto);

    Set<Piatto> findAllByRistoranteName(String name);
}
