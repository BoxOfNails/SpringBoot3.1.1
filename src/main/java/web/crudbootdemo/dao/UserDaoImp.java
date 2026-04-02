package web.crudbootdemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.crudbootdemo.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private final EntityManager entityManager;

    public UserDaoImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAllUsers() {
        //create a query
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        // execute query and get result list
        List<User> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public User findById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        return theUser;
    }

    @Override
    public User save(User theUser) {
        User dbUser = entityManager.merge(theUser);
        return dbUser;
    }

    @Override
    public void deleteById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        entityManager.remove(theUser);
    }
}
