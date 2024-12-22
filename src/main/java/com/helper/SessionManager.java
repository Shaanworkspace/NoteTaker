package com.helper;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class SessionManager {
    //to give session in all we need to call it here not private as we need to give it to the different classes
    public static SessionFactory factory;

    public static SessionFactory getFactory(){
        if(factory==null){
            factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return factory;
    }

    public void closeFactory(){
        if(factory.isOpen()){
            factory.close();
        }
    }

}
