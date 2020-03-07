package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> userMap;
    private static long id=1L;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();

    }

    @Override
    public List<User> getUser() {
        return new ArrayList<>(userMap.values());
    }


    @Override
    public void saveUser(User user) {
        if(user.getId()<1){
            user.setId(id);
            id++;
        }
        userMap.put(user.getId(), user);
    }


    @Override
    public void removeUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public void setUsersInactive(){
        Set<Map.Entry<Long, User>> userSet = userMap.entrySet();
        for (Map.Entry<Long, User> user: userSet) {
            user.getValue().setActive(false);
        }
    }
}
