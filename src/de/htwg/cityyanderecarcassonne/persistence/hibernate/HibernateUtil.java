package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
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
