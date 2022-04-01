package by.tms.dao.jpa;

import by.tms.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JpaUserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    public User findById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public void remove(User user) {
        entityManager.remove(user);
        entityManager.close();
    }

    public void update(User user) {
        entityManager.merge(user);
        entityManager.close();
    }

    public List<User> findAllByName(String name) {
        TypedQuery<User> query = entityManager.createQuery(CONSTANT.findAllByName, User.class);
        List<User> resultLst = query.getResultList();
        entityManager.close();
        return resultLst;
    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery(CONSTANT.findAll, User.class);
        List<User> resultLst = query.getResultList();
        entityManager.close();
        return resultLst;
    }

    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery(CONSTANT.findByUsername, User.class);
        query.setParameter("name", username);
        User singleResult = query.getSingleResult();
        entityManager.close();
        return singleResult;
    }
}
