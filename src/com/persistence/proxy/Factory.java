package com.persistence.proxy;

import java.sql.SQLException;

/**
 * Created by baptiste on 28/11/16.
 * Hi
 */
public interface Factory<T> {
    T create() throws SQLException;
}
