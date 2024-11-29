package com.dipartimento.ristorantitwo.persistence.dao.impljdbc;

import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.model.Ristorante;
import com.dipartimento.ristorantitwo.persistence.DBManager;

import java.util.List;

public class RistoranteProxy extends Ristorante {

    @Override
    public List<Piatto> getPiatti() {
        if (super.getPiatti() == null)
            super.setPiatti(DBManager.getInstance().getPiattoDao().findAllByRistoranteName(this.getNome()));
        return super.getPiatti();
    }
}
