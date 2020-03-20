package orm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KeyBillDao {

    public KeyBill findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(KeyBill.class, id);
    }

    public void save(KeyBill keyBill) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(keyBill);
        tx1.commit();
        session.close();
    }

    public void update(KeyBill keyBill) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(keyBill);
        tx1.commit();
        session.close();
    }

    public void delete(KeyBill keyBill) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(keyBill);
        tx1.commit();
        session.close();
    }

    public KeyBill get(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from KeyBill where id = :idParam");
            query.setParameter("idParam", id);
            KeyBill keyBill = (KeyBill) query.list().get(0);
            return keyBill;
        }catch (Exception e){
            return null;
        }
    }
}