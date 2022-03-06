package ir.maktab.hospital.dao;

import ir.maktab.hospital.entity.BaseEntity;

import java.io.Serializable;

public interface BaseDao<E extends BaseEntity<I>, I extends Serializable> {

    void save(E entity);

    E findById(I id);

}
