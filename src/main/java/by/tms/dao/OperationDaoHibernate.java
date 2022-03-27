package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;
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


}
