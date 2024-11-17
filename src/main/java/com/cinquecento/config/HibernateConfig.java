package com.cinquecento.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
