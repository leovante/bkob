package com.osprey.bkob.controller.common;

import com.osprey.bkob.domain.entities.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseRestController<E extends BaseEntity> {

//    ResponseEntity<E> getByName(String name);

    ResponseEntity<E> getById(Long id);

    ResponseEntity<E> create(E entity);

    ResponseEntity<E> update(E entity);

//    void ban (Long id);
    void delete(Long id);

    void delete(E entity);

    ResponseEntity<Iterable<E>> getAll();

    ResponseEntity<List<E>> getAll(Iterable<Long> ids);



}
