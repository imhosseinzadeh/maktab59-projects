package ir.maktab.dao;

import ir.maktab.entity.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDao<E extends BaseEntity<I>, I extends Serializable> {

    protected static final EntityManagerFactory MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("persistence");

    protected final EntityManager entityManager =
            MANAGER_FACTORY.createEntityManager();

    protected abstract Class<E> getEntityClass();

    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }

    public void save(E entity) {
        entityManager.persist(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }

    public void delete(E entity) {
        entityManager.remove(entity);
    }

    public E find(I id) {
        return entityManager.find(getEntityClass(), id);
    }

    public List<E> findAll() {
        return entityManager.createQuery("SELECT a FROM " + getEntityClass().getSimpleName() + " a ", getEntityClass())
                .getResultList();
    }

    public boolean contains(E entity) {
        return entityManager.contains(entity);
    }

    public boolean existsById(I id) {
        return find(id) != null;
    }
}
