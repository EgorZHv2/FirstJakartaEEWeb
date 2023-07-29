package core.domain.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildFactory();

    private static SessionFactory buildFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Exception ex){
            System.err.println("Error in session factory build process "+ ex);
        }
        return null;
    }
    public  static  SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutDown(){
        getSessionFactory().close();
    }
}
