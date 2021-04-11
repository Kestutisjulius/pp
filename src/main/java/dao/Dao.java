package dao;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class Dao {
    public void createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Inserting new USER");
        session.save(user);
        transaction.commit();

    }
    public User getUserById(Long id){
      User user = null;
      try {
          Session session = HibernateUtil.getSessionFactory().openSession();
          user = session.find(User.class, id);
      } catch (Exception e) {
          e.printStackTrace();
      }
        return user;
    }

    public List getUsersEmail(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNamedQuery("get_email_from_user", User.class);
        query = query.setParameter("eMail", "*");
        List users = query.list();
        return users;
    }
}
