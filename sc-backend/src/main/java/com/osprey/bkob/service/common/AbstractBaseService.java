package com.osprey.bkob.service.common;

import com.osprey.bkob.domain.entities.BaseEntity;
import com.osprey.bkob.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public abstract class AbstractBaseService<E extends BaseEntity> implements BaseService<E> {
    //получение название типа класса и записываем в строку
    protected final String entityName = ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();



    protected abstract BaseRepository<E, Long> getRepository();


    private Logger logger = LoggerFactory.getLogger(this.getClass());// write into logs

    @Override
    public Optional<E> getById(Long id) {
        checkArgument(id != null, "Received incoming parameter null!");  //гугл ультилита- проверка на null
        Optional<E> entity = getRepository().findById(id);
        if (!entity.isPresent()) {
            throw new EntityNotFoundException(entityName.getClass() + "  nety  takogo");
        }
        return entity;
    }
//
//    @Override
//    public Optional<E> getByName(String name) {
//        checkArgument(StringUtils.isEmpty(name),"Received incoming parameter null!");
//        Optional<E> entity = getRepository()
//    }

    @Override
    public boolean exists(Long id) {
        checkArgument(id != null, "Received incoming parameter null!");
        return getRepository().existsById(id);
    }



    @Override
    public E create(E entity) {
        logger.info("create");
        checkArgument(entity != null, "Not null " + entityName + " is expected!");
      //  entity.setId(null);
        return getRepository().save(entity);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public E update(E entity) {
        logger.info("update");
        checkArgument(entity != null, "Not null " + entityName + " is expected!");
        checkExists(entity.getId());
        return getRepository().save(entity);
    }

//    @Override
//    public void ban(Long id) {
//        logger.info("ban");
//        checkArgument(id != null, "can not ban such user!");
//        checkExists(id);
//        Optional<E> entity = getRepository().findById(id);
//
//
//    }

    @Override
    public void delete(E entity) {
        logger.info("delete");
        checkArgument(entity != null, "cannot delete!");
        checkExists(entity.getId());
        getRepository().delete(entity);
    }

    @Override
    public void delete(Long id) {
        checkArgument(id != null, "can not delete!");
        checkExists(id);
        getRepository().deleteById(id);
    }

    @Override
    public Iterable<E> getAll(Iterable<Long> ids) {
        logger.info("findAll ");
        return getRepository().findAllById(ids);
    }

    @Override
    public Iterable<E> getAll() {
        logger.info("findAll ");
        return getRepository().findAll();
    }

    private void checkExists(long id) throws EntityNotFoundException {
        final boolean exists = getRepository().existsById(id);
        if (!exists) {
            logger.error("ID can not be null.");
            throw new EntityNotFoundException(entityName.getClass() + " with id " + id + " not exists!");
        }
    }

}
