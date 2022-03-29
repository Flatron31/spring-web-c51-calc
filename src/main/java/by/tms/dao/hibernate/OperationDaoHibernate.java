package by.tms.dao.hibernate;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class OperationDaoHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOperation(Operation operation){
        Session session = sessionFactory.openSession();
        session.save(operation);
        session.close();
    }

//    public List<Operation> findAllOperationUser(long userId) {
//        Session session = sessionFactory.openSession();
//        Query<Operation> query = session.createQuery("from Operation where User.id = :userId", Operation.class);
//        query.setParameter("userId", userId);
//        List<Operation> operationList = query.getResultList();
//        session.close();
//        return operationList;
//    }

}
