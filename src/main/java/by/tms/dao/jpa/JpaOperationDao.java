package by.tms.dao.jpa;

import by.tms.entity.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JpaOperationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveOperation(Operation operation) {
        entityManager.persist(operation);
        entityManager.close();
    }
}
