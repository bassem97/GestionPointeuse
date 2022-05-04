package com.spring.gestionpointeuse.Service;

import java.util.List;

public interface ICrudService<T, ID> {
    T add(T t);
    T update(T t, ID id);
    void delete(ID id);
    List<T> findAll();
    T findById(ID id);
}
