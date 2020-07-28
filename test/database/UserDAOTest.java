package database;

import main.Main;
import model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    UserDAO userDAO = new UserDAO(Main.getDBAccess());

    //fixme: refactor code as there is much duplication
    //fixme: find a procedure that makes testing easier as in delete the ones you stored etc. Is there an existing protocol to follow?

    @Test
    void storeOneTest() {
        //fixme: check if the emailaddres is already in db if so you can't register twice with same emailaddress
        User userToStore = new User("Mildred", "last", "Hope", "hope@gmail.com", "reader");
        userDAO.storeOne(userToStore);
        User userToStoreTest = userDAO.getOneByEmailaddress(userToStore.getEmailaddress());
        assertTrue(userToStore.equals(userToStoreTest));

        User userToStore2 = new User("Roos", null, "Langzaam", "rosita3@gmail.com", "storyteller");
        userDAO.storeOne(userToStore2);
        User userToStoreTest2 = userDAO.getOneByEmailaddress(userToStore2.getEmailaddress());
        assertTrue(userToStore2.getLastName().equals(userToStoreTest2.getLastName()));
        assertTrue(userToStore2.getUserName().equals(userToStoreTest2.getUserName()));
        assertTrue(userToStore2.getPassword().equals(userToStoreTest2.getPassword()));

        User userToStore3 = new User("Maartje", "de", "Hythe", "maartje@gmail.com", "reader");
        userDAO.storeOne(userToStore3);
        User userToStoreTest3 = userDAO.getOneByEmailaddress(userToStore3.getEmailaddress());
        assertTrue(userToStore3.getFirstName().equals(userToStoreTest3.getFirstName()));
        assertEquals(userToStore3, userToStoreTest3);
    }

    @Test
    void getOneByUsernameTest() {
        User userToTest = userDAO.getOneByUsername("JanTes1");
        assertTrue(userToTest.getLastName().equals("Jansen"));
        assertEquals(userToTest.getPassword(), "12345");

        User userToTest2 = userDAO.getOneByUsername("topxlili001");
        assertTrue(userToTest2.getLastName().equals("Top"));
        assertTrue(userToTest2.getFirstName().equals("Liliane"));
        assertTrue(userToTest2.getEmailaddress().equals("hallo@lilianetop.nl"));
        assertTrue(userToTest2.getRole().equals("admin"));
        assertTrue(userToTest2.getPassword().equals("1234"));
    }

    @Test
    void getOneByEmailaddressTest() {
        User userToTest = userDAO.getOneByEmailaddress("tessa@deloo.nl");
        assertTrue(userToTest.getLastName().equals("Jansen"));
        assertTrue(userToTest.getUserName().equals("JanTes1"));
        assertTrue(userToTest.getPassword().equals("12345"));

        User userToTest2 = userDAO.getOneByEmailaddress("hallo@lilianetop.nl");
        assertTrue(userToTest2.getLastName().equals("Top"));
        assertTrue(userToTest2.getUserName().equals("topxlili001"));

        User userToTest3 = userDAO.getOneByEmailaddress("maartje@gmail.com");
        assertTrue(userToTest3.getLastName().equals("Hythe"));
        String expected = "HytMaa002";
        String actual = userToTest3.getUserName();
        assertEquals(expected, actual);
    }

    @Test
    void getAllTest() {
        //fixme: is there a better way to test this? access db and use count(*)?
        ArrayList<User> allUsers = userDAO.getAll();
        assertEquals(17, allUsers.size());
    }

    @Test
    void getAllByRoleTest() {
        //fixme: is there a better way to test this?
        ArrayList allReaders = userDAO.getAllByRole("reader");
        ArrayList allAdmin = userDAO.getAllByRole("admin");
        ArrayList allCommenters = userDAO.getAllByRole("commenter");
        ArrayList allStorytellers = userDAO.getAllByRole("storyteller");

        assertTrue(allReaders.size() == 7);
        assertTrue(allAdmin.size() == 1);
        assertTrue(allCommenters.size() == 0);
        assertTrue(allStorytellers.size() == 9);
    }

    @Test
    void updateOneTest() {
        User userToUpdate = userDAO.getOneByEmailaddress("hope@gmail.com");
        userToUpdate.setEmailaddress("hope2@gmail.com");
        userToUpdate.setPassword("MyOwnPassword");
        userDAO.updateOne(userToUpdate);

        User updatedUser = userDAO.getOneByUsername("HopMil002");
        assertEquals("hope2@gmail.com", updatedUser.getEmailaddress());
        assertEquals("MyOwnPassword", updatedUser.getPassword());

        User userToUpdate2 = userDAO.getOneByEmailaddress("hallo@lilianetop.nl");
        userToUpdate2.setPassword("Top1234");
        userDAO.updateOne(userToUpdate2);
        assertEquals("Top1234", userToUpdate2.getPassword());

    }

    @Test
    void deleteOneTest() {
        User userToDelete1 = userDAO.getOneByUsername("HopMil001");
        userDAO.deleteOne(userToDelete1);
        User deletedUser = userDAO.getOneByUsername("HopMil001");
        assertTrue(deletedUser == null);

        User userToDelete2 = userDAO.getOneByEmailaddress("rosita3@gmail.com");
        userDAO.deleteOne(userToDelete2);
        User deletedUser2 = userDAO.getOneByUsername(userToDelete2.getUserName());
        assertTrue(deletedUser2 == null);
    }


    @Test
    void checkIfUsernameExistsTest() {
        Boolean usernameToCheck = userDAO.checkIfUsernameExists("HopMil001");
        assertFalse(usernameToCheck);

        Boolean usernameToCheck2 = userDAO.checkIfUsernameExists("LanRoo001");
        assertTrue(usernameToCheck2);
    }

    @Test
    void checkIfEmailaddressExists() {
        Boolean emailaddressToCheck = userDAO.checkIfEmailaddressExists("rosita6@gmail.com");
        assertFalse(emailaddressToCheck);

        Boolean emailaddressToCheck2 = userDAO.checkIfEmailaddressExists("hallo@lilianetop.nl");
        assertTrue(emailaddressToCheck2);
    }
}