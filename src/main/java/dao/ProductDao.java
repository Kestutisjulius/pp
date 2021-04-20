package dao;

import model.Cart;
import model.Product;
import model.Supplier;
import model.SupplierName;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ProductDao {

    public void createProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(" INSERTING new PRODUCT");
        session.save(product);
        transaction.commit();
    }

    public void build6FirstProducts(){

        Supplier supplierMaxima = new Supplier();
        Supplier supplierRimi = new Supplier();
        Supplier supplierNorfa = new Supplier();
        Supplier supplierIki = new Supplier();
        Supplier supplierAibe = new Supplier();
        supplierMaxima.setName(SupplierName.MAXIMA.name());
        supplierIki.setName(SupplierName.IKI.name());
        supplierRimi.setName(SupplierName.RIMI.name());
        supplierNorfa.setName(SupplierName.NORFA.name());
        supplierAibe.setName(SupplierName.AIBE.name());
        supplierMaxima.setId(1L);
        supplierRimi.setId(2L);
        supplierNorfa.setId(3L);
        supplierIki.setId(4L);
        supplierAibe.setId(5L);


        Product product1 = new Product(null, "Nokia Phone" , 322.22, 5);
        Product product2 = new Product(null, "Samsung" , 625.12, 6);
        Product product3 = new Product(null, "Iphone" , 750.99, 10);
        Product product4 = new Product(null, "Huawei" , 399.99, 10);
        Product product5 = new Product(null, "Xiaomi" , 150.75, 3);
        Product product6 = new Product(null, "LG" , 450.25, 10);
        System.out.println("new product to DB...");
        createProduct(product1);
        createProduct(product2);
        createProduct(product3);
        createProduct(product4);
        createProduct(product5);
        createProduct(product6);
    }
    public static Product getProduct(Long id){
        Product product = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            product = session.find(Product.class, id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return product;
    }
    public void deleteProduct(Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
    }
    public void updateProduct (Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
    }
    public List<Product> getProductByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNamedQuery("get_product_by_name", Product.class);
        query = query.setParameter("name", "%" + name + "%");
        List<Product> products = query.list();
        return products;
    }

}
