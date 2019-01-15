package com.osprey.bkob.service.common;

import com.osprey.bkob.domain.entities.BaseEntity;

import java.util.Optional;

public interface BaseService <E extends BaseEntity>{

    Optional<E> getById(Long id);
    boolean exists(Long id);
    E create(E entity);
    long count();
    E update(E entity);
    void delete(Long id);
    void delete(E entity);
    Iterable<E> getAll(Iterable<Long> ids);
    Iterable<E> getAll();
//    void ban (Long id);
}
