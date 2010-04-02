package org.assembly.nornas.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Clase base de todos los daos.
 *
 * @author Emanuel
 */
public abstract class BaseDao<T> extends HibernateDaoSupport{

    protected abstract Class<T> getClase();

    protected Class<T> persistentClass = getClase();

    public List<T> findAll() {
        return this.getHibernateTemplate().find("from " +persistentClass.getName());
    }

    public T findBy(Serializable id) {
        return (T) this.getHibernateTemplate().get(persistentClass, id);
    }

    public List<T> findBy(T ejemplo) {
        return this.getHibernateTemplate().findByExample(ejemplo);
    }

    public Long count() {
        Query query = this.getSession().createQuery("select count(*) from "+persistentClass.getName());
        return (Long) query.uniqueResult();
    }

    public void save(T entidadPersistible) {
        this.getHibernateTemplate().save(entidadPersistible);
    }

    public void update(T entidadPersistible) {
        this.getHibernateTemplate().update(entidadPersistible);
    }

    public void saveOrUpdate(T entidadPersistible) {
        this.getHibernateTemplate().saveOrUpdate(entidadPersistible);
    }

    public void delete(T entidadPersistible) {
        this.getHibernateTemplate().delete(entidadPersistible);
    }

    public void deleteBy(Serializable id) {
        T entidadPersistible = this.findBy(id);
        this.getHibernateTemplate().delete(entidadPersistible);
    }   


}
