package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.execute("CREATE TABLE IF NOT EXISTS Users(id INT AUTO_INCREMENT,name VARCHAR(45) NOT NULL,lastName VARCHAR(45) NOT NULL,age INT(3) NOT NULL,PRIMARY KEY (id))");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public void dropUsersTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.execute("DROP TABLE IF EXISTS Users");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        User user = new User(name, lastName, age);
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users VALUES(id,?,?,?)")) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getName());
            connection.commit();
            preparedStatement.setString(2, user.getLastName());
            connection.commit();
            preparedStatement.setByte(3, user.getAge());
            connection.commit();
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

        public void removeUserById ( long id) throws SQLException {

            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE id=?")) {
                connection.setAutoCommit(false);
                preparedStatement.setLong(1, id);
                connection.commit();
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
            }
        }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            connection.commit();

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {

            try (PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE TABLE Users")) {
                connection.setAutoCommit(false);
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
            }

    }
}
