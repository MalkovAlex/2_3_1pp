package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUser(long id);

    List<User> getList();

    void updateUser(long id, User user);

    void deleteUser(long id);

    void deleteUser(User user);

    List<User> findUser(User user);
}
