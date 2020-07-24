package database;

import main.Main;
import model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void storeOne() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        User userToStore = new User("Marit", null, "Seit", "marit@gmail.com", "reader");
        Assert.assertTrue(userToStore.getLastName().equals("Seit"));
//fixme: check what the output is hence different test

        Assert.assertTrue(userToStore.getUserName().equals("SeiMar001"));

    }


    @Test
    void getOneByUsername() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToTest2 = userDAO.getOneByUsername("topxlili001");
        Assert.assertTrue(userToTest2.getLastName().equals("Top"));

        User userToTest = userDAO.getOneByUsername("JanTes1");

        Assert.assertTrue(userToTest.getLastName().equals("Jansen"));
        Assert.assertTrue(userToTest.getPassword().equals("12345"));

    }

    @Test
    void getUserByEmailaddress() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        User userToTest = userDAO.getUserByEmailaddress("tessa@deloo.nl");

        Assert.assertTrue(userToTest.getLastName().equals("Janssen"));
        Assert.assertTrue(userToTest.getUserName().equals("JanTes001"));

    }

    @Test
    void getAll() {
    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }
}