package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoHibernate {
    @Autowired
    private SessionFactory sessionFactory;


    public void save(User user){
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    public User findById(long id){
        Session session = sessionFactory.openSession();// коррентсесию
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void remove(User user){
        Session session = sessionFactory.openSession(); //посмотреть ремув как разбирает юзера
        session.remove(user);
        session.close();
    }

    public void update(User user){
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
    }

    public List<User> findAllByName(String name){
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where name = :name", User.class);
        query.setParameter("name", name);
        List<User> resultLst = query.getResultList();
        session.close();

        //query.getSingleResult();// если будет больше одного то ексепшен
        return resultLst;
    }

    public List<User> findAll(){
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> resultLst = query.getResultList();
        session.close();
        return resultLst;
    }
    public User findByUsername(String username){
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where name = :name", User.class);
        query.setParameter("name", username);
        User singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }




}
