package com.persistence.uow;

import com.domain.Personne;
import com.persistence.mapper.PersonneMapper;

/**
 * Created by baptiste on 20/11/16.
 * Hi
 * C'est le visiteur qui va se charger de realiser les updates
 * (en appelant le bon datamapper en fonction de la classe)
 */
 public class Committer extends Visiteur {
    public void visiter(Personne p) {
        PersonneMapper.getInstance().update(p);
    }

}
