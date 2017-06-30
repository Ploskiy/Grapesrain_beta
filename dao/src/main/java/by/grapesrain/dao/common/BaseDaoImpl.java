package by.grapesrain.dao.common;

import by.grapesrain.entitys.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

/**
 * Created by Alexandr on 30.06.2017.
 */
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from " + modelClass.getSimpleName(), modelClass)
                .getResultList();
    }
}