package model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static List execute(String hql, Object[][] parameters, int firstResult, Integer maxResults) {
        Session session = openSession();
        try {
            Query query = session.createQuery(hql);
            if (parameters != null) {
                for (Object[] parameter : parameters) {
                    query.setParameter(parameter[0].toString(), parameter[1]);
                }
            }
            query.setFirstResult(firstResult);
            if (maxResults != null) {
                query.setMaxResults(maxResults);
            }
            return query.list();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Object get(Class clazz, Serializable serializable) {
        Session session = openSession();
        try {
            return session.get(clazz, serializable);
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static boolean saveOrUpdate(Object object) {
        Session session = openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            hibernateException.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(Object object) {
        Session session = openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            hibernateException.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}