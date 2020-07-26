package database;

import main.Main;
import model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    //fixme: refactor code as there is much duplication

    @Test
    void storeOneTest() {
        //fixme: check if the emailaddres is already in db if so you can't register twice with same emailaddress
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToStore = new User("Mildred", "last", "Hope", "hope@gmail.com", "reader");
        userDAO.storeOne(userToStore);
        User userToStoreTest = userDAO.getOneByEmailaddress(userToStore.getEmailaddress());
        Assert.assertTrue(userToStore.equals(userToStoreTest));

        User userToStore2 = new User("Roos", null, "Langzaam", "rosita3@gmail.com", "storyteller");
        userDAO.storeOne(userToStore2);
        User userToStoreTest2 = userDAO.getOneByEmailaddress(userToStore2.getEmailaddress());
        Assert.assertTrue(userToStore2.getLastName().equals(userToStoreTest2.getLastName()));
        Assert.assertTrue(userToStore2.getUserName().equals(userToStoreTest2.getUserName()));
        Assert .assertTrue(userToStore2.getPassword().equals(userToStoreTest2.getPassword()));

         User userToStore3 = new User("Maartje", "de", "Hythe", "maartje@gmail.com", "reader");
        userDAO.storeOne(userToStore3);
        User userToStoreTest3 = userDAO.getOneByEmailaddress(userToStore3.getEmailaddress());
        Assert.assertTrue(userToStore3.getFirstName().equals(userToStoreTest3.getFirstName()));
        Assert.assertEquals(userToStore3, userToStoreTest3);
    }


    @Test
    void getOneByUsernameTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToTest = userDAO.getOneByUsername("JanTes1");
        Assert.assertTrue(userToTest.getLastName().equals("Jansen"));
        Assert.assertEquals(userToTest.getPassword(),"12345");

        User userToTest2 = userDAO.getOneByUsername("topxlili001");
        Assert.assertTrue(userToTest2.getLastName().equals("Top"));
        Assert.assertTrue(userToTest2.getFirstName().equals("Liliane"));
        Assert.assertTrue(userToTest2.getEmailaddress().equals("hallo@lilianetop.nl"));
        Assert.assertTrue(userToTest2.getRole().equals("admin"));
        Assert.assertTrue(userToTest2.getPassword().equals("1234"));
    }

    @Test
    void getUserByEmailaddressTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToTest = userDAO.getOneByEmailaddress("tessa@deloo.nl");
        Assert.assertTrue(userToTest.getLastName().equals("Jansen"));
        Assert.assertTrue(userToTest.getUserName().equals("JanTes1"));

        User userToTest2 = userDAO.getOneByEmailaddress("hallo@lilianetop.nl");
        Assert.assertTrue(userToTest2.getLastName().equals("Top"));
        Assert.assertTrue(userToTest2.getUserName().equals("topxlili001"));

        User userToTest3 = userDAO.getOneByEmailaddress("maartje@gmail.com");
        Assert.assertTrue(userToTest3.getLastName().equals("Hythe"));
        String expected = "HytMaa001";
        String actual = userToTest3.getUserName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAllTest() {
        //fixme: is there a better way to test this?
        UserDAO userDAO = new UserDAO(Main.getDBAccess());
        ArrayList<User> allUsers = userDAO.getAll();
        Assert.assertEquals(17, allUsers.size());
    }

    @Test
    void updateOneTest() {
    }


    @Test
    void deleteOneTest() {
        UserDAO userDAO = new UserDAO(Main.getDBAccess());

        User userToDelete1 = userDAO.getOneByUsername("LuiRos001");
        userDAO.deleteOne(userToDelete1);
        User deletedUser = userDAO.getOneByUsername("LuiRos001");
        Assert.assertTrue(deletedUser == null);

        User userToDelete2 = userDAO.getOneByEmailaddress("m.teil@gmail.com");
        userDAO.deleteOne(userToDelete2);
        User deletedUser2 = userDAO.getOneByUsername("TeiMar003");
        Assert.assertTrue(deletedUser2 == null);
    }
}