package com.delivery.utils;

import jakarta.persistence.*;

public class EntityManagerUtils {

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }

    public static boolean save(Object o) {
        EntityTransaction transaction = getTransaction();

        try {
            transaction.begin();
            getEntityManager().persist(o);
            transaction.commit();
            return true;
        }
        catch (PersistenceException ignored) {
            System.out.println("error" + ignored);
            return false;
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

}
