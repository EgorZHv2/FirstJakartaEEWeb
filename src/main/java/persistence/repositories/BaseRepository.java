package persistence.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import core.domain.entities.BaseEntityModel;
import core.domain.utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class BaseRepository<T extends BaseEntityModel> implements core.application.interfaces.IBaseRepository<T> {
    private final Class<T> modelclass;
    public BaseRepository(Class<T> modelclass) {
        this.modelclass = modelclass;
    }
    @Override
    public T getById(UUID id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var entity = session.get(modelclass, id);
        session.close();
        return entity;
    }
    @Override
    public void create(T entity) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public void update(T entity) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        try {
            session.merge(entity);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public void delete(UUID id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var entity = getById(id);
        var transaction = session.beginTransaction();
        try {
            session.remove(entity);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public List<T> getAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(modelclass);
        Root<T> variableRoot = criteriaQuery.from(modelclass);
        return session.createQuery(criteriaQuery).getResultList();
    }


}
