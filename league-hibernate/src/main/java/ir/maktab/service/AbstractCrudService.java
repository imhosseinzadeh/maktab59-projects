package ir.maktab.service;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public class AbstractCrudService<E extends BaseEntity<I>, I extends Serializable> {

    private final BaseDao<E, I> baseDao;

    public AbstractCrudService(BaseDao<E, I> baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao<E, I> getBaseDao() {
        return baseDao;
    }

    public void saveOrUpdate(E entity) {
        baseDao.getTransaction().begin();
        if (entity.getId() == null) {
            baseDao.save(entity);
        } else {
            baseDao.update(entity);
        }
        baseDao.getTransaction().commit();
    }

    public void delete(E entity) {
        baseDao.getTransaction().begin();
        baseDao.delete(find(entity.getId()));
        baseDao.getTransaction().commit();
    }

    public E find(I id) {
        return baseDao.find(id);
    }

    public List<E> findAll() {
        return baseDao.findAll();
    }

    public boolean contains(E entity) {
        return baseDao.contains(entity);
    }

    public boolean existsById(I id) {
        return baseDao.existsById(id);
    }

}
