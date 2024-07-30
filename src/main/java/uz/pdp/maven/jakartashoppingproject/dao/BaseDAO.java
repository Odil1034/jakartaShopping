package uz.pdp.maven.jakartashoppingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uz.pdp.maven.jakartashoppingproject.entity.BaseEntity;
import uz.pdp.maven.jakartashoppingproject.entity.user.User;

import java.io.Serializable;

public abstract class BaseDAO<T extends BaseEntity, ID extends Serializable> {

    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopping");

    protected static final EntityManager em = emf.createEntityManager();

    protected void begin() {
        em.getTransaction().begin();
    }

    protected void commit() {
        em.getTransaction().commit();
    }

    protected void rollback() {
        em.getTransaction().rollback();
    }

}
