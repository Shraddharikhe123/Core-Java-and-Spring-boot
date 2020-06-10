package com.techChallenge.techgig.dbconfig;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/*
 * This class Provides configuration for Database
 * */
@Component
public class DatabaseConfig{
    private final SessionFactory sessionFactory = buildSessionFactory();
@Bean
    public SessionFactory buildSessionFactory() {
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml");

            configuration.addAnnotatedClass(com.techChallenge.techgig.beans.BookingDetail.class)
                          .addAnnotatedClass(com.techChallenge.techgig.beans.RoomDetail.class)
                           .addAnnotatedClass(com.techChallenge.techgig.beans.MeetingRoomType.class)
                            .addAnnotatedClass(com.techChallenge.techgig.beans.Answer.class)
                            .addAnnotatedClass(com.techChallenge.techgig.beans.Question.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            SessionFactory factory = configuration.buildSessionFactory(builder.build());
            return factory;
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        getSessionFactory().close();
    }

}