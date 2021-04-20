package dao;

import model.Supplier;
import model.SupplierName;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SupplierDao {

    public void createSupplier(Supplier supplier) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Inserting new Supplier");
        session.save(supplier);
        transaction.commit();

    }
    public void buildSuppliers(){

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
        createSupplier(supplierAibe);
        createSupplier(supplierMaxima);
        createSupplier(supplierIki);
        createSupplier(supplierNorfa);
        createSupplier(supplierRimi);


    }


}
