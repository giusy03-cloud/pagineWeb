package com.dipartimento.ristorantitwo.persistence.dao;

import com.dipartimento.ristorantitwo.model.Piatto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PiattoDaoJpa implements PiattoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Piatto> findAll() {
        return entityManager.createQuery("SELECT p FROM Piatto p", Piatto.class).getResultList();
    }

    @Override
    public Piatto findByPrimaryKey(String nome) {
        return entityManager.find(Piatto.class, nome);
    }

    @Override
    public void save(Piatto piatto) {
        if (piatto.getId() == null) { // Cambia in base al tuo identificativo primario
            entityManager.persist(piatto);
        } else {
            entityManager.merge(piatto);
        }
    }

    @Override
    public void delete(Piatto piatto) {
        Piatto managedPiatto = findByPrimaryKey(piatto.getNome());
        if (managedPiatto != null) {
            entityManager.remove(managedPiatto);
        }
    }

    @Override
    public List<Piatto> findAllByRistoranteName(String name) {
        return entityManager.createQuery(
                        "SELECT p FROM Piatto p JOIN p.ristoranti r WHERE r.nome = :name", Piatto.class)
                .setParameter("name", name)
                .getResultList();
    }
}
