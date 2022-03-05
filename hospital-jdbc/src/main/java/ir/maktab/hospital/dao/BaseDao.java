package ir.maktab.hospital.dao;

import ir.maktab.hospital.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

    void save(E entity);

    E findById(int id);

}
