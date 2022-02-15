package com.training.app.dao.base;


import java.util.List;

public interface CrudGenericDao<ID, T> {

    ID create(T object);

    T findById(ID id);

    boolean update(T object);

    List<T> findAll();
}
