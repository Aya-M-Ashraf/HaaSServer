package com.haas.server.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    List<T> findAll() throws Exception;

    T findById(ID id) throws Exception;

    List<T> findByExample(T exampleInstance) throws Exception;

    T makePersistent(T entity) throws Exception;

    void makeTransient(T entity)throws Exception;

    T update(T entity)throws Exception;
}
