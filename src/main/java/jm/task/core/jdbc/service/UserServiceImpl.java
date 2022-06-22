package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl userDAOService = new UserDaoJDBCImpl();

    public UserServiceImpl() {
    }

    public void createUsersTable() throws SQLException, ClassNotFoundException {
        userDAOService.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        userDAOService.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        userDAOService.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
        userDAOService.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDAOService.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException, ClassNotFoundException {
        userDAOService.cleanUsersTable();
    }
}
