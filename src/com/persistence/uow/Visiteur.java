package com.persistence.uow;

import com.domain.Personne;

/**
 * Created by baptiste on 20/11/16.
 * Hi
 */
public abstract class Visiteur {
    public void visiter(IDomainObject o) {
        o.accepter(this);
    }
    abstract public void visiter(Personne p);
}
