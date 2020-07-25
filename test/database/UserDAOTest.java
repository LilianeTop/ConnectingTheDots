package database;

import main.Main;
import model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void storeOneTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToStore = new User("Marit", null, "Seit", "marit@gmail.com", "reader");
        userDAO.storeOne(userToStore);
        User userToStore2 = new User("Martha", null, "Seiler", "martha_seler@gmail.com", "reader");
        userDAO.storeOne(userToStore2);
        User userToStore3 = new User("Marijke", "de", "Vries", "devries@gmail.com", "reader");
        userDAO.storeOne(userToStore3);

        User userToStoreTest = userDAO.getOneByEmailaddress(userToStore.getEmailaddress());
        User userToStoreTest2 = userDAO.getOneByEmailaddress(userToStore2.getEmailaddress());
        User userToStoreTest3 = userDAO.getOneByEmailaddress(userToStore3.getEmailaddress());

        Assert.assertTrue(userToStore.equals(userToStoreTest));
        Assert.assertTrue(userToStore.getUserName().equals(userToStoreTest.getUserName()));

        Assert.assertEquals(userToStore2, userToStoreTest2);
        Assert.assertEquals(userToStore3, userToStoreTest3);
    }


    @Test
    void getOneByUsernameTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToTest2 = userDAO.getOneByUsername("topxlili001");
        Assert.assertTrue(userToTest2.getLastName().equals("Top"));

        User userToTest = userDAO.getOneByUsername("JanTes1");

        Assert.assertTrue(userToTest.getLastName().equals("Jansen"));
        Assert.assertTrue(userToTest.getPassword().equals("12345"));

    }

    @Test
    void getUserByEmailaddressTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        User userToTest = userDAO.getOneByEmailaddress("tessa@deloo.nl");

        Assert.assertTrue(userToTest.getLastName().equals("Jansen"));
        Assert.assertTrue(userToTest.getUserName().equals("JanTes001"));

    }

    @Test
    void getAllTest() {
        //fixme: is there a better way to test this?
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        ArrayList<User> allUsers = userDAO.getAll();
        Assert.assertEquals(4, allUsers.size());
    }

    @Test
    void updateOneTest() {
    }

    /* void deleteOne() {
            questionDAO.deleteOne(3);
            assertFalse(testquestion3.equals(questionDAO.getOneById(3)));
        }*/
    @Test
    void deleteOneTest() {
        //fixme: passed the tests but it is not reflected in the db why?
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        User userToDelete1 = userDAO.getOneByUsername("VriMar001");
        userDAO.deleteOne(userToDelete1);

       /* User userToDelete2 = userDAO.getOneByEmailaddress("devries@gmail.com");
        User deletedUser2 = userDAO.deleteOne(userToDelete2);
        Assert.assertEquals(userToDelete2, deletedUser2);*/
    }
}