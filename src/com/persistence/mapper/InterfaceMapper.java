package com.persistence.mapper;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface des mappers
 */
public interface InterfaceMapper<T> {

	public void insert(T b) throws SQLException; 
	public void delete(T b) throws SQLException;
	public void update(T b) throws SQLException;
	public List<T> find() throws SQLException;
	public T findById(Integer id) throws SQLException;
}
