package orm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

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
        Query query = session.createQuery("from Key where platform = " + platform + ", price = " + price
                + "id IN (SELECT MAX(id) id FROM Key)");
        Key key = (Key) query.list().get(0);
        return key;
    }
}