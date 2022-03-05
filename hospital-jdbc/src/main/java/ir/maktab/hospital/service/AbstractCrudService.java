package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.BaseDao;
import ir.maktab.hospital.entity.BaseEntity;

public class AbstractCrudService<E extends BaseEntity> {

    protected final BaseDao<E> baseDao;

    public AbstractCrudService(BaseDao<E> baseDao) {
        this.baseDao = baseDao;
    }

    public void save(E bed) {
        baseDao.save(bed);
    }

    public E findById(int id) {
        return baseDao.findById(id);
    }

}
