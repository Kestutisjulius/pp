package dao;
import model.Cart;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class UserDao {
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

    public List getUsersEmail(String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNamedQuery("get_email_from_user", User.class);
        query = query.setParameter("eMail", "%" + email + "%");
        List users = query.list();
        return users;
    }
    public List<User>getUserByFullName(String fullName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNamedQuery("get_user_by_fullName", User.class);
        query = query.setParameter("fullName", "%" + fullName+ "%");
        List<User> userList = query.list();
        return userList;
    }
    public void updateUser (User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public void deleteUser (User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }
    public void build3FirstUsers(){
        User user1 = new User(null, "Petras Petraitis", "petras@pastas.lt", false);
        User user2 = new User(null, "Jonas Jonaitis", "jonas@pastas.lt", false);
        User user3 = new User(null, "Vardenis Pavardenis", "vardenis@pastas.lt", true);
        System.out.println("new USER to DB...");
        createUser(user1);
        createUser(user2);
        createUser(user3);
    }


}
