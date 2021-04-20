package dao;
import model.Cart;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //Cart cart = CartDao.createTestCart();
        Set<Cart> user1Carts = new HashSet<>();
        CartDao cartDao = new CartDao();
        user1Carts.add(cartDao.getCartById(1L));
        User user1 = new User(null, "Petras Petraitis", "petras@pastas.lt", false,null);
        User user2 = new User(null, "Jonas Jonaitis", "jonas@pastas.lt", false,null);
        User user3 = new User(null, "Vardenis Pavardenis", "vardenis@pastas.lt", true,null);
        System.out.println("new USER to DB...");
        createUser(user1);
        createUser(user2);
        createUser(user3);

    }


}
