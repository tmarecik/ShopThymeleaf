package pl.edu.wszib.dao;


import pl.edu.wszib.domain.User;

import java.util.List;


public interface UserDao {

    List<User> getUser();

    void saveUser(User user);

    void removeUser(Long id);

    User getById(Long id);

    void setUsersInactive();
}
