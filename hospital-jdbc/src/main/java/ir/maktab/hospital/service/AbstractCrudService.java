package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.BaseDao;
import ir.maktab.hospital.entity.BaseEntity;

import java.io.Serializable;

public class AbstractCrudService<E extends BaseEntity<I>, I extends Serializable> {

    protected final BaseDao<E, I> baseDao;

    public AbstractCrudService(BaseDao<E, I> baseDao) {
        this.baseDao = baseDao;
    }

    public void save(E bed) {
        baseDao.save(bed);
    }

    public E findById(I id) {
        return baseDao.findById(id);
    }

}
