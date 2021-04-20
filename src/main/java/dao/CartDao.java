package dao;

import model.Cart;
import model.Product;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class CartDao {

    public void createCart (Cart cart) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("creating CART");
        session.save(cart);
        transaction.commit();
    }
    public void deleteCart(Cart cart) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cart);
        transaction.commit();
    }
    public void updateCart(Cart cart){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
    }

    public Cart getCartById(Long id){
        Cart cart = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            cart = session.find(Cart.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

    public static void createTestCart(Long id){
        Cart cart = new Cart();
        cart.setCartId(id);
        Set<Product> newProducts = new HashSet<>();
        Product product = ProductDao.getProduct(1L);
        System.out.println("Product ID: " + product.getId());
        newProducts.add(product);
        //newProducts.add(ProductDao.getProduct(3L));
        //newProducts.add(ProductDao.getProduct(5L));
        cart.setProducts(newProducts);
        CartDao cartDao = new CartDao();
        cartDao.createCart(cart);
    }




}
