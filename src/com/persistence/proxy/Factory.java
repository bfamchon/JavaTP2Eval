package com.persistence.proxy;

import java.sql.SQLException;

import com.domaine.criteria.Criteria;

/**
 * Created by baptiste on 28/11/16.
 * Hi
 */
public interface Factory<T> {
    T create(Criteria critere) throws SQLException;
}
