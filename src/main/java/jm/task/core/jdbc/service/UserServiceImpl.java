package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl userDAOService = new UserDaoJDBCImpl();
    public void createUsersTable() throws SQLException {
        userDAOService.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDAOService.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDAOService.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        userDAOService.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAOService.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDAOService.cleanUsersTable();
    }
}
