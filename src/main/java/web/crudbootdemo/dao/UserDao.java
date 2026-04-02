package web.crudbootdemo.dao;

import web.crudbootdemo.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUsers();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
