package dao;

import model.Product;
import model.Supplier;
import model.SupplierName;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDateTime;

public class ProductDao {

    public void createProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(" INSERTING new PRODUCT");
        session.save(product);
        transaction.commit();
    }

    public void build6FirstProducts(){
        Supplier supplier = new Supplier(null,SupplierName.MAXIMA,Set <Product> p );

        Product product1 = new Product(null, "Nokia Phone" , 322.22, 20, 5,  null, SupplierName.MAXIMA);
        System.out.println("new product to DB...");
        createProduct(product1);
    }
}
