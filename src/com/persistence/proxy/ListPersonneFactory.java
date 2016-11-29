package com.persistence.proxy;

import com.domain.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baptiste on 28/11/16.
 * Hi
 */
public class ListPersonneFactory implements Factory<List<Personne>> {
    @Override
    public List<Personne> create() {
        List<Personne> lp = new ArrayList<>();
        lp.add(new Personne("FAMCHON","Baptiste","0618"));
        return lp;
            /*
             * Dans une situation réelle, ici, on pourrait créer notre objet en appelant le DataMapper pour le
             * récuperer depuis la base de données.
             */
    }
}
