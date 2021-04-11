package util;

import model.Cart;
import model.Product;
import model.Supplier;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/superUser?serverTimezone=UTC");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "4LGq8GuThVkNpFvR_$");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "create");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Supplier.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(Cart.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
    public static void shutDown(){
        getSessionFactory().close();
    }
}
