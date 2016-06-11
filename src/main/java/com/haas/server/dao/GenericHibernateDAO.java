package com.haas.server.dao;

import com.haas.server.dao.interfaces.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T findById(ID id) throws Exception {
        return (T) getSession().get(getPersistentClass(), id);
    }

    @Override
    public List<T> findAll() throws Exception {

        List<T> result = getSession().createCriteria(getPersistentClass()).list();
        return result;
    }

    @Override
    public List<T> findByExample(T exampleInstance) throws Exception {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);

        crit.add(example);
        return crit.list();
    }

    @Override
    public T makePersistent(T entity) throws Exception {
        getSession().persist(entity);
        return entity;
    }

    @Override
    public void makeTransient(T entity) throws Exception {
        getSession().delete(entity);
    }

    @Override
    public T update(T entity) throws Exception {
        getSession().update(entity);
        return entity;
    }

}
