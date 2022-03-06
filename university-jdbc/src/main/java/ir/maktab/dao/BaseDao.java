package ir.maktab.dao;

import ir.maktab.entity.BaseEntity;
import ir.maktab.exception.DataNotFoundException;

import java.util.List;

public interface BaseDao<T extends BaseEntity<I>, I extends Number> {

    void save(T entity);

    void update(I id, T newEntity);

    void delete(I id);

    T loadById(I id);

    List<T> loadAll();

    default boolean contains(I id) {
        try {
            loadById(id);
        } catch (DataNotFoundException e) {
            return false;
        }
        return true;
    }

}
