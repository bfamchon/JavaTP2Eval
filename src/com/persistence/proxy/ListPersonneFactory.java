package com.persistence.proxy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Personne;
import com.domaine.criteria.Criteria;
import com.domaine.criteria.PersonneCriteria;
import com.persistence.mapper.PersonneMapper;

/**
 * Created by baptiste on 28/11/16.
 * Hi
 */
public class ListPersonneFactory implements Factory<List<Personne>> {
    public List<Personne> create(Criteria critere) throws SQLException {
    	PersonneMapper pMap = new PersonneMapper();
        ArrayList<Personne> lp = new ArrayList<Personne>();
        int id = ((PersonneCriteria) critere).getId();

    	// lp = pMap.findByIdPERE(id);

        // TODO appel couche persistance via critere
        return lp;
            /*
             * Dans une situation réelle, ici, on pourrait créer notre objet en appelant le DataMapper pour le
             * récuperer depuis la base de données.
             */
    }
}
