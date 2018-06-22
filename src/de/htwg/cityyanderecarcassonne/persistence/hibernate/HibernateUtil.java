package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private HibernateUtil() {}

    public static SessionFactory getInstance() {
        return sessionFactory;
    }
}
