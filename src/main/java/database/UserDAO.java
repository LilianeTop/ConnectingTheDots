package database;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO<E> extends AbstractDAO implements GenericDAO<E> {
    public UserDAO(DBAccess dbAccess) {
        super(dbAccess);
    }

    @Override
    public void storeOne(E mpUser) {
        //Fixme: how to implement the genericDAO if I change Object to user I doesn't work unless I add <E> twice on line 9
        User user = (User) mpUser;
        String sql = "INSERT INTO User(firstName, prefix, lastName, emailaddress, role, userName, password) Values(?,?,?,?,?,?,?);";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getPrefix());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmailaddress());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getUserName());
            preparedStatement.setString(7, user.getPassword());
            executeManipulateStatement();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            System.out.println("This user is not registered");
        }
    }


    public User getOneByUsername(String mpUsername) {
        String sql = "SELECT * FROM User WHERE userName = ?";
        User user = null;
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, mpUsername);
            ResultSet resultSet = executeSelectStatement();
           /* if (resultSet == null || resultSet.next() == false) {
                return null;
            } else {*/
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String prefix = resultSet.getString("prefix");
                String lastName = resultSet.getString("lastName");
                String emailaddress = resultSet.getString("emailaddress");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                user = new User(firstName, prefix, lastName, emailaddress, role, mpUsername, password);
            }
            // }
        } catch (SQLException error) {
            System.out.println("This username does not exist");
        }
        return user;

    }

    public boolean checkIfUsernameExists(String mpUserName) {
        String sql = "Select count(*) from User Where userName = ?;";
        boolean userNameExists = false;
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, mpUserName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt(1) > 0) {
                    userNameExists = true;
                }
            }
        } catch (SQLException error) {
            System.out.println("SQL error: " + error.getMessage());
        }
        return userNameExists;
    }

    public User getOneByEmailaddress(String mpEmailaddress) {
        String sql = "SELECT * FROM User WHERE emailaddress = ?";
        User user = null;
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, mpEmailaddress);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String prefix = resultSet.getString("prefix");
                String lastName = resultSet.getString("lastName");
                String role = resultSet.getString("role");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                user = new User(firstName, prefix, lastName, mpEmailaddress, role);
            }
        } catch (SQLException error) {
            System.out.println("This emailaddress is not connected to an account");
        }
        return user;
    }


    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM User";
        ArrayList<User> usersList = new ArrayList<>();
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            User user;
            String firstName = resultSet.getString("firstName");
            String prefix = resultSet.getString("prefix");
            String lastName = resultSet.getString("lastName");
            String emailaddress = resultSet.getString("emailaddress");
            String role = resultSet.getString("role");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");

            user = new User(firstName, prefix, lastName, emailaddress, role);
            usersList.add(user);
        } catch (SQLException e) {
            System.out.println("SQL error " + e.getMessage());
        }
        return usersList;
    }

    @Override
    public void updateOne(E mpUser) {
        User user = (User) mpUser;
        String sql = "UPDATE Klant SET firstName = ?, prefix = ?, lastName = ?, emailaddress = ?, role = ?, password = ?  where userName = ?;";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getPrefix());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmailaddress());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getUserName());
            executeManipulateStatement();
        } catch (SQLException e) {
            System.out.println("SQL error " + e.getMessage());
        }
    }

    @Override
    public void deleteOne(E mpUser) {
        User user = (User) mpUser;
        String sql = "DELETE FROM User WHERE userName = ?";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            executeManipulateStatement();
        } catch (SQLException error) {
            System.out.println("SQL error: " + error.getMessage());
        }
    }
}
