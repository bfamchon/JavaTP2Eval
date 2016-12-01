package com.persistence.proxy;

import java.sql.SQLException;
import java.util.List;

import com.domain.Personne;
import com.domain.criteria.Criteria;
import com.domain.criteria.PersonneCriteria;
import com.persistence.mapper.PersonneMapper;

/**
 * Created by baptiste on 28/11/16.
 * Hi
 */
public class ListPersonneFactory implements Factory<List<Personne>> {
    public List<Personne> create(Criteria critere) throws SQLException {
    	PersonneMapper pMap = new PersonneMapper();
        List<Personne> lp;
        int id = ((PersonneCriteria) critere).getId();
        lp = pMap.findFilsByIdPere(id);
        return lp;
    }
}
