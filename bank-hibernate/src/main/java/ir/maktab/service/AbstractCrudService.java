package ir.maktab.service;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class AbstractCrudService<E extends BaseEntity<I>, I extends Serializable> {

    private BaseDao<E, I> baseDao;

    public BaseDao<E, I> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<E, I> baseDao) {
        this.baseDao = baseDao;
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
        baseDao.delete(entity);
        baseDao.getTransaction().commit();
    }

    public Optional<E> load(I id) {
        return Optional.ofNullable(baseDao.load(id));
    }

    public Optional<List<E>> loadAll() {
        return Optional.ofNullable(baseDao.loadAll());
    }

    public boolean contains(E entity) {
        return baseDao.contains(entity);
    }

    public boolean containsById(I id) {
        return baseDao.containsById(id);
    }

}
