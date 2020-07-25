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

        /*User userToStore = new User("Marga", "van", "Seibersma", "marge@gmail.com", "reader");
        userDAO.storeOne(userToStore);
        User userToStoreTest = userDAO.getOneByEmailaddress(userToStore.getEmailaddress());
        Assert.assertTrue(userToStore.equals(userToStoreTest));*/
        //fixme: it creates another username if number 001 exists and gives a 002 but it doesn't give a 003 why not?
        User userToStore2 = new User("Margreet", null, "Teil", "m.teil@gmail.com", "storyteller");
        userDAO.storeOne(userToStore2);
        User userToStoreTest2 = userDAO.getOneByEmailaddress(userToStore2.getEmailaddress());
        Assert.assertTrue(userToStore2.equals(userToStoreTest2));
        Assert.assertTrue(userToStore2.getUserName().equals(userToStoreTest2.getUserName()));

         /*User userToStore3 = new User("Marijke", "de", "Vries", "devries@gmail.com", "reader");
        userDAO.storeOne(userToStore3);*/
        // User userToStoreTest3 = userDAO.getOneByEmailaddress(userToStore3.getEmailaddress());


    }


    @Test
    void getOneByUsernameTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        User userToTest = userDAO.getOneByUsername("JanTes1");
        Assert.assertTrue(userToTest.getLastName().equals("Jansen"));

        User userToTest2 = userDAO.getOneByUsername("topxlili001");
        Assert.assertTrue(userToTest2.getLastName().equals("Top"));
        Assert.assertTrue(userToTest2.getFirstName().equals("Liliane"));
        Assert.assertTrue(userToTest2.getEmailaddress().equals("hallo@lilianetop.nl"));
        Assert.assertTrue(userToTest2.getRole().equals("admin"));
        Assert.assertTrue(userToTest2.getPassword().equals("1234"));//it gives an Assertion error which shouldn't


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