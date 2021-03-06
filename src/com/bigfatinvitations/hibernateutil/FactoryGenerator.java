package com.bigfatinvitations.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.bigfatinvitations.pojo.Message;
import com.bigfatinvitations.pojo.MessageViki;

public class FactoryGenerator
{

    public static final SessionFactory sessionFactory;
    static
    {
        sessionFactory = getSessionFactory();
    }

    private static SessionFactory getSessionFactory()
    {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Message.class);
        configuration.addAnnotatedClass(MessageViki.class);
        configuration.configure();
        return configuration.buildSessionFactory(
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
    }

}
