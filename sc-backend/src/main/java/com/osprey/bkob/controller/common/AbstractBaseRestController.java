package com.osprey.bkob.controller.common;

import com.osprey.bkob.domain.entities.BaseEntity;
import com.osprey.bkob.service.common.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.util.List;

public abstract class AbstractBaseRestController<E extends BaseEntity> implements BaseRestController<E> {

    protected abstract BaseService<E> getService();

    @Override
    public ResponseEntity<E> getById(Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        E result = getService().getById(id).get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



//
//    @Override
//    public ResponseEntity<E> getByName(String name) {
//        if(StringUtils.isEmpty(name)){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        E result = getService().getById().get();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<E> create(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> update(E entity) {

        E result = getService().update(entity);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        getService().delete(id);
    }

    @Override
    public void delete(E entity) {

    }

    @Override
    public ResponseEntity<Iterable<E>> getAll() {
        Iterable<E> result = getService().getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<E>> getAll(Iterable<Long> ids) {
        return null;
    }
}
