package com.cinquecento;


import com.cinquecento.config.HibernateConfig;
import com.cinquecento.config.LiquibaseInit;
import com.cinquecento.model.domain.AnalyzeObj;
import com.cinquecento.model.domain.SWOT;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

public class App
{

    public static void main( String[] args )
    {
        LiquibaseInit.init();
        Session session = HibernateConfig.getSession();
        session.beginTransaction();


        session.getTransaction().commit();

        HibernateConfig.closeSessionFactory();
    }
}
