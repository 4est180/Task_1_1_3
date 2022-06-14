package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl userDAOService = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDAOService.createUsersTable();
    }

    public void dropUsersTable() {
        userDAOService.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDAOService.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDAOService.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAOService.getAllUsers();
    }

    public void cleanUsersTable() {
        userDAOService.cleanUsersTable();
    }
}
