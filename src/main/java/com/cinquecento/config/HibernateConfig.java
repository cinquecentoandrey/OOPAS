package com.cinquecento.config;

import com.cinquecento.model.domain.AnalyzeObj;
import com.cinquecento.model.domain.Param;
import com.cinquecento.model.domain.PrmValue;
import com.cinquecento.model.domain.SWOT;
import com.cinquecento.model.domain.SWOTDir;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addProperties(loadProperties());
            configuration.addAnnotatedClass(AnalyzeObj.class);
            configuration.addAnnotatedClass(Param.class);
            configuration.addAnnotatedClass(PrmValue.class);
            configuration.addAnnotatedClass(SWOT.class);
            configuration.addAnnotatedClass(SWOTDir.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {

        }
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = HibernateConfig.class.getClassLoader().getResourceAsStream("hibernate.properties")) {
            if (input == null) {
                return properties;
            }
            properties.load(input);
        }
        return properties;
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
