package by.grapesrain;

import by.grapesrain.entitys.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Alexandr on 29.05.2017.
 */
public class Test {
    public List<UserRole> showRole(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<UserRole> userRoles =
                session.createQuery("from UserRole", UserRole.class).getResultList();

        return userRoles;
    }
}