package com.haas.server.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    List<T> findAll();

    T findById(ID id);

    List<T> findByExample(T exampleInstance);

    T makePersistent(T entity);

    void makeTransient(T entity);

    T update(T entity);
}
