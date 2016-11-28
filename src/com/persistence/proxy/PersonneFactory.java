package com.persistence.proxy;

import com.domain.Personne;
import com.persistence.mapper.PersonneMapper;

import java.sql.SQLException;

/**
 * Created by baptiste on 28/11/16.
 * Hi
 */
public class PersonneFactory implements Factory<Personne> {
    public Personne create() throws SQLException {
        return PersonneMapper.getInstance().findById(2);
    }
}
