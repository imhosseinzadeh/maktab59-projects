package ir.maktab.service;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.BaseEntity;

import java.util.List;

public class AbstractCrudService<E extends BaseEntity<I>, I extends Number> {
    private BaseDao<E, I> baseDao;

    public BaseDao<E, I> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<E, I> baseDao) {
        this.baseDao = baseDao;
    }

    public void saveOrUpdate(E entity) {
        if (entity.getId() == null) {
            baseDao.save(entity);
        } else {
            baseDao.update(entity.getId(), entity);
        }
    }

    public void deleteById(I id) {
        baseDao.delete(id);
    }

    public E loadById(I id) {
        return baseDao.loadById(id);
    }

    public List<E> loadAll() {
        return baseDao.loadAll();
    }

    public boolean contains(I id) {
        return baseDao.contains(id);
    }

}
