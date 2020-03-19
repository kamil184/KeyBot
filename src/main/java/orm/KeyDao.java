package orm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KeyDao {

    public Key findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Key.class, id);
    }

    public void save(Key key) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(key);
        tx1.commit();
        session.close();
    }

    public void update(Key key) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(key);
        tx1.commit();
        session.close();
    }

    public void delete(Key key) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(key);
        tx1.commit();
        session.close();
    }

    public List<Key> findAll() {
        List<Key> users = (List<Key>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    public Key get(String platform, int price) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query idQuery = session.createQuery("SELECT Max(id) from Key where (platform = :platformParam and price = :priceParam and reserved is null)");
            idQuery.setParameter("platformParam", platform);
            idQuery.setParameter("priceParam", price);
            List idList = idQuery.list();
            int maxId = (int) idList.get(0);
            Query query = session.createQuery("from Key where id = :idParam");
            query.setParameter("idParam", maxId);
            Key key = (Key) query.list().get(0);
            return key;
        }catch (Exception e){
            return null;
        }
    }

    public void reserve(Key key, long chatId){
        key.setReserved(chatId);
        update(key);
    }
}